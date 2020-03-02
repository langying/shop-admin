package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;
import net.chenlin.dp.modules.cms.manager.TChannelAgentManager;
import net.chenlin.dp.modules.cms.service.TChannelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
@Service("tChannelAgentService")
public class TChannelAgentServiceImpl implements TChannelAgentService {

	@Autowired
	private TChannelAgentManager tChannelAgentManager;

	@Override
	public Page<TChannelAgentEntity> listTChannelAgent(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TChannelAgentEntity> page = new Page<>(query);
		tChannelAgentManager.listTChannelAgent(page, query);
		return page;
	}

	@Override
	public R saveTChannelAgent(TChannelAgentEntity role) {
		int count = tChannelAgentManager.saveTChannelAgent(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTChannelAgentById(Long id) {
		TChannelAgentEntity tChannelAgent = tChannelAgentManager.getTChannelAgentById(id);
		return CommonUtils.msg(tChannelAgent);
	}

	@Override
	public R updateTChannelAgent(TChannelAgentEntity tChannelAgent) {
		int count = tChannelAgentManager.updateTChannelAgent(tChannelAgent);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tChannelAgentManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
