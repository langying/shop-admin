package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TNewsEntity;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
public interface TNewsManager {

	List<TNewsEntity> listTNews(Page<TNewsEntity> page, Query search);
	
	int saveTNews(TNewsEntity tNews);
	
	TNewsEntity getTNewsById(Long id);
	
	int updateTNews(TNewsEntity tNews);
	
	int batchRemove(Long[] id);
	
}
