package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TAdvertEntity;
import net.chenlin.dp.modules.cms.manager.TAdvertManager;
import net.chenlin.dp.modules.cms.service.TAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
@Service("tAdvertService")
public class TAdvertServiceImpl implements TAdvertService {

	@Autowired
	private TAdvertManager tAdvertManager;

	@Override
	public Page<TAdvertEntity> listTAdvert(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TAdvertEntity> page = new Page<>(query);
		tAdvertManager.listTAdvert(page, query);
		return page;
	}

	@Override
	public R saveTAdvert(TAdvertEntity role) {
		int count = tAdvertManager.saveTAdvert(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTAdvertById(Long id) {
		TAdvertEntity tAdvert = tAdvertManager.getTAdvertById(id);
		return CommonUtils.msg(tAdvert);
	}

	@Override
	public R updateTAdvert(TAdvertEntity tAdvert) {
		int count = tAdvertManager.updateTAdvert(tAdvert);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tAdvertManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
