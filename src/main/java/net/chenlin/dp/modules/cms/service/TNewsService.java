package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TNewsEntity;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
public interface TNewsService {

	Page<TNewsEntity> listTNews(Map<String, Object> params);
	
	R saveTNews(TNewsEntity tNews);
	
	R getTNewsById(Long id);
	
	R updateTNews(TNewsEntity tNews);
	
	R batchRemove(Long[] id);
	
}
