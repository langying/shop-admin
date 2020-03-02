package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;

import java.util.List;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
public interface TChannelAgentManager {

	List<TChannelAgentEntity> listTChannelAgent(Page<TChannelAgentEntity> page, Query search);
	
	int saveTChannelAgent(TChannelAgentEntity tChannelAgent);
	
	TChannelAgentEntity getTChannelAgentById(Long id);
	
	int updateTChannelAgent(TChannelAgentEntity tChannelAgent);
	
	int batchRemove(Long[] id);
	
}
