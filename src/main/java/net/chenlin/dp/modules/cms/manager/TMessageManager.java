package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TMessageEntity;

import java.util.List;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
public interface TMessageManager {

	List<TMessageEntity> listTMessage(Page<TMessageEntity> page, Query search);
	
	int saveTMessage(TMessageEntity tMessage);
	
	TMessageEntity getTMessageById(Long id);
	
	int updateTMessage(TMessageEntity tMessage);
	
	int batchRemove(Long[] id);
	
}
