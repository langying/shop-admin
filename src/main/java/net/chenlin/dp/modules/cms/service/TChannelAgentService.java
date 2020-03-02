package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;

import java.util.Map;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
public interface TChannelAgentService {

	Page<TChannelAgentEntity> listTChannelAgent(Map<String, Object> params);
	
	R saveTChannelAgent(TChannelAgentEntity tChannelAgent);
	
	R getTChannelAgentById(Long id);
	
	R updateTChannelAgent(TChannelAgentEntity tChannelAgent);
	
	R batchRemove(Long[] id);
	
}
