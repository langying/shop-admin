package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TProductColumnMapper;
import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;
import net.chenlin.dp.modules.cms.manager.TProductColumnManager;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
@Component("tProductColumnManager")
public class TProductColumnManagerImpl implements TProductColumnManager {

	@Autowired
	private TProductColumnMapper tProductColumnMapper;
	

	@Override
	public List<TProductColumnEntity> listTProductColumn(Page<TProductColumnEntity> page, Query search) {
		return tProductColumnMapper.listForPage(page, search);
	}

	@Override
	public int saveTProductColumn(TProductColumnEntity tProductColumn) {
		return tProductColumnMapper.save(tProductColumn);
	}

	@Override
	public TProductColumnEntity getTProductColumnById(Long id) {
		TProductColumnEntity tProductColumn = tProductColumnMapper.getObjectById(id);
		return tProductColumn;
	}

	@Override
	public int updateTProductColumn(TProductColumnEntity tProductColumn) {
		return tProductColumnMapper.update(tProductColumn);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tProductColumnMapper.batchRemove(id);
		return count;
	}
	
}
