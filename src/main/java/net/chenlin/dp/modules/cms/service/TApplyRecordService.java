package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TApplyRecordEntity;

import java.util.Map;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月11日 下午3:04:32
 */
public interface TApplyRecordService {

	Page<TApplyRecordEntity> listTApplyRecord(Map<String, Object> params);
	
	R saveTApplyRecord(TApplyRecordEntity tApplyRecord);
	
	R getTApplyRecordById(Long id);
	
	R updateTApplyRecord(TApplyRecordEntity tApplyRecord);
	
	R batchRemove(Long[] id);
	
}
