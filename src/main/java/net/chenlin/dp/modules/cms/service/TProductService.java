package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;
import java.util.Map;

/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
public interface TProductService {

	Page<TProductEntity> listTProduct(Map<String, Object> params);

	List<TSelectEntity> select();
	
	R saveTProduct(TProductEntity tProduct);
	
	R getTProductById(Long id);
	
	R updateTProduct(TProductEntity tProduct);
	
	R batchRemove(Long[] id);
	
}
