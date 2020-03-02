package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TFeedbackMapper;
import net.chenlin.dp.modules.cms.entity.TFeedbackEntity;
import net.chenlin.dp.modules.cms.manager.TFeedbackManager;

/**
 * 意见反馈表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:50
 */
@Component("tFeedbackManager")
public class TFeedbackManagerImpl implements TFeedbackManager {

	@Autowired
	private TFeedbackMapper tFeedbackMapper;
	

	@Override
	public List<TFeedbackEntity> listTFeedback(Page<TFeedbackEntity> page, Query search) {
		return tFeedbackMapper.listForPage(page, search);
	}

	@Override
	public int saveTFeedback(TFeedbackEntity tFeedback) {
		return tFeedbackMapper.save(tFeedback);
	}

	@Override
	public TFeedbackEntity getTFeedbackById(Long id) {
		TFeedbackEntity tFeedback = tFeedbackMapper.getObjectById(id);
		return tFeedback;
	}

	@Override
	public int updateTFeedback(TFeedbackEntity tFeedback) {
		return tFeedbackMapper.update(tFeedback);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tFeedbackMapper.batchRemove(id);
		return count;
	}
	
}
