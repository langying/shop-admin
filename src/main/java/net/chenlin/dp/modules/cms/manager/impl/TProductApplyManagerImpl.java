package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TProductApplyMapper;
import net.chenlin.dp.modules.cms.entity.TProductApplyEntity;
import net.chenlin.dp.modules.cms.manager.TProductApplyManager;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午5:13:06
 */
@Component("tProductApplyManager")
public class TProductApplyManagerImpl implements TProductApplyManager {

	@Autowired
	private TProductApplyMapper tProductApplyMapper;
	

	@Override
	public List<TProductApplyEntity> listTProductApply(Page<TProductApplyEntity> page, Query search) {
		return tProductApplyMapper.listForPage(page, search);
	}

	@Override
	public int saveTProductApply(TProductApplyEntity tProductApply) {
		return tProductApplyMapper.save(tProductApply);
	}

	@Override
	public TProductApplyEntity getTProductApplyById(Long id) {
		TProductApplyEntity tProductApply = tProductApplyMapper.getObjectById(id);
		return tProductApply;
	}

	@Override
	public int updateTProductApply(TProductApplyEntity tProductApply) {
		return tProductApplyMapper.update(tProductApply);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tProductApplyMapper.batchRemove(id);
		return count;
	}
	
}
