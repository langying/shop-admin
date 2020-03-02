package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TNewsEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
@Mapper
public interface TNewsMapper extends BaseMapper<TNewsEntity> {
	
}
