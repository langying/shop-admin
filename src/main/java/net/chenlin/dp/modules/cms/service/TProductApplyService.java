package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductApplyEntity;

import java.util.Map;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午5:13:06
 */
public interface TProductApplyService {

	Page<TProductApplyEntity> listTProductApply(Map<String, Object> params);
	
	R saveTProductApply(TProductApplyEntity tProductApply);
	
	R getTProductApplyById(Long id);
	
	R updateTProductApply(TProductApplyEntity tProductApply);
	
	R batchRemove(Long[] id);
	
}
