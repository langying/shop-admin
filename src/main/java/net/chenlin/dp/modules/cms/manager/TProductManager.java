package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;

/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
public interface TProductManager {

	List<TProductEntity> listTProduct(Page<TProductEntity> page, Query search);

	List<TSelectEntity> select();
	
	int saveTProduct(TProductEntity tProduct);
	
	TProductEntity getTProductById(Long id);
	
	int updateTProduct(TProductEntity tProduct);
	
	int batchRemove(Long[] id);
	
}
