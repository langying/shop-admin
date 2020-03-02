package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
@Mapper
public interface TChannelAgentMapper extends BaseMapper<TChannelAgentEntity> {

   int getNum(@Param("channelId") int channelId);

   TChannelAgentEntity findByAccount(String account);
	
}
