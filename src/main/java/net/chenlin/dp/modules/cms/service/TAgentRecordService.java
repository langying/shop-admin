package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TAgentRecordEntity;

/**
 * 点击推广链接记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:25
 */
public interface TAgentRecordService {

	Page<TAgentRecordEntity> listTAgentRecord(Map<String, Object> params);
	
	R saveTAgentRecord(TAgentRecordEntity tAgentRecord);
	
	R getTAgentRecordById(Long id);
	
	R updateTAgentRecord(TAgentRecordEntity tAgentRecord);
	
	R batchRemove(Long[] id);
	
}
