package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TColumnEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;
import java.util.Map;

/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
public interface TColumnService {

	Page<TColumnEntity> listTColumn(Map<String, Object> params);
	
	R saveTColumn(TColumnEntity tColumn);
	
	R getTColumnById(Long id);
	
	R updateTColumn(TColumnEntity tColumn);
	
	R batchRemove(Long[] id);

	List<TSelectEntity> select();
	
}
