package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TProductManager;
import net.chenlin.dp.modules.cms.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("tProductService")
public class TProductServiceImpl implements TProductService {

	@Autowired
	private TProductManager tProductManager;

	@Override
	public Page<TProductEntity> listTProduct(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TProductEntity> page = new Page<>(query);
		tProductManager.listTProduct(page, query);
		return page;
	}

	@Override
	public List<TSelectEntity> select() {
		return tProductManager.select();
	}

	@Override
	public R saveTProduct(TProductEntity role) {
		int count = tProductManager.saveTProduct(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTProductById(Long id) {
		TProductEntity tProduct = tProductManager.getTProductById(id);
		return CommonUtils.msg(tProduct);
	}

	@Override
	public R updateTProduct(TProductEntity tProduct) {
		int count = tProductManager.updateTProduct(tProduct);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tProductManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
