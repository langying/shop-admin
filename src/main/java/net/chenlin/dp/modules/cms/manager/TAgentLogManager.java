package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;

import java.util.List;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
public interface TAgentLogManager {

	List<TAgentLogEntity> listTAgentLog(Page<TAgentLogEntity> page, Query search);

	List<TAgentLogEntity> list(Page<TAgentLogEntity> page, Query search);

	List<TAgentLogEntity> allList(Page<TAgentLogEntity> page, Query search);

	List<TAgentLogEntity> realList(Page<TAgentLogEntity> page, Query search);
	
	int saveTAgentLog(TAgentLogEntity tAgentLog);
	
	TAgentLogEntity getTAgentLogById(Long id);
	
	int updateTAgentLog(TAgentLogEntity tAgentLog);
	
	int batchRemove(Long[] id);

	List<TAgentLogEntity> recordList(String days);

	int save(TAgentLogEntity entity);
	
}
