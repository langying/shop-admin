package net.chenlin.dp.modules.cms.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TColumnMapper;
import net.chenlin.dp.modules.cms.entity.TColumnEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TColumnManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
@Component("tColumnManager")
public class TColumnManagerImpl implements TColumnManager {

	@Autowired
	private TColumnMapper tColumnMapper;
	

	@Override
	public List<TColumnEntity> listTColumn(Page<TColumnEntity> page, Query search) {
		return tColumnMapper.listForPage(page, search);
	}

	@Override
	public List<TSelectEntity> select() {
		return tColumnMapper.selectAll();
	}

	@Override
	public int saveTColumn(TColumnEntity tColumn) {
		return tColumnMapper.save(tColumn);
	}

	@Override
	public TColumnEntity getTColumnById(Long id) {
		TColumnEntity tColumn = tColumnMapper.getObjectById(id);
		return tColumn;
	}

	@Override
	public int updateTColumn(TColumnEntity tColumn) {
		return tColumnMapper.update(tColumn);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tColumnMapper.batchRemove(id);
		return count;
	}
	
}
