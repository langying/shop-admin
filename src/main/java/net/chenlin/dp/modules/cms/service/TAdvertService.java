package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TAdvertEntity;

/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
public interface TAdvertService {

	Page<TAdvertEntity> listTAdvert(Map<String, Object> params);
	
	R saveTAdvert(TAdvertEntity tAdvert);
	
	R getTAdvertById(Long id);
	
	R updateTAdvert(TAdvertEntity tAdvert);
	
	R batchRemove(Long[] id);
	
}
