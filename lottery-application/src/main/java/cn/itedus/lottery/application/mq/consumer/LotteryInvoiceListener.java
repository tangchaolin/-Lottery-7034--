package cn.itedus.lottery.application.mq.consumer;

import cn.hutool.core.lang.Assert;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
import cn.itedus.lottery.domain.award.model.req.GoodsReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;
import cn.itedus.lottery.domain.award.service.facotory.DistributionGoodsFactory;
import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @description: 中奖发货单监听消息
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class LotteryInvoiceListener {
    private Logger logger = LoggerFactory.getLogger(LotteryInvoiceListener.class);

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;


    @KafkaListener(topics = "lottery_invoice", groupId = "lottery")
    public void onMessage(ConsumerRecord<?,?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> message = Optional.ofNullable(record.value());


        //1.判断消息是否存在
        if (!message.isPresent()) {
            return;

        }
        //2.处理MQ消息
        try {
            //1.转化对象 （或者你也可以重写Serializer（T)
            InvoiceVO invoiceVO = JSON.parseObject((String) message.get(), InvoiceVO.class);
            //2.获取发送奖品工厂，执行发奖
            IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionService(invoiceVO.getAwardType());
            DistributionRes distributionRes = distributionGoodsService.doDistribution(new GoodsReq(invoiceVO.getUId(),
                    invoiceVO.getOrderId(), invoiceVO.getAwardId(), invoiceVO.getAwardName(), invoiceVO.getAwardContent()));

            Assert.isTrue(Constants.AwardState.SUCESS.getCode().equals(distributionRes.getCode()),distributionRes.getInfo());

            //3.打印日志
            logger.info("消费MQ消息，完成，完成 topic:{} bizId:{} 发奖结果：{}",topic,invoiceVO.getUId(),JSON.toJSONString(distributionRes));

            //4.消息消费完成
            ack.acknowledge();

        } catch (Exception e) {
            //发奖环节失败，消息重试，所有环节，发货、更新库，都需要保证幂等。
            logger.error("消费MQ消息，失败 topic：{} message：{}",topic,message.get());
            throw e;
        }


    }

}
