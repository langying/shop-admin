package net.chenlin.dp.modules.cms.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TProductLogMapper;
import net.chenlin.dp.modules.cms.dao.TProductMapper;
import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TProductManager;
import net.chenlin.dp.modules.quartz.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
@Component("tProductManager")
public class TProductManagerImpl implements TProductManager {

	@Autowired
	private TProductMapper tProductMapper;


	

	@Override
	public List<TProductEntity> listTProduct(Page<TProductEntity> page, Query search) {

		return tProductMapper.listForPage(page, search);
	}

	@Override
	public List<TSelectEntity> select() {
		return tProductMapper.selectAll();
	}

	@Override
	public int saveTProduct(TProductEntity tProduct) {
		return tProductMapper.save(tProduct);
	}

	@Override
	public TProductEntity getTProductById(Long id) {
		TProductEntity tProduct = tProductMapper.getObjectById(id);
		String [] cols={};
		if(tProduct.getColumns()!=null){
			cols=tProduct.getColumns().split(",");
			tProduct.setColId(cols);
		}
		return tProduct;
	}

	@Override
	public int updateTProduct(TProductEntity tProduct) {
		return tProductMapper.update(tProduct);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tProductMapper.batchRemove(id);
		return count;
	}
	
}
