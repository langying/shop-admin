package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
public interface TChannelManager {

	List<TChannelEntity> listTChannel(Page<TChannelEntity> page, Query search);

	List<TSelectEntity> select();
	
	int saveTChannel(TChannelEntity tChannel);
	
	TChannelEntity getTChannelById(Long id);
	
	int updateTChannel(TChannelEntity tChannel);
	
	int batchRemove(Long[] id);
	
}
