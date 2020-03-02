package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;

import java.util.Map;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
public interface TAgentLogService {

	Page<TAgentLogEntity> listTAgentLog(Map<String, Object> params);

	Page<TAgentLogEntity> list(Map<String, Object> params);

	Page<TAgentLogEntity> allList(Map<String, Object> params);

	Page<TAgentLogEntity> realList(Map<String, Object> params);
	
	R saveTAgentLog(TAgentLogEntity tAgentLog);
	
	R getTAgentLogById(Long id);
	
	R updateTAgentLog(TAgentLogEntity tAgentLog);
	
	R batchRemove(Long[] id);

	/**统计产品的pv，uv*/
	void taskRecord(String days);


	
}
