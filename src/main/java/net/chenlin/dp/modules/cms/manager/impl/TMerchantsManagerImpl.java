package net.chenlin.dp.modules.cms.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TMerchantsMapper;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TMerchantsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午10:23:41
 */
@Component("tMerchantsManager")
public class TMerchantsManagerImpl implements TMerchantsManager {

	@Autowired
	private TMerchantsMapper tMerchantsMapper;
	

	@Override
	public List<TMerchantsEntity> listTMerchants(Page<TMerchantsEntity> page, Query search) {
		return tMerchantsMapper.listForPage(page, search);
	}
	@Override
	public List<TSelectEntity> select() {
		return tMerchantsMapper.selectAll();
	}

	@Override
	public int saveTMerchants(TMerchantsEntity tMerchants) {
		return tMerchantsMapper.save(tMerchants);
	}

	@Override
	public TMerchantsEntity getTMerchantsById(Long id) {
		TMerchantsEntity tMerchants = tMerchantsMapper.getObjectById(id);
		return tMerchants;
	}

	@Override
	public int updateTMerchants(TMerchantsEntity tMerchants) {
		return tMerchantsMapper.update(tMerchants);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tMerchantsMapper.batchRemove(id);
		return count;
	}
	
}
