package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TAdvertMapper;
import net.chenlin.dp.modules.cms.entity.TAdvertEntity;
import net.chenlin.dp.modules.cms.manager.TAdvertManager;

/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
@Component("tAdvertManager")
public class TAdvertManagerImpl implements TAdvertManager {

	@Autowired
	private TAdvertMapper tAdvertMapper;
	

	@Override
	public List<TAdvertEntity> listTAdvert(Page<TAdvertEntity> page, Query search) {
		return tAdvertMapper.listForPage(page, search);
	}

	@Override
	public int saveTAdvert(TAdvertEntity tAdvert) {
		if(tAdvert.getType()==1){
			tAdvert.setLinkUrl("");
		}else{
			tAdvert.setProductId(0);
		}


		return tAdvertMapper.save(tAdvert);

	}

	@Override
	public TAdvertEntity getTAdvertById(Long id) {
		TAdvertEntity tAdvert = tAdvertMapper.getObjectById(id);
		return tAdvert;
	}

	@Override
	public int updateTAdvert(TAdvertEntity tAdvert) {
		if(tAdvert.getType()==1){
			tAdvert.setLinkUrl("");
		}else{
			tAdvert.setProductId(0);
		}
		return tAdvertMapper.update(tAdvert);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tAdvertMapper.batchRemove(id);
		return count;
	}
	
}
