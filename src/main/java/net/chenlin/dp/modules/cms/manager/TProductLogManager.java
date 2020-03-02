package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;

import java.util.List;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
public interface TProductLogManager {

	List<TProductLogEntity> listTProductLog(Page<TProductLogEntity> page, Query search);

	List<TProductLogEntity> listMerchants(Page<TProductLogEntity> page, Query search);

	List<TProductLogEntity> realList(Page<TProductLogEntity> page, Query search);
	
	int saveTProductLog(TProductLogEntity tProductLog);
	
	TProductLogEntity getTProductLogById(Long id);
	
	int updateTProductLog(TProductLogEntity tProductLog);
	
	int batchRemove(Long[] id);

	List<TProductLogEntity> recordList(String days);

	int save(TProductLogEntity entity);
	
}
