package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TEarningsEntity;
import net.chenlin.dp.modules.cms.manager.TEarningsManager;
import net.chenlin.dp.modules.cms.service.TEarningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
@Service("tEarningsService")
public class TEarningsServiceImpl implements TEarningsService {

	@Autowired
	private TEarningsManager tEarningsManager;

	@Override
	public Page<TEarningsEntity> listTEarnings(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TEarningsEntity> page = new Page<>(query);
		tEarningsManager.listTEarnings(page, query);
		return page;
	}

	@Override
	public R saveTEarnings(TEarningsEntity role) {
		int count = tEarningsManager.saveTEarnings(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTEarningsById(Long id) {
		TEarningsEntity tEarnings = tEarningsManager.getTEarningsById(id);
		return CommonUtils.msg(tEarnings);
	}

	@Override
	public R updateTEarnings(TEarningsEntity tEarnings) {
		int count = tEarningsManager.updateTEarnings(tEarnings);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tEarningsManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public void taskRecord(String days) {


		TEarningsEntity entity=tEarningsManager.getDays(days);

		tEarningsManager.saveTEarnings(entity);
	}

}
