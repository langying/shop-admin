package net.chenlin.dp.modules.cms.manager;

import java.util.List;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TUserEntity;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
public interface TUserManager {

	List<TUserEntity> listTUser(Page<TUserEntity> page, Query search);
	
	int saveTUser(TUserEntity tUser);
	
	TUserEntity getTUserById(Long id);
	
	int updateTUser(TUserEntity tUser);
	
	int batchRemove(Long[] id);
	
}
