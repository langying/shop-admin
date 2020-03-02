package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;

import java.util.List;
import java.util.Map;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
public interface TChannelService {

	Page<TChannelEntity> listTChannel(Map<String, Object> params);
	
	R saveTChannel(TChannelEntity tChannel);
	
	R getTChannelById(Long id);
	
	R updateTChannel(TChannelEntity tChannel);
	
	R batchRemove(Long[] id);

	List<TSelectEntity> select();
	
}
