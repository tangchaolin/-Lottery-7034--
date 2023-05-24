package cn.itedus.lottery.interfaces.facade;

import cn.itedus.lottery.application.process.IActivityProcess;
import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;
import cn.itedus.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.itedus.lottery.interfaces.assembler.IMapping;
import cn.itedus.lottery.rpc.ILotteryActivityBooth;
import cn.itedus.lottery.rpc.dto.AwardDTO;
import cn.itedus.lottery.rpc.req.DrawReq;
import cn.itedus.lottery.rpc.req.QuantificationDrawReq;
import cn.itedus.lottery.rpc.res.DrawRes;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @description: 抽奖活动展台
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Controller
public class LotteryActivityBooth implements ILotteryActivityBooth {

    private Logger logger = LoggerFactory.getLogger(LotteryActivityBooth.class);

    @Resource
    private IActivityProcess activityProcess;

    @Resource
    private IMapping<DrawAwardVO, AwardDTO> awardMapping;


    @Override
    public DrawRes doDraw(DrawReq drawReq) {
        try{
            logger.info("抽奖，开始 uId：{} activityId:{}",drawReq.getUId(),drawReq.getActivityId());

            //1.执行抽奖
            DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(new DrawProcessReq(drawReq.getUId(), drawReq.getActivityId()));

            if (!Constants.ResponseCode.SUCCESS.getCode().equals(drawProcessResult.getCode())) {
                logger.info("抽奖，失败（抽奖过程异常）uid：{} activityId：{}", drawReq.getUId(), drawReq.getActivityId());
                return new DrawRes(drawProcessResult.getCode(), drawProcessResult.getInfo());
            }

            //2.数据转换
            DrawAwardVO drawAwardVO =drawProcessResult.getDrawAwardVO();

            AwardDTO awardDTO = awardMapping.sourceToTarget(drawAwardVO);
            awardDTO.setActivityId(drawReq.getActivityId());

            //3.封装数据
            DrawRes drawRes = new DrawRes(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
            drawRes.setAwardDTO(awardDTO);

            logger.info("抽奖，完成 uId：{} activityId：{} drawRes{}", drawReq.getUId(), drawReq.getActivityId(), JSON.toJSONString(drawReq));

            return drawRes;





        }catch (Exception e){
            logger.error("抽奖，失败 uId:{} activityId:{} reqJson{}",drawReq.getUId(),drawReq.getActivityId(),JSON.toJSONString(drawReq),e);
            return new DrawRes(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());

        }
    }

    @Override
    public DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq) {
        try {
            logger.info("量化人群抽奖，开始 uId：{} treeId：{}", quantificationDrawReq.getUId(), quantificationDrawReq.getTreeId());

            //执行规则引擎，获得用户可以参与的活动号
            RuleQuantificationCrowdResult ruleQuantificationCrowdResult = activityProcess.doRuleQuantificationCrowd(new DecisionMatterReq(
                    quantificationDrawReq.getTreeId(),quantificationDrawReq.getUId(),quantificationDrawReq.getValMap()
            ));

            if (!Constants.ResponseCode.SUCCESS.getCode().equals(ruleQuantificationCrowdResult.getCode())) {
                logger.error("量化人群抽奖，失败（规则引擎执行异常 uId:{} treeId", quantificationDrawReq.getUId(), quantificationDrawReq.getTreeId());
                return new DrawRes(ruleQuantificationCrowdResult.getCode(), ruleQuantificationCrowdResult.getInfo());
            }

            //2.执行抽奖
            Long activityId= ruleQuantificationCrowdResult.getActivityId();
            DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(new DrawProcessReq(quantificationDrawReq.getUId(), activityId));
            if (!Constants.ResponseCode.SUCCESS.getCode().equals(drawProcessResult.getCode())) {
                logger.error("量化人群抽奖，失败（抽奖过程异常） uId:{} treeId:{}", quantificationDrawReq.getUId(), quantificationDrawReq.getTreeId());
                return new DrawRes(drawProcessResult.getCode(), drawProcessResult.getInfo());
            }

            //3.数据封装
            DrawAwardVO drawAwardVO= drawProcessResult.getDrawAwardVO();
            AwardDTO awardDTO = awardMapping.sourceToTarget(drawAwardVO);
            awardDTO.setActivityId(activityId);


            //4.封装数据
            DrawRes drawRes = new DrawRes(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
            drawRes.setAwardDTO(awardDTO);

            logger.info("量化人群抽奖，完成 uId：{} treeId ：{} drawRes：{}",quantificationDrawReq.getUId(),quantificationDrawReq.getTreeId(),JSON.toJSONString(drawRes));
            return drawRes;


        } catch (Exception e) {
            logger.error("量化人群抽奖，失败 uId:{} treeId:{} reqJson：{}",quantificationDrawReq.getUId(),quantificationDrawReq.getTreeId(),JSON.toJSONString(quantificationDrawReq),e);
            return new DrawRes(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
        }

    }
}
