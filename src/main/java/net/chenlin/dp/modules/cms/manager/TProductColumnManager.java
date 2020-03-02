package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;

import java.util.List;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
public interface TProductColumnManager {

	List<TProductColumnEntity> listTProductColumn(Page<TProductColumnEntity> page, Query search);
	
	int saveTProductColumn(TProductColumnEntity tProductColumn);
	
	TProductColumnEntity getTProductColumnById(Long id);
	
	int updateTProductColumn(TProductColumnEntity tProductColumn);
	
	int batchRemove(Long[] id);
	
}
