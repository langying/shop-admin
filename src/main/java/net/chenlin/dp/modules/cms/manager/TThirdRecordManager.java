package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;

import java.util.List;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
public interface TThirdRecordManager {

	List<TThirdRecordEntity> listTThirdRecord(Page<TThirdRecordEntity> page, Query search);

	List<TThirdRecordEntity> list(Page<TThirdRecordEntity> page, Query search);
	
	int saveTThirdRecord(TThirdRecordEntity tThirdRecord);
	
	TThirdRecordEntity getTThirdRecordById(Long id);
	
	int updateTThirdRecord(TThirdRecordEntity tThirdRecord);
	
	int batchRemove(Long[] id);

	List<TThirdRecordEntity> recordList(String days);

	int save(TThirdRecordEntity tThirdRecord);
	
}
