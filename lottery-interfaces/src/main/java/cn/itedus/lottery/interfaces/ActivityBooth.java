package cn.itedus.lottery.interfaces;


import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import cn.itedus.lottery.infrastructure.po.Activity;
import cn.itedus.lottery.rpc.IActivityBooth;
import cn.itedus.lottery.rpc.dto.ActivityDto;
import cn.itedus.lottery.rpc.req.ActivityReq;
import cn.itedus.lottery.rpc.res.ActivityRes;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;


import javax.annotation.Resource;
import java.io.Serializable;


@Service
public class ActivityBooth implements IActivityBooth {
    @Resource
    private IActivityDao activityDao;
    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());


        ActivityDto dto=new ActivityDto();

        dto.setActivityId(activity.getActivityId());

        dto.setActivityDesc(activity.getActivityDesc());

        dto.setActivityName(activity.getActivityName());

        dto.setBeginDateTime(activity.getBeginDateTime());

        dto.setEndDateTime(activity.getEndDateTime());

        dto.setStockCount(activity.getStockCount());

        dto.setTakeCount(activity.getTakeCount());

        dto.setState(activity.getState());

        return new ActivityRes(Result.buildSuccessResult(),dto);
    }
}
