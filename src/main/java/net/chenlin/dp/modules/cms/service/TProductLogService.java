package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;

import java.util.Map;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
public interface TProductLogService {

	Page<TProductLogEntity> listTProductLog(Map<String, Object> params);

	Page<TProductLogEntity> listMerchants(Map<String, Object> params);

	Page<TProductLogEntity> realList(Map<String, Object> params);
	
	R saveTProductLog(TProductLogEntity tProductLog);
	
	R getTProductLogById(Long id);
	
	R updateTProductLog(TProductLogEntity tProductLog);
	
	R batchRemove(Long[] id);

	/**统计产品的pv，uv*/
	void taskRecord(String days);
	
}
