package net.chenlin.dp.modules.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TFeedbackEntity;
import net.chenlin.dp.modules.cms.manager.TFeedbackManager;
import net.chenlin.dp.modules.cms.service.TFeedbackService;

/**
 * 意见反馈表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:50
 */
@Service("tFeedbackService")
public class TFeedbackServiceImpl implements TFeedbackService {

	@Autowired
	private TFeedbackManager tFeedbackManager;

	@Override
	public Page<TFeedbackEntity> listTFeedback(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TFeedbackEntity> page = new Page<>(query);
		tFeedbackManager.listTFeedback(page, query);
		return page;
	}

	@Override
	public R saveTFeedback(TFeedbackEntity role) {
		int count = tFeedbackManager.saveTFeedback(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTFeedbackById(Long id) {
		TFeedbackEntity tFeedback = tFeedbackManager.getTFeedbackById(id);
		return CommonUtils.msg(tFeedback);
	}

	@Override
	public R updateTFeedback(TFeedbackEntity tFeedback) {
		int count = tFeedbackManager.updateTFeedback(tFeedback);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tFeedbackManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
