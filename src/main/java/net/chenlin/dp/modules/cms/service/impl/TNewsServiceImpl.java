package net.chenlin.dp.modules.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TNewsEntity;
import net.chenlin.dp.modules.cms.manager.TNewsManager;
import net.chenlin.dp.modules.cms.service.TNewsService;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
@Service("tNewsService")
public class TNewsServiceImpl implements TNewsService {

	@Autowired
	private TNewsManager tNewsManager;

	@Override
	public Page<TNewsEntity> listTNews(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TNewsEntity> page = new Page<>(query);
		tNewsManager.listTNews(page, query);
		return page;
	}

	@Override
	public R saveTNews(TNewsEntity role) {
		int count = tNewsManager.saveTNews(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTNewsById(Long id) {
		TNewsEntity tNews = tNewsManager.getTNewsById(id);
		return CommonUtils.msg(tNews);
	}

	@Override
	public R updateTNews(TNewsEntity tNews) {
		int count = tNewsManager.updateTNews(tNews);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tNewsManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
