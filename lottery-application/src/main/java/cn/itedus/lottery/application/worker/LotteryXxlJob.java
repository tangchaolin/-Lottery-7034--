package cn.itedus.lottery.application.worker;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.itedus.lottery.domain.activity.service.stateflow.IStateHandler;
import com.alibaba.fastjson.JSON;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobFileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    private IStateHandler stateHandler;




    @XxlJob("lotteryActivityStataJobHandler")
    public void lotteryActivityStateHandler() {
        logger.info("扫描活动状态 begin");
        XxlJobFileAppender.appendLog("","");

        List<ActivityVO> activityVOList = activityDeploy.scanToDoActivityList(0L);
        if (activityVOList.isEmpty()) {
            logger.info("扫描活动状态 End 暂无符合需要扫描的活动列表");
            XxlJobHelper.log("扫描活动状态 End 暂无符合需要扫描的活动列表");
            return;
        }

        while (!activityVOList.isEmpty()) {
            for (ActivityVO activityVO : activityVOList) {
                Integer state=activityVO.getState();
                switch (state) {
                    case 4:
                        Result state4Result = stateHandler.doing(activityVO.getActivityId(), Constants.ActivityState.PASS);
//                        记录在maven/data/xxl-job/日志下。
                        XxlJobHelper.log("扫描活动状态为活动中 结果：{} activityId:{} activityName:{} creator:{}",
                                JSON.toJSONString(state4Result),activityVO.getActivityId(),
                                activityVO.getActivityName(),activityVO.getCreator());

                        logger.info("扫描活动状态为活动中 结果：{} activityId:{} activityName:{} creator:{}",
                                JSON.toJSONString(state4Result),activityVO.getActivityId(),
                                activityVO.getActivityName(),activityVO.getCreator());
                        break;
                    case 5:
                        if (activityVO.getEndDateTime().before(new Date())) {
                            Result state5Result = stateHandler.close(activityVO.getActivityId(), Constants.ActivityState.DOING);
                            XxlJobHelper.log("扫描活动状态为关闭 结果：{} activityId:{} activityName:{} creator:{}",
                                    JSON.toJSONString(state5Result),activityVO.getActivityId(),
                                    activityVO.getActivityName(),activityVO.getCreator());

                            logger.info("扫描活动状态为关闭 结果：{} activityId:{} activityName:{} creator:{}",
                                    JSON.toJSONString(state5Result),activityVO.getActivityId(),
                                    activityVO.getActivityName(),activityVO.getCreator());
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
}
