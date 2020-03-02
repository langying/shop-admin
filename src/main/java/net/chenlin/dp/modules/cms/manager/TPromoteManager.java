package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TPromoteEntity;

import java.util.List;

/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
public interface TPromoteManager {

	List<TPromoteEntity> listTPromote(Page<TPromoteEntity> page, Query search);
	
	int saveTPromote(TPromoteEntity tPromote);
	
	TPromoteEntity getTPromoteById(Long id);
	
	int updateTPromote(TPromoteEntity tPromote);
	
	int batchRemove(Long[] id);
	
}
