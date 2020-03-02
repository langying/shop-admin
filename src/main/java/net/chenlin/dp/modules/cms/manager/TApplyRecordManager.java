package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TApplyRecordEntity;

import java.util.List;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月11日 下午3:04:32
 */
public interface TApplyRecordManager {

	List<TApplyRecordEntity> listTApplyRecord(Page<TApplyRecordEntity> page, Query search);
	
	int saveTApplyRecord(TApplyRecordEntity tApplyRecord);
	
	TApplyRecordEntity getTApplyRecordById(Long id);
	
	int updateTApplyRecord(TApplyRecordEntity tApplyRecord);
	
	int batchRemove(Long[] id);
	
}
