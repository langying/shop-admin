package net.chenlin.dp.modules.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TProductApplyEntity;
import net.chenlin.dp.modules.cms.manager.TProductApplyManager;
import net.chenlin.dp.modules.cms.service.TProductApplyService;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午5:13:06
 */
@Service("tProductApplyService")
public class TProductApplyServiceImpl implements TProductApplyService {

	@Autowired
	private TProductApplyManager tProductApplyManager;

	@Override
	public Page<TProductApplyEntity> listTProductApply(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TProductApplyEntity> page = new Page<>(query);
		tProductApplyManager.listTProductApply(page, query);
		return page;
	}

	@Override
	public R saveTProductApply(TProductApplyEntity role) {
		int count = tProductApplyManager.saveTProductApply(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTProductApplyById(Long id) {
		TProductApplyEntity tProductApply = tProductApplyManager.getTProductApplyById(id);
		return CommonUtils.msg(tProductApply);
	}

	@Override
	public R updateTProductApply(TProductApplyEntity tProductApply) {
		int count = tProductApplyManager.updateTProductApply(tProductApply);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tProductApplyManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
