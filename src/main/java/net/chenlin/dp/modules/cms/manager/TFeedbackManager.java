package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TFeedbackEntity;

/**
 * 意见反馈表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:50
 */
public interface TFeedbackManager {

	List<TFeedbackEntity> listTFeedback(Page<TFeedbackEntity> page, Query search);
	
	int saveTFeedback(TFeedbackEntity tFeedback);
	
	TFeedbackEntity getTFeedbackById(Long id);
	
	int updateTFeedback(TFeedbackEntity tFeedback);
	
	int batchRemove(Long[] id);
	
}
