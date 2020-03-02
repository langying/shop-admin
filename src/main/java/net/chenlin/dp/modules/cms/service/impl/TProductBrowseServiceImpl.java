package net.chenlin.dp.modules.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TProductBrowseEntity;
import net.chenlin.dp.modules.cms.manager.TProductBrowseManager;
import net.chenlin.dp.modules.cms.service.TProductBrowseService;

/**
 * 用户浏览商品记录
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:22
 */
@Service("tProductBrowseService")
public class TProductBrowseServiceImpl implements TProductBrowseService {

	@Autowired
	private TProductBrowseManager tProductBrowseManager;

	@Override
	public Page<TProductBrowseEntity> listTProductBrowse(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TProductBrowseEntity> page = new Page<>(query);
		tProductBrowseManager.listTProductBrowse(page, query);
		return page;
	}

	@Override
	public R saveTProductBrowse(TProductBrowseEntity role) {
		int count = tProductBrowseManager.saveTProductBrowse(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTProductBrowseById(Long id) {
		TProductBrowseEntity tProductBrowse = tProductBrowseManager.getTProductBrowseById(id);
		return CommonUtils.msg(tProductBrowse);
	}

	@Override
	public R updateTProductBrowse(TProductBrowseEntity tProductBrowse) {
		int count = tProductBrowseManager.updateTProductBrowse(tProductBrowse);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tProductBrowseManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
