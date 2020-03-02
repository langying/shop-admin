package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TMessageEntity;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
public interface TMessageService {

	Page<TMessageEntity> listTMessage(Map<String, Object> params);
	
	R saveTMessage(TMessageEntity tMessage);
	
	R getTMessageById(Long id);
	
	R updateTMessage(TMessageEntity tMessage);
	
	R batchRemove(Long[] id);
	
}
