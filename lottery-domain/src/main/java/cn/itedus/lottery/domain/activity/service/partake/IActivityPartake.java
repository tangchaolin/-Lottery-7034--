package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityPartakeRecordVO;
import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;

import java.util.List;

/**
 * @description: 抽奖活动参与接口
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/18 0018
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public interface IActivityPartake {
    /**
     * 领取活动请求
     * @param req
     * @return
     */
    PartakeResult doPartake(PartakeReq req);


    /**
     * 保存奖品单
     * @param drawOrderVO 奖品单
     * @return 保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrderVO);

    /**
     * 更新发货单MQ状态
     * @param uId
     * @param orderId
     * @param mqState
     */

    void updateInvoiceMqState(String uId, Long orderId, Integer mqState);

    /**
     * 扫描发货单MQ状态 ，把未发送MQ的单子扫描出来，做补偿。
     * @param dbCount 指定分库
     * @param tbCount 指定分表
     * @return 发货单
     */
    List<InvoiceVO> scanInvoiceMqState(int dbCount,int tbCount);

    /**
     * 更新活动库存
     * @param activityPartakeRecordVO 活动领取记录
     */
    void updateActivityStock(ActivityPartakeRecordVO activityPartakeRecordVO);



}
