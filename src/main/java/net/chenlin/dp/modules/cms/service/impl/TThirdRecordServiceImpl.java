package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;
import net.chenlin.dp.modules.cms.manager.TThirdRecordManager;
import net.chenlin.dp.modules.cms.service.TThirdRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
@Service("tThirdRecordService")
public class TThirdRecordServiceImpl implements TThirdRecordService {

	@Autowired
	private TThirdRecordManager tThirdRecordManager;

	@Override
	public Page<TThirdRecordEntity> listTThirdRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TThirdRecordEntity> page = new Page<>(query);
		tThirdRecordManager.listTThirdRecord(page, query);
		return page;
	}


	@Override
	public Page<TThirdRecordEntity> list(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TThirdRecordEntity> page = new Page<>(query);
		tThirdRecordManager.list(page, query);
		return page;
	}

	@Override
	public R saveTThirdRecord(TThirdRecordEntity role) {
		int count = tThirdRecordManager.saveTThirdRecord(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTThirdRecordById(Long id) {
		TThirdRecordEntity tThirdRecord = tThirdRecordManager.getTThirdRecordById(id);
		return CommonUtils.msg(tThirdRecord);
	}

	@Override
	public R updateTThirdRecord(TThirdRecordEntity tThirdRecord) {
		int count = tThirdRecordManager.updateTThirdRecord(tThirdRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tThirdRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public void taskRecord(String days) {
		//获取每天的数据统计
		List<TThirdRecordEntity> list=tThirdRecordManager.recordList(days);
		for(TThirdRecordEntity entity:list){
			entity.setDays(days);
			tThirdRecordManager.save(entity);
		}

	}

}
