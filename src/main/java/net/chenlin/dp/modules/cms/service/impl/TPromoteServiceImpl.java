package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TPromoteEntity;
import net.chenlin.dp.modules.cms.manager.TPromoteManager;
import net.chenlin.dp.modules.cms.service.TPromoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
@Service("tPromoteService")
public class TPromoteServiceImpl implements TPromoteService {

	@Autowired
	private TPromoteManager tPromoteManager;

	@Override
	public Page<TPromoteEntity> listTPromote(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TPromoteEntity> page = new Page<>(query);
		tPromoteManager.listTPromote(page, query);
		return page;
	}

	@Override
	public R saveTPromote(TPromoteEntity role) {
		int count = tPromoteManager.saveTPromote(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTPromoteById(Long id) {
		TPromoteEntity tPromote = tPromoteManager.getTPromoteById(id);
		return CommonUtils.msg(tPromote);
	}

	@Override
	public R updateTPromote(TPromoteEntity tPromote) {
		int count = tPromoteManager.updateTPromote(tPromote);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tPromoteManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
