package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TMerchantsManager;
import net.chenlin.dp.modules.cms.service.TMerchantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("tMerchantsService")
public class TMerchantsServiceImpl implements TMerchantsService {

	@Autowired
	private TMerchantsManager tMerchantsManager;

	@Override
	public Page<TMerchantsEntity> listTMerchants(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TMerchantsEntity> page = new Page<>(query);
		tMerchantsManager.listTMerchants(page, query);
		return page;
	}
	@Override
	public List<TSelectEntity> select() {
		return tMerchantsManager.select();
	}
	@Override
	public R saveTMerchants(TMerchantsEntity role) {
		int count = tMerchantsManager.saveTMerchants(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTMerchantsById(Long id) {
		TMerchantsEntity tMerchants = tMerchantsManager.getTMerchantsById(id);
		return CommonUtils.msg(tMerchants);
	}

	@Override
	public R updateTMerchants(TMerchantsEntity tMerchants) {
		int count = tMerchantsManager.updateTMerchants(tMerchants);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tMerchantsManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
