package net.chenlin.dp.modules.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;
import net.chenlin.dp.modules.cms.manager.TProductColumnManager;
import net.chenlin.dp.modules.cms.service.TProductColumnService;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
@Service("tProductColumnService")
public class TProductColumnServiceImpl implements TProductColumnService {

	@Autowired
	private TProductColumnManager tProductColumnManager;

	@Override
	public Page<TProductColumnEntity> listTProductColumn(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TProductColumnEntity> page = new Page<>(query);
		tProductColumnManager.listTProductColumn(page, query);
		return page;
	}

	@Override
	public R saveTProductColumn(TProductColumnEntity role) {
		int count = tProductColumnManager.saveTProductColumn(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTProductColumnById(Long id) {
		TProductColumnEntity tProductColumn = tProductColumnManager.getTProductColumnById(id);
		return CommonUtils.msg(tProductColumn);
	}

	@Override
	public R updateTProductColumn(TProductColumnEntity tProductColumn) {
		int count = tProductColumnManager.updateTProductColumn(tProductColumn);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tProductColumnManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
