package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TPromoteEntity;

import java.util.Map;

/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
public interface TPromoteService {

	Page<TPromoteEntity> listTPromote(Map<String, Object> params);
	
	R saveTPromote(TPromoteEntity tPromote);
	
	R getTPromoteById(Long id);
	
	R updateTPromote(TPromoteEntity tPromote);
	
	R batchRemove(Long[] id);
	
}
