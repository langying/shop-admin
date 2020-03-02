package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;

import java.util.Map;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
public interface TThirdRecordService {

	Page<TThirdRecordEntity> listTThirdRecord(Map<String, Object> params);

	Page<TThirdRecordEntity> list(Map<String, Object> params);
	
	R saveTThirdRecord(TThirdRecordEntity tThirdRecord);
	
	R getTThirdRecordById(Long id);
	
	R updateTThirdRecord(TThirdRecordEntity tThirdRecord);
	
	R batchRemove(Long[] id);

	/**统计第三方的pv，uv*/
	void taskRecord(String days);
	
}
