package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductBrowseEntity;

import java.util.Map;

/**
 * 用户浏览商品记录
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:22
 */
public interface TProductBrowseService {

	Page<TProductBrowseEntity> listTProductBrowse(Map<String, Object> params);
	
	R saveTProductBrowse(TProductBrowseEntity tProductBrowse);
	
	R getTProductBrowseById(Long id);
	
	R updateTProductBrowse(TProductBrowseEntity tProductBrowse);
	
	R batchRemove(Long[] id);
	
}
