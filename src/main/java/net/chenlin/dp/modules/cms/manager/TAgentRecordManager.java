package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TAgentRecordEntity;

/**
 * 点击推广链接记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:25
 */
public interface TAgentRecordManager {

	List<TAgentRecordEntity> listTAgentRecord(Page<TAgentRecordEntity> page, Query search);
	
	int saveTAgentRecord(TAgentRecordEntity tAgentRecord);
	
	TAgentRecordEntity getTAgentRecordById(Long id);
	
	int updateTAgentRecord(TAgentRecordEntity tAgentRecord);
	
	int batchRemove(Long[] id);
	
}
