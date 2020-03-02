package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TThirdEntity;
import net.chenlin.dp.modules.cms.manager.TThirdManager;
import net.chenlin.dp.modules.cms.service.TThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 第三方链接
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:46
 */
@Service("tThirdService")
public class TThirdServiceImpl implements TThirdService {

	@Autowired
	private TThirdManager tThirdManager;

	@Override
	public Page<TThirdEntity> listTThird(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TThirdEntity> page = new Page<>(query);
		tThirdManager.listTThird(page, query);
		return page;
	}

	@Override
	public R saveTThird(TThirdEntity role) {
		int count = tThirdManager.saveTThird(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTThirdById(Long id) {
		TThirdEntity tThird = tThirdManager.getTThirdById(id);
		return CommonUtils.msg(tThird);
	}

	@Override
	public R updateTThird(TThirdEntity tThird) {
		int count = tThirdManager.updateTThird(tThird);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tThirdManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
