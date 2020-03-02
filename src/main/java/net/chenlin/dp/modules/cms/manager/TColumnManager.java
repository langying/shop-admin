package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TColumnEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;

/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
public interface TColumnManager {

	List<TColumnEntity> listTColumn(Page<TColumnEntity> page, Query search);

	List<TSelectEntity> select();
	
	int saveTColumn(TColumnEntity tColumn);
	
	TColumnEntity getTColumnById(Long id);
	
	int updateTColumn(TColumnEntity tColumn);
	
	int batchRemove(Long[] id);
	
}
