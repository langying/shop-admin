package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TColumnEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TColumnManager;
import net.chenlin.dp.modules.cms.service.TColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
@Service("tColumnService")
public class TColumnServiceImpl implements TColumnService {

	@Autowired
	private TColumnManager tColumnManager;

	@Override
	public Page<TColumnEntity> listTColumn(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TColumnEntity> page = new Page<>(query);
		tColumnManager.listTColumn(page, query);
		return page;
	}


	@Override
	public List<TSelectEntity> select() {
		return tColumnManager.select();
	}

	@Override
	public R saveTColumn(TColumnEntity role) {
		int count = tColumnManager.saveTColumn(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTColumnById(Long id) {
		TColumnEntity tColumn = tColumnManager.getTColumnById(id);
		return CommonUtils.msg(tColumn);
	}

	@Override
	public R updateTColumn(TColumnEntity tColumn) {
		int count = tColumnManager.updateTColumn(tColumn);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tColumnManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
