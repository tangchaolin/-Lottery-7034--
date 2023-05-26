package cn.itedus.lottery.domain.activity.service.partake.impl;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.itedus.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.itedus.lottery.domain.activity.service.partake.BaseActivityPartake;
import cn.itedus.lottery.domain.activity.service.partake.IActivityPartake;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description: 活动参与功能实现
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class ActivityPartakeImpl extends BaseActivityPartake {
    private Logger logger = LoggerFactory.getLogger(ActivityPartakeImpl.class);

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;


    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private IDBRouterStrategy dbRouter;


    @Override
    protected Result checkActivityBill(PartakeReq partake, ActivityBillVO bill) {
        //校验：活动状态
        if (!Constants.ActivityState.DOING.getCode().equals(bill.getState())) {
            logger.warn("活动当前状态非可用 state：{}",bill.getState());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动当前状态非可用");
        }

        //校验：活动日期
        if (bill.getBeginDateTime().after(partake.getPartakeDate())||bill.getEndDateTime().before(partake.getPartakeDate())) {
            logger.warn("活动时间范围非可用 beginDateTime:{} endDateTime",bill.getBeginDateTime(),bill.getEndDateTime());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动时间范围非可用");
        }
        //校验库存
        if (bill.getStockSurplusCount() <= 0) {
            logger.warn("活动剩余库存非可用 stockSurplusCount :{}",bill.getStockSurplusCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动剩余库存非可用");
        }

        //校验个人库存 -个人活动剩余可领取次数
        if ( !ObjectUtil.isNull(bill.getUserTakeLeftCount())&&bill.getUserTakeLeftCount() <= 0) {
            logger.warn("个人领取次数非可用 userTakeLeftCount :{}",bill.getUserTakeLeftCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "个人领取次数非可用");
        }


        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        int count = activityRepository.subtractionActivityStock(req.getActivityId());
        if (0 == count) {
            logger.error("扣减活动库存失败 actiivtyId:{}",req.getActivityId());
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }
    @Override
    public Result recordDrawOrder(DrawOrderVO drawOrder) {
        try {
            dbRouter.doRouter(drawOrder.getUId());
            return transactionTemplate.execute(transactionStatus -> {
                try{
                    int lockCount = userTakeActivityRepository.lockTackActivity(drawOrder.getUId(),
                            drawOrder.getActivityId(), drawOrder.getTakeId());
                    if (0 == lockCount) {
                        transactionStatus.setRollbackOnly();
                        logger.error("记录中奖单，个人参与活动抽奖已消耗完 activityId:{} uId:{} ",drawOrder.getActivityId(),
                                drawOrder.getUId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }
                    //保存抽奖信息
                    userTakeActivityRepository.saveUserStrategyExport(drawOrder);

                }catch (DuplicateKeyException e){
                    transactionStatus.setRollbackOnly();
                    logger.error("记录中奖单，唯一索引冲突 activityId:{} uId:{}",drawOrder.getActivityId(),drawOrder.getUId()
                    ,e);
                }
                return Result.buildSuccessResult();
            });


        } finally {
            dbRouter.clear();
        }

    }



    @Override
    protected Result grabActivity(PartakeReq partake, ActivityBillVO bill,Long takeId) {
        try{
            dbRouter.doRouter(partake.getUId());
            return transactionTemplate.execute(transactionStatus -> {
                try{
                    //扣减个人已参与次数
                    int updateCount= userTakeActivityRepository.subtractionLeftCount(bill.getActivityId(),bill.getActivityName(),bill.getTakeCount(),bill.getUserTakeLeftCount(),partake.getUId());
                    if (0 == updateCount) {
                        transactionStatus.setRollbackOnly();
                        logger.error("领取活动，扣减个人已参与次数失败 activityId:{} uId:{}", partake.getActivityId(), partake.getUId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    userTakeActivityRepository.takeActivity(bill.getActivityId(), bill.getActivityName(),bill.getStrategyId(),bill.getTakeCount(),bill.getUserTakeLeftCount(),partake.getUId(),partake.getPartakeDate(),takeId);

                }catch (DuplicateKeyException e){
                    transactionStatus.setRollbackOnly();
                    logger.error("领取活动，唯一索引冲突 activityId：{} uId:{}",partake.getActivityId(),partake.getUId());
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();

            });
        }
        finally {
            dbRouter.clear();
        }


    }

    @Override
    protected UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId) {
        return userTakeActivityRepository.queryNoConsumedTakeActivityOrder(activityId,uId);
    }

    @Override
    public void updateInvoiceMqState(String uId, Long orderId, Integer mqState) {
        userTakeActivityRepository.updateInvoiceMqState(uId,orderId,mqState);
    }

    @Override
    public List<InvoiceVO> scanInvoiceMqState(int dbCount, int tbCount) {
        try{
            //设置路由
            dbRouter.setDBKey(dbCount);
            dbRouter.setTBKey(tbCount);
            return userTakeActivityRepository.scanInvoiceMqState();
        }finally {
            dbRouter.clear();
        }
    }
}
