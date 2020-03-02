package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TEarningsEntity;

import java.util.List;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
public interface TEarningsManager {

	List<TEarningsEntity> listTEarnings(Page<TEarningsEntity> page, Query search);
	
	int saveTEarnings(TEarningsEntity tEarnings);
	
	TEarningsEntity getTEarningsById(Long id);

	TEarningsEntity getDays(String days);
	
	int updateTEarnings(TEarningsEntity tEarnings);
	
	int batchRemove(Long[] id);


	
}
