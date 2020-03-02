package net.chenlin.dp.modules.cms.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TUserEntity;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
public interface TUserService {

	Page<TUserEntity> listTUser(Map<String, Object> params);
	
	R saveTUser(TUserEntity tUser);
	
	R getTUserById(Long id);
	
	R updateTUser(TUserEntity tUser);
	
	R batchRemove(Long[] id);
	
}
