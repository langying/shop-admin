package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
public interface TChannelLogService {

	Page<TChannelLogEntity> listTChannelLog(Map<String, Object> params);
	
	R saveTChannelLog(TChannelLogEntity tChannelLog);
	
	R getTChannelLogById(Long id);
	
	R updateTChannelLog(TChannelLogEntity tChannelLog);
	
	R batchRemove(Long[] id);

	void taskMonth(String startDate,String endDate);
	
}
