package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TChannelLogMapper;
import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;
import net.chenlin.dp.modules.cms.manager.TChannelLogManager;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
@Component("tChannelLogManager")
public class TChannelLogManagerImpl implements TChannelLogManager {

	@Autowired
	private TChannelLogMapper tChannelLogMapper;
	

	@Override
	public List<TChannelLogEntity> listTChannelLog(Page<TChannelLogEntity> page, Query search) {
		return tChannelLogMapper.listForPage(page, search);
	}

	@Override
	public int saveTChannelLog(TChannelLogEntity tChannelLog) {
		return tChannelLogMapper.save(tChannelLog);
	}

	@Override
	public TChannelLogEntity getTChannelLogById(Long id) {
		TChannelLogEntity tChannelLog = tChannelLogMapper.getObjectById(id);
		return tChannelLog;
	}

	@Override
	public int updateTChannelLog(TChannelLogEntity tChannelLog) {
		return tChannelLogMapper.update(tChannelLog);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tChannelLogMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<TChannelLogEntity> taskMonth(String startDate, String endDate) {
		List<TChannelLogEntity> list=tChannelLogMapper.taskMonth(startDate,endDate);
		return list;
	}

}
