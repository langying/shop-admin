package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TUserEntity;
import net.chenlin.dp.modules.cms.manager.TUserManager;
import net.chenlin.dp.modules.cms.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {

	@Autowired
	private TUserManager tUserManager;

	@Override
	public Page<TUserEntity> listTUser(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TUserEntity> page = new Page<>(query);
		tUserManager.listTUser(page, query);
		return page;
	}

	@Override
	public R saveTUser(TUserEntity role) {
		int count = tUserManager.saveTUser(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTUserById(Long id) {
		TUserEntity tUser = tUserManager.getTUserById(id);
		return CommonUtils.msg(tUser);
	}

	@Override
	public R updateTUser(TUserEntity tUser) {
		int count = tUserManager.updateTUser(tUser);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tUserManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
