package net.chenlin.dp.modules.cms.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.jpush.InitJiGuangConfig;
import net.chenlin.dp.common.utils.MD5Utils;
import net.chenlin.dp.common.utils.NumberUtil;
import net.chenlin.dp.modules.cms.dao.TChannelAgentMapper;
import net.chenlin.dp.modules.cms.dao.TChannelMapper;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.manager.TChannelAgentManager;
import net.chenlin.dp.modules.sys.dao.SysUserMapper;
import net.chenlin.dp.modules.sys.dao.SysUserRoleMapper;
import net.chenlin.dp.modules.sys.entity.SysUserEntity;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
@Component("tChannelAgentManager")
public class TChannelAgentManagerImpl implements TChannelAgentManager {

    @Autowired
    private TChannelAgentMapper tChannelAgentMapper;

    @Autowired
    private TChannelMapper tChannelMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<TChannelAgentEntity> listTChannelAgent(Page<TChannelAgentEntity> page, Query search) {
        return tChannelAgentMapper.listForPage(page, search);
    }

    @Override
    public int saveTChannelAgent(TChannelAgentEntity tChannelAgent) {

        SysUserEntity user = new SysUserEntity();
        user.setUsername(tChannelAgent.getAccount());
        user.setPassword(tChannelAgent.getPassword());
        user.setStatus(1);
        user.setOrgId((long) 21);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add((long) 40);
        int count = sysUserMapper.save(user);
        Query query = new Query();
        query.put("userId", user.getUserId());
        query.put("roleIdList", roleIdList);
        sysUserRoleMapper.save(query);

        tChannelAgent.setCode(NumberUtil.toRandom(8));// 跳转码
        tChannelAgent.setMirrorUrl(InitJiGuangConfig.AGENT_PATH + "?sign=" + tChannelAgent.getCode());
        TChannelEntity entity = tChannelMapper.getObjectById(tChannelAgent.getChannelId());
        int num = tChannelAgentMapper.getNum(tChannelAgent.getChannelId());
        tChannelAgent.setName(entity.getName() + "-" + (num + 1));

        tChannelAgent.setLinkUrl(InitJiGuangConfig.H5_PATH + "/spread.html#/spreadOne?uid=" + tChannelAgent.getCode());
        return tChannelAgentMapper.save(tChannelAgent);
    }

    @Override
    public TChannelAgentEntity getTChannelAgentById(Long id) {
        TChannelAgentEntity tChannelAgent = tChannelAgentMapper.getObjectById(id);
        return tChannelAgent;
    }

    @Override
    public int updateTChannelAgent(TChannelAgentEntity tChannelAgent) {
        return tChannelAgentMapper.update(tChannelAgent);
    }

    @Override
    public int batchRemove(Long[] id) {
        int count = tChannelAgentMapper.batchRemove(id);
        return count;
    }

}
