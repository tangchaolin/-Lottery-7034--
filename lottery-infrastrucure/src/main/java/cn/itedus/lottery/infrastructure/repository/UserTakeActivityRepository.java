package cn.itedus.lottery.infrastructure.repository;

import cn.hutool.core.util.ObjectUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.itedus.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.itedus.lottery.infrastructure.dao.IUserStrategyExportDao;
import cn.itedus.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import cn.itedus.lottery.infrastructure.dao.IUserTakeActivityDao;
import cn.itedus.lottery.infrastructure.po.UserStrategyExport;
import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import cn.itedus.lottery.infrastructure.po.UserTakeActivityCount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户参与活动仓储
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Repository
public class UserTakeActivityRepository implements IUserTakeActivityRepository {

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Override
    public int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId) {
        if (null == userTakeLeftCount) {
            UserTakeActivityCount userTakeActivityCount=new UserTakeActivityCount();
            userTakeActivityCount.setActivityId(activityId);
            userTakeActivityCount.setUId(uId);
            userTakeActivityCount.setTotalCount(takeCount);
            userTakeActivityCount.setLeftCount(takeCount-1);
            userTakeActivityCountDao.insert(userTakeActivityCount);
            return 1;
        }
        else {
            UserTakeActivityCount userTakeActivityCount=new UserTakeActivityCount();
            userTakeActivityCount.setUId(uId);
            userTakeActivityCount.setActivityId(activityId);
            return userTakeActivityCountDao.updateLeftCount(userTakeActivityCount);
        }

    }

    @Override
    public void takeActivity(Long activityId, String activityName,Long strategy_id, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setTakeId(takeId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setActivityName(activityName);
        userTakeActivity.setTakeDate(takeDate);
        userTakeActivity.setStrategyId(strategy_id);


        if (null == userTakeLeftCount) {
            userTakeActivity.setTakeCount(1);
        }
        else {
            userTakeActivity.setTakeCount(takeCount-userTakeLeftCount+1);
        }
        userTakeActivity.setState(Constants.TaskState.NO_USED.getCode());

        String uuid=uId+"_"+activityId+"_"+userTakeActivity.getTakeCount();
        userTakeActivity.setUuid(uuid);
        userTakeActivityDao.insert(userTakeActivity);

    }

    @Override
    public int lockTackActivity(String uId, Long activityId, Long takeId) {
        UserTakeActivity userTakeActivity=new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setTakeId(takeId);


        return userTakeActivityDao.lockTackActivity(userTakeActivity);
    }

    @Override
    public void saveUserStrategyExport(DrawOrderVO drawOrderVO) {
        UserStrategyExport userStrategyExport =new UserStrategyExport();

        userStrategyExport.setUId(drawOrderVO.getUId());
        userStrategyExport.setActivityId(drawOrderVO.getActivityId());
        userStrategyExport.setOrderId(drawOrderVO.getOrderId());
        userStrategyExport.setStrategyId(drawOrderVO.getStrategyId());
        userStrategyExport.setStrategyMode(drawOrderVO.getStrategyMode());
        userStrategyExport.setGrantType(drawOrderVO.getGrantType());
        userStrategyExport.setGrantDate(drawOrderVO.getGrantDate());
        userStrategyExport.setGrantState(drawOrderVO.getGrantState());
        userStrategyExport.setAwardId(drawOrderVO.getAwardId());
        userStrategyExport.setAwardType(drawOrderVO.getAwardType());
        userStrategyExport.setAwardName(drawOrderVO.getAwardName());
        userStrategyExport.setAwardContent(drawOrderVO.getAwardContent());
        userStrategyExport.setUuid(String.valueOf(drawOrderVO.getTakeId()));

        userStrategyExportDao.insert(userStrategyExport);


    }

    @Override
    public UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId) {
        UserTakeActivity userTakeActivity =new UserTakeActivity();
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setUId(uId);
        UserTakeActivity noConsumedTakeActivityOrder = userTakeActivityDao.queryNoConsumedTakeActivityOrder(userTakeActivity);
        //未查询到符合的领取单，直接返回NULL
        if (ObjectUtil.isNull(noConsumedTakeActivityOrder)) {
            return null;
        }
        UserTakeActivityVO userTakeActivityVO=new UserTakeActivityVO();
        userTakeActivityVO.setTakeId(noConsumedTakeActivityOrder.getTakeId());
        userTakeActivityVO.setActivityId(noConsumedTakeActivityOrder.getActivityId());
        userTakeActivityVO.setStrategyId(noConsumedTakeActivityOrder.getStrategyId());
        userTakeActivityVO.setState(noConsumedTakeActivityOrder.getState());



        return userTakeActivityVO;
    }

    @Override
    public void updateInvoiceMqState(String uId, Long orderId, Integer mqState) {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setMqState(mqState);
        userStrategyExport.setUId(uId);
        userStrategyExport.setOrderId(orderId);
        userStrategyExportDao.updateInvoiceMqState(userStrategyExport);

    }

    @Override
    public List<InvoiceVO> scanInvoiceMqState() {
        List<UserStrategyExport> userStrategyExportList =userStrategyExportDao.scanInvoiceMqState();

        List<InvoiceVO> invoiceVOList = new ArrayList<>(userStrategyExportList.size());

        for (UserStrategyExport userStrategyExport : userStrategyExportList) {
            InvoiceVO invoiceVO=new InvoiceVO();

            invoiceVO.setOrderId(userStrategyExport.getOrderId());
            invoiceVO.setUId(userStrategyExport.getUId());
            invoiceVO.setAwardId(userStrategyExport.getAwardId());
            invoiceVO.setAwardType(userStrategyExport.getAwardType());
            invoiceVO.setAwardName(userStrategyExport.getAwardName());
            invoiceVO.setAwardContent(userStrategyExport.getAwardContent());

            invoiceVOList.add(invoiceVO);

        }


        return invoiceVOList;

    }
}
