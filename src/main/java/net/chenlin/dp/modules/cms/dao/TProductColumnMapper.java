package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
@Mapper
public interface TProductColumnMapper extends BaseMapper<TProductColumnEntity> {
	
}
