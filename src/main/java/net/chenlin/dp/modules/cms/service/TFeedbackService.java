package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TFeedbackEntity;

/**
 * 意见反馈表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:50
 */
public interface TFeedbackService {

	Page<TFeedbackEntity> listTFeedback(Map<String, Object> params);
	
	R saveTFeedback(TFeedbackEntity tFeedback);
	
	R getTFeedbackById(Long id);
	
	R updateTFeedback(TFeedbackEntity tFeedback);
	
	R batchRemove(Long[] id);
	
}
