package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TThirdRecordMapper;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;
import net.chenlin.dp.modules.cms.manager.TThirdRecordManager;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
@Component("tThirdRecordManager")
public class TThirdRecordManagerImpl implements TThirdRecordManager {

	@Autowired
	private TThirdRecordMapper tThirdRecordMapper;
	

	@Override
	public List<TThirdRecordEntity> listTThirdRecord(Page<TThirdRecordEntity> page, Query search) {
		return tThirdRecordMapper.listForPage(page, search);
	}

	@Override
	public List<TThirdRecordEntity> list(Page<TThirdRecordEntity> page, Query search) {
		return tThirdRecordMapper.list(page, search);
	}


	@Override
	public int saveTThirdRecord(TThirdRecordEntity tThirdRecord) {
		return tThirdRecordMapper.save(tThirdRecord);
	}

	@Override
	public TThirdRecordEntity getTThirdRecordById(Long id) {
		TThirdRecordEntity tThirdRecord = tThirdRecordMapper.getObjectById(id);
		return tThirdRecord;
	}

	@Override
	public int updateTThirdRecord(TThirdRecordEntity tThirdRecord) {
		return tThirdRecordMapper.update(tThirdRecord);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tThirdRecordMapper.batchRemove(id);
		return count;
	}

	@Override
	public List<TThirdRecordEntity> recordList(String days) {
		List<TThirdRecordEntity> list=tThirdRecordMapper.recordList(days);
		return list;
	}

	@Override
	public int save(TThirdRecordEntity tThirdRecord) {
		return tThirdRecordMapper.save(tThirdRecord);
	}

}
