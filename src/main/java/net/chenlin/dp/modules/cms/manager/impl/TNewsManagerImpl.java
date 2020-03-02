package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TNewsMapper;
import net.chenlin.dp.modules.cms.entity.TNewsEntity;
import net.chenlin.dp.modules.cms.manager.TNewsManager;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
@Component("tNewsManager")
public class TNewsManagerImpl implements TNewsManager {

	@Autowired
	private TNewsMapper tNewsMapper;
	

	@Override
	public List<TNewsEntity> listTNews(Page<TNewsEntity> page, Query search) {
		return tNewsMapper.listForPage(page, search);
	}

	@Override
	public int saveTNews(TNewsEntity tNews) {
		return tNewsMapper.save(tNews);
	}

	@Override
	public TNewsEntity getTNewsById(Long id) {
		TNewsEntity tNews = tNewsMapper.getObjectById(id);
		return tNews;
	}

	@Override
	public int updateTNews(TNewsEntity tNews) {
		return tNewsMapper.update(tNews);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tNewsMapper.batchRemove(id);
		return count;
	}
	
}
