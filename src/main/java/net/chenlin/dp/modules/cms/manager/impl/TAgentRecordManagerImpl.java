package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TAgentRecordMapper;
import net.chenlin.dp.modules.cms.entity.TAgentRecordEntity;
import net.chenlin.dp.modules.cms.manager.TAgentRecordManager;

/**
 * 点击推广链接记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:25
 */
@Component("tAgentRecordManager")
public class TAgentRecordManagerImpl implements TAgentRecordManager {

	@Autowired
	private TAgentRecordMapper tAgentRecordMapper;
	

	@Override
	public List<TAgentRecordEntity> listTAgentRecord(Page<TAgentRecordEntity> page, Query search) {
		return tAgentRecordMapper.listForPage(page, search);
	}

	@Override
	public int saveTAgentRecord(TAgentRecordEntity tAgentRecord) {
		return tAgentRecordMapper.save(tAgentRecord);
	}

	@Override
	public TAgentRecordEntity getTAgentRecordById(Long id) {
		TAgentRecordEntity tAgentRecord = tAgentRecordMapper.getObjectById(id);
		return tAgentRecord;
	}

	@Override
	public int updateTAgentRecord(TAgentRecordEntity tAgentRecord) {
		return tAgentRecordMapper.update(tAgentRecord);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tAgentRecordMapper.batchRemove(id);
		return count;
	}
	
}
