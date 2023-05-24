package cn.itedus.lottery.interfaces.assembler;


import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.itedus.lottery.rpc.dto.AwardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @description: 对象转换配置
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/24 0024
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AwardMapping extends IMapping<DrawAwardVO, AwardDTO> {

    /**
     * 将源对象转换为目标对象
     * @param drawAwardVO 源
     * @return
     */
    @Mapping(target = "userId",source = "uId")
    @Override
    AwardDTO sourceToTarget(DrawAwardVO drawAwardVO);

    /**
     * 将目标对象转换为源对象
     * @param awardDTO 源
     * @return
     */
    @Override
    DrawAwardVO targetToSource(AwardDTO awardDTO);


}
