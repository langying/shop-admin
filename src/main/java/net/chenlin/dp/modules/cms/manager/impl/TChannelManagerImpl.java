package net.chenlin.dp.modules.cms.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.utils.MD5Utils;
import net.chenlin.dp.modules.cms.dao.TChannelMapper;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.manager.TChannelManager;
import net.chenlin.dp.modules.sys.dao.SysUserMapper;
import net.chenlin.dp.modules.sys.dao.SysUserRoleMapper;
import net.chenlin.dp.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
@Component("tChannelManager")
public class TChannelManagerImpl implements TChannelManager {

	@Autowired
	private TChannelMapper tChannelMapper;

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	

	@Override
	public List<TChannelEntity> listTChannel(Page<TChannelEntity> page, Query search) {
		return tChannelMapper.listForPage(page, search);
	}
	@Override
	public List<TSelectEntity> select() {
		return tChannelMapper.selectAll();
	}
	@Override
	public int saveTChannel(TChannelEntity tChannel) {

		SysUserEntity user=new SysUserEntity();
        user.setUsername(tChannel.getAccount());
        user.setPassword(tChannel.getPassword());
        user.setStatus(1);
		user.setOrgId((long)21);
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		List<Long> roleIdList =new ArrayList<>();
		roleIdList.add((long) 40);
		int count = sysUserMapper.save(user);
		Query query = new Query();
		query.put("userId", user.getUserId());
		query.put("roleIdList", roleIdList);
		sysUserRoleMapper.save(query);

		return tChannelMapper.save(tChannel);

	}

	@Override
	public TChannelEntity getTChannelById(Long id) {
		TChannelEntity tChannel = tChannelMapper.getObjectById(id);
		return tChannel;
	}

	@Override
	public int updateTChannel(TChannelEntity tChannel) {
		return tChannelMapper.update(tChannel);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tChannelMapper.batchRemove(id);
		return count;
	}
	
}
