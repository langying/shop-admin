package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;
import java.util.Map;

/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午10:23:41
 */
public interface TMerchantsService {

	Page<TMerchantsEntity> listTMerchants(Map<String, Object> params);
	
	R saveTMerchants(TMerchantsEntity tMerchants);
	
	R getTMerchantsById(Long id);
	
	R updateTMerchants(TMerchantsEntity tMerchants);
	
	R batchRemove(Long[] id);

	List<TSelectEntity> select();
	
}
