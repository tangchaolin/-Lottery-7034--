package cn.itedus.lottery.application.mq.producer;

import cn.itedus.lottery.application.mq.KafkaProducer;
import cn.itedus.lottery.domain.activity.model.vo.ActivityPartakeRecordVO;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.network.Send;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * @description: MQ 消息发送服务
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class Producer {


    private Logger logger = LoggerFactory.getLogger(Producer.class);
    /**
     * MQ主题  ：中奖发货单
     */
    public static final String TOPIC_INVOICE = "lottery_invoice";

    public static final String TOPIC_ACTIVITY_PARTAKE = "lottery_activity_partake";

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送中奖物品发货单消息
     * @param invoice 发送中奖物品发货单消息
     * @return invoice 发货单
     */
    public ListenableFuture<SendResult<String, Object>> sendLotteryInvoice(InvoiceVO invoice) {
        String objJson = JSON.toJSONString(invoice);
        logger.info("发送MQ消息 (中奖发货单) topic：{} UId：{} message：{}",TOPIC_INVOICE,invoice.getUId(),objJson);
        return kafkaTemplate.send(TOPIC_INVOICE, objJson);
    }

    /**
     * 发送领取活动记录MQ
     * @param activityPartakeRecord
     * @return 领取活动记录
     */
    public ListenableFuture<SendResult<String,Object>> sendLotteryActivityPartakeRecord(ActivityPartakeRecordVO activityPartakeRecord) {

        String objJson = JSON.toJSONString(activityPartakeRecord);

        logger.info("发送MQ消息（领取活动记录） topic ：{} UId：{} message：{}",TOPIC_ACTIVITY_PARTAKE,activityPartakeRecord.getUId(),objJson);
        return kafkaTemplate.send(TOPIC_ACTIVITY_PARTAKE, objJson);

    }







}
