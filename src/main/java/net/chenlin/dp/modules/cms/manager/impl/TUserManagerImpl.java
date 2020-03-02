package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TUserMapper;
import net.chenlin.dp.modules.cms.entity.TUserEntity;
import net.chenlin.dp.modules.cms.manager.TUserManager;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
@Component("tUserManager")
public class TUserManagerImpl implements TUserManager {

	@Autowired
	private TUserMapper tUserMapper;
	

	@Override
	public List<TUserEntity> listTUser(Page<TUserEntity> page, Query search) {
		return tUserMapper.listForPage(page, search);
	}

	@Override
	public int saveTUser(TUserEntity tUser) {
		return tUserMapper.save(tUser);
	}

	@Override
	public TUserEntity getTUserById(Long id) {
		TUserEntity tUser = tUserMapper.getObjectById(id);
		return tUser;
	}

	@Override
	public int updateTUser(TUserEntity tUser) {
		return tUserMapper.update(tUser);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tUserMapper.batchRemove(id);
		return count;
	}
	
}
