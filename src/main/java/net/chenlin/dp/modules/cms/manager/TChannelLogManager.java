package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
public interface TChannelLogManager {

	List<TChannelLogEntity> listTChannelLog(Page<TChannelLogEntity> page, Query search);
	
	int saveTChannelLog(TChannelLogEntity tChannelLog);
	
	TChannelLogEntity getTChannelLogById(Long id);
	
	int updateTChannelLog(TChannelLogEntity tChannelLog);
	
	int batchRemove(Long[] id);

	List<TChannelLogEntity>  taskMonth(String startDate,String endDate);
	
}
