package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TAgentRecordEntity;
import net.chenlin.dp.modules.cms.manager.TAgentRecordManager;
import net.chenlin.dp.modules.cms.service.TAgentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 点击推广链接记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:25
 */
@Service("tAgentRecordService")
public class TAgentRecordServiceImpl implements TAgentRecordService {

	@Autowired
	private TAgentRecordManager tAgentRecordManager;

	@Override
	public Page<TAgentRecordEntity> listTAgentRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TAgentRecordEntity> page = new Page<>(query);
		tAgentRecordManager.listTAgentRecord(page, query);
		return page;
	}

	@Override
	public R saveTAgentRecord(TAgentRecordEntity role) {
		int count = tAgentRecordManager.saveTAgentRecord(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTAgentRecordById(Long id) {
		TAgentRecordEntity tAgentRecord = tAgentRecordManager.getTAgentRecordById(id);
		return CommonUtils.msg(tAgentRecord);
	}

	@Override
	public R updateTAgentRecord(TAgentRecordEntity tAgentRecord) {
		int count = tAgentRecordManager.updateTAgentRecord(tAgentRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tAgentRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
