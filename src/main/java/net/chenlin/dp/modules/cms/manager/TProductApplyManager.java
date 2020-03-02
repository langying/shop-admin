package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductApplyEntity;

import java.util.List;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午5:13:06
 */
public interface TProductApplyManager {

	List<TProductApplyEntity> listTProductApply(Page<TProductApplyEntity> page, Query search);
	
	int saveTProductApply(TProductApplyEntity tProductApply);
	
	TProductApplyEntity getTProductApplyById(Long id);
	
	int updateTProductApply(TProductApplyEntity tProductApply);
	
	int batchRemove(Long[] id);
	
}
