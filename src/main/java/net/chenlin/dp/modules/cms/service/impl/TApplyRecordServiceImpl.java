package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TApplyRecordEntity;
import net.chenlin.dp.modules.cms.manager.TApplyRecordManager;
import net.chenlin.dp.modules.cms.service.TApplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月11日 下午3:04:32
 */
@Service("tApplyRecordService")
public class TApplyRecordServiceImpl implements TApplyRecordService {

	@Autowired
	private TApplyRecordManager tApplyRecordManager;

	@Override
	public Page<TApplyRecordEntity> listTApplyRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TApplyRecordEntity> page = new Page<>(query);
		tApplyRecordManager.listTApplyRecord(page, query);
		return page;
	}

	@Override
	public R saveTApplyRecord(TApplyRecordEntity role) {
		int count = tApplyRecordManager.saveTApplyRecord(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTApplyRecordById(Long id) {
		TApplyRecordEntity tApplyRecord = tApplyRecordManager.getTApplyRecordById(id);
		return CommonUtils.msg(tApplyRecord);
	}

	@Override
	public R updateTApplyRecord(TApplyRecordEntity tApplyRecord) {
		int count = tApplyRecordManager.updateTApplyRecord(tApplyRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tApplyRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
