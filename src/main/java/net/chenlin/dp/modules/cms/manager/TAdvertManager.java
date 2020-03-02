package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TAdvertEntity;

/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
public interface TAdvertManager {

	List<TAdvertEntity> listTAdvert(Page<TAdvertEntity> page, Query search);
	
	int saveTAdvert(TAdvertEntity tAdvert);
	
	TAdvertEntity getTAdvertById(Long id);
	
	int updateTAdvert(TAdvertEntity tAdvert);
	
	int batchRemove(Long[] id);
	
}
