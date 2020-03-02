package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TMessageEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
@Mapper
public interface TMessageMapper extends BaseMapper<TMessageEntity> {
	
}
