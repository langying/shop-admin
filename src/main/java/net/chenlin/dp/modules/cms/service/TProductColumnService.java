package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;

import java.util.Map;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
public interface TProductColumnService {

	Page<TProductColumnEntity> listTProductColumn(Map<String, Object> params);
	
	R saveTProductColumn(TProductColumnEntity tProductColumn);
	
	R getTProductColumnById(Long id);
	
	R updateTProductColumn(TProductColumnEntity tProductColumn);
	
	R batchRemove(Long[] id);
	
}
