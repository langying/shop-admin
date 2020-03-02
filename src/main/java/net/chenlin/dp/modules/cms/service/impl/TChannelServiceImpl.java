package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TChannelManager;
import net.chenlin.dp.modules.cms.service.TChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
@Service("tChannelService")
public class TChannelServiceImpl implements TChannelService {

	@Autowired
	private TChannelManager tChannelManager;

	@Override
	public Page<TChannelEntity> listTChannel(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TChannelEntity> page = new Page<>(query);
		tChannelManager.listTChannel(page, query);
		return page;
	}
	@Override
	public List<TSelectEntity> select() {
		return tChannelManager.select();
	}
	@Override
	public R saveTChannel(TChannelEntity role) {
		int count = tChannelManager.saveTChannel(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTChannelById(Long id) {
		TChannelEntity tChannel = tChannelManager.getTChannelById(id);
		return CommonUtils.msg(tChannel);
	}

	@Override
	public R updateTChannel(TChannelEntity tChannel) {
		int count = tChannelManager.updateTChannel(tChannel);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tChannelManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
