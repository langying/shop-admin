package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TUserEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUserEntity> {
	
}
