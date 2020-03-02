package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;

/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午10:23:41
 */
public interface TMerchantsManager {

	List<TMerchantsEntity> listTMerchants(Page<TMerchantsEntity> page, Query search);

	List<TSelectEntity> select();
	
	int saveTMerchants(TMerchantsEntity tMerchants);
	
	TMerchantsEntity getTMerchantsById(Long id);
	
	int updateTMerchants(TMerchantsEntity tMerchants);
	
	int batchRemove(Long[] id);
	
}
