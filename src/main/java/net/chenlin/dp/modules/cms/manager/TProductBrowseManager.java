package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductBrowseEntity;

import java.util.List;

/**
 * 用户浏览商品记录
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:22
 */
public interface TProductBrowseManager {

	List<TProductBrowseEntity> listTProductBrowse(Page<TProductBrowseEntity> page, Query search);
	
	int saveTProductBrowse(TProductBrowseEntity tProductBrowse);
	
	TProductBrowseEntity getTProductBrowseById(Long id);
	
	int updateTProductBrowse(TProductBrowseEntity tProductBrowse);
	
	int batchRemove(Long[] id);
	
}
