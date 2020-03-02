package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TProductBrowseMapper;
import net.chenlin.dp.modules.cms.entity.TProductBrowseEntity;
import net.chenlin.dp.modules.cms.manager.TProductBrowseManager;

/**
 * 用户浏览商品记录
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:22
 */
@Component("tProductBrowseManager")
public class TProductBrowseManagerImpl implements TProductBrowseManager {

	@Autowired
	private TProductBrowseMapper tProductBrowseMapper;
	

	@Override
	public List<TProductBrowseEntity> listTProductBrowse(Page<TProductBrowseEntity> page, Query search) {
		return tProductBrowseMapper.listForPage(page, search);
	}

	@Override
	public int saveTProductBrowse(TProductBrowseEntity tProductBrowse) {
		return tProductBrowseMapper.save(tProductBrowse);
	}

	@Override
	public TProductBrowseEntity getTProductBrowseById(Long id) {
		TProductBrowseEntity tProductBrowse = tProductBrowseMapper.getObjectById(id);
		return tProductBrowse;
	}

	@Override
	public int updateTProductBrowse(TProductBrowseEntity tProductBrowse) {
		return tProductBrowseMapper.update(tProductBrowse);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tProductBrowseMapper.batchRemove(id);
		return count;
	}
	
}
