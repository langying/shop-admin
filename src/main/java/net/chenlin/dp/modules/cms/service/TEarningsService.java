package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TEarningsEntity;

import java.util.Map;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
public interface TEarningsService {

	Page<TEarningsEntity> listTEarnings(Map<String, Object> params);
	
	R saveTEarnings(TEarningsEntity tEarnings);
	
	R getTEarningsById(Long id);
	
	R updateTEarnings(TEarningsEntity tEarnings);
	
	R batchRemove(Long[] id);

	/**统计收益*/
	void taskRecord(String days);
	
}
