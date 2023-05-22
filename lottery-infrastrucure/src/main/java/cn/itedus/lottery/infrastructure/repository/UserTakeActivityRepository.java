package cn.itedus.lottery.infrastructure.repository;

import cn.itedus.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.itedus.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import cn.itedus.lottery.infrastructure.dao.IUserTakeActivityDao;
import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import cn.itedus.lottery.infrastructure.po.UserTakeActivityCount;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 用户参与活动仓储
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/22 0022
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Component
public class UserTakeActivityRepository implements IUserTakeActivityRepository {

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Override
    public int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId,
                                    Date partakeDate) {
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
    public void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setTakeId(takeId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setActivityName(activityName);
        userTakeActivity.setTakeDate(takeDate);
        if (null == userTakeLeftCount) {
            userTakeActivity.setTakeCount(1);
        }
        else {
            userTakeActivity.setTakeCount(takeCount-userTakeLeftCount+1);
        }
        String uuid=uId+"_"+activityId+"_"+userTakeActivity.getTakeCount();
        userTakeActivity.setUuid(uuid);
        userTakeActivityDao.insert(userTakeActivity);

    }
}
