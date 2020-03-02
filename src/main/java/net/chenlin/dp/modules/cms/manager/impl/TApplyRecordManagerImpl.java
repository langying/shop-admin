package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TApplyRecordMapper;
import net.chenlin.dp.modules.cms.entity.TApplyRecordEntity;
import net.chenlin.dp.modules.cms.manager.TApplyRecordManager;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月11日 下午3:04:32
 */
@Component("tApplyRecordManager")
public class TApplyRecordManagerImpl implements TApplyRecordManager {

	@Autowired
	private TApplyRecordMapper tApplyRecordMapper;
	

	@Override
	public List<TApplyRecordEntity> listTApplyRecord(Page<TApplyRecordEntity> page, Query search) {
		return tApplyRecordMapper.listForPage(page, search);
	}

	@Override
	public int saveTApplyRecord(TApplyRecordEntity tApplyRecord) {
		return tApplyRecordMapper.save(tApplyRecord);
	}

	@Override
	public TApplyRecordEntity getTApplyRecordById(Long id) {
		TApplyRecordEntity tApplyRecord = tApplyRecordMapper.getObjectById(id);
		return tApplyRecord;
	}

	@Override
	public int updateTApplyRecord(TApplyRecordEntity tApplyRecord) {
		return tApplyRecordMapper.update(tApplyRecord);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tApplyRecordMapper.batchRemove(id);
		return count;
	}
	
}
