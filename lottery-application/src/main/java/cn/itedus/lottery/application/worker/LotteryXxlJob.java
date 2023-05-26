package cn.itedus.lottery.application.worker;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import cn.itedus.lottery.application.mq.producer.Producer;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
import cn.itedus.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.itedus.lottery.domain.activity.service.partake.IActivityPartake;
import cn.itedus.lottery.domain.activity.service.stateflow.IStateHandler;
import com.alibaba.fastjson.JSON;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobFileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 抽奖业务，任务配置
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/25 0025
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class LotteryXxlJob {
    private Logger logger = LoggerFactory.getLogger(LotteryXxlJob.class);

    @Resource
    IActivityDeploy activityDeploy;

    @Resource
    IActivityPartake activityPartake;

    @Resource
    private IStateHandler stateHandler;


    @Resource
    private IDBRouterStrategy dbRouter;

    @Autowired
    private Producer kafkaProducer;


    @XxlJob("lotteryActivityStataJobHandler")
    public void lotteryActivityStateHandler() {
        logger.info("扫描活动状态 begin");
        XxlJobHelper.log("扫描活动状态 begin");

        List<ActivityVO> activityVOList = activityDeploy.scanToDoActivityList(0L);
        if (activityVOList.isEmpty()) {
            logger.info("扫描活动状态 End 暂无符合需要扫描的活动列表");
            XxlJobHelper.log("扫描活动状态 End 暂无符合需要扫描的活动列表");
            return;
        }

        while (!activityVOList.isEmpty()) {
            for (ActivityVO activityVO : activityVOList) {
                Integer state = activityVO.getState();
                switch (state) {
                    case 4:
                        Result state4Result = stateHandler.doing(activityVO.getActivityId(), Constants.ActivityState.PASS);
//                        记录在maven/data/xxl-job/日志下。
                        XxlJobHelper.log("扫描活动状态为活动中 结果：{} activityId:{} activityName:{} creator:{}",
                                JSON.toJSONString(state4Result), activityVO.getActivityId(),
                                activityVO.getActivityName(), activityVO.getCreator());

                        logger.info("扫描活动状态为活动中 结果：{} activityId:{} activityName:{} creator:{}",
                                JSON.toJSONString(state4Result), activityVO.getActivityId(),
                                activityVO.getActivityName(), activityVO.getCreator());
                        break;
                    case 5:
                        if (activityVO.getEndDateTime().before(new Date())) {
                            Result state5Result = stateHandler.close(activityVO.getActivityId(), Constants.ActivityState.DOING);
                            XxlJobHelper.log("扫描活动状态为关闭 结果：{} activityId:{} activityName:{} creator:{}",
                                    JSON.toJSONString(state5Result), activityVO.getActivityId(),
                                    activityVO.getActivityName(), activityVO.getCreator());

                            logger.info("扫描活动状态为关闭 结果：{} activityId:{} activityName:{} creator:{}",
                                    JSON.toJSONString(state5Result), activityVO.getActivityId(),
                                    activityVO.getActivityName(), activityVO.getCreator());
                        }
                        break;
                    default:
                        break;
                }
            }
            ActivityVO activityVO = activityVOList.get(activityVOList.size() - 1);
            activityVOList = activityDeploy.scanToDoActivityList(activityVO.getId());
        }

        logger.info("扫描活动状态 End！");
        XxlJobHelper.log("扫描活动状态 End！");
    }

    @XxlJob("lotteryOrderMQStateJobHandler")
    public void lotteryOrderMQStateJobHandler() {
        String jobParam=XxlJobHelper.getJobParam();

        if (null == jobParam) {
            logger.info("扫描用户抽奖奖品发放MQ状态【Table =2*4】错误 param is null");
            return;
        }

        //获取分布式任务配置参数信息  参数配置格式  1,2,3 也可以是指定扫描一个，也可以配置多个库，按照部署的任务集群进行数量配置，均摊分别扫描效率更高。
        String[] params = jobParam.split(",");
        logger.info("扫描用户抽奖奖品发放MQ状态【Table =2*4】开始 param：{}",JSON.toJSONString(params));

        if (params.length == 0) {
            logger.info("扫描用户抽奖奖品发放MQ状态【Table=2*4】 结束 param is null");
            return;
        }

        //获取分库分表配置下的分表数
        int tbCount =dbRouter.tbCount();

        for (String param : params) {
            int dbCount = Integer.parseInt(param);

            if (dbCount > dbRouter.dbCount()) {
                logger.info("扫描用户抽奖奖品发放MQ状态【Table =2*4 结束dbCount not exist");
                continue;
            }

            for (int i = 0; i < tbCount; i++) {
                //扫描库表数据
//                List<InvoiceVO> invoiceVOList;
                List<InvoiceVO> invoiceVOList = activityPartake.scanInvoiceMqState(dbCount, i);
                logger.info("扫描用户抽奖奖品发放MQ状态【Table =2*4】 扫描库：{} 扫描表：{} 扫描数：{}",dbCount,i,invoiceVOList.size());
                XxlJobHelper.log("扫描用户抽奖奖品发放MQ状态【Table =2*4】 扫描库：{} 扫描表：{} 扫描数：{}",dbCount,i,invoiceVOList.size());

                //补偿消息
                for (InvoiceVO invoiceVO : invoiceVOList) {
                    ListenableFuture<SendResult<String, Object>> future = kafkaProducer.sendLotteryInvoice(invoiceVO);
                    future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

                        @Override
                        public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                            //消息发送完成，更新数据库表 user_strategy_export.ma_state =1
                            activityPartake.updateInvoiceMqState(invoiceVO.getUId(),invoiceVO.getOrderId(),Constants.MQState.COMPLETE.getCode());
                            XxlJobHelper.log("worker 扫描 ：订单：{} 发送MQ成功。", JSON.toJSONString(invoiceVO));
                        }
                        @Override
                        public void onFailure(Throwable throwable) {
                            //MQ 消息发送失败，更新数据库表 user_strategy_export.mq_state=2 [等待定时任务扫描补偿
                            activityPartake.updateInvoiceMqState(invoiceVO.getUId(),invoiceVO.getOrderId(),Constants.MQState.FAIL.getCode());
                            XxlJobHelper.log("worker 扫描：订单：{} 发送MQ失败", JSON.toJSONString(invoiceVO));
                        }

                    });

                }


            }
        }
        logger.info("扫描用户抽奖奖品发放MQ状态【Table =2*4】 完成 param：{}",JSON.toJSONString(params));
        XxlJobHelper.log("扫描用户抽奖奖品发放MQ状态【Table =2*4】 完成 param：{}",JSON.toJSONString(params));

    }
}
