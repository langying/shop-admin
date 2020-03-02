package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TPromoteMapper;
import net.chenlin.dp.modules.cms.entity.TPromoteEntity;
import net.chenlin.dp.modules.cms.manager.TPromoteManager;

/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
@Component("tPromoteManager")
public class TPromoteManagerImpl implements TPromoteManager {

	@Autowired
	private TPromoteMapper tPromoteMapper;
	

	@Override
	public List<TPromoteEntity> listTPromote(Page<TPromoteEntity> page, Query search) {
		return tPromoteMapper.listForPage(page, search);
	}

	@Override
	public int saveTPromote(TPromoteEntity tPromote) {
		return tPromoteMapper.save(tPromote);
	}

	@Override
	public TPromoteEntity getTPromoteById(Long id) {
		TPromoteEntity tPromote = tPromoteMapper.getObjectById(id);
		return tPromote;
	}

	@Override
	public int updateTPromote(TPromoteEntity tPromote) {
		return tPromoteMapper.update(tPromote);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tPromoteMapper.batchRemove(id);
		return count;
	}
	
}
