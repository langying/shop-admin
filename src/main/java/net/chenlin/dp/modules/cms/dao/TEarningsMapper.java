package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TEarningsEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
@Mapper
public interface TEarningsMapper extends BaseMapper<TEarningsEntity> {

    TEarningsEntity getDays(String days);

    TEarningsEntity findByDays(String days);
	
}
