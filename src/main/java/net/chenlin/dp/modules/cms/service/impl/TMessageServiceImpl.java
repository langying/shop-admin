package net.chenlin.dp.modules.cms.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TMessageEntity;
import net.chenlin.dp.modules.cms.manager.TMessageManager;
import net.chenlin.dp.modules.cms.service.TMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
@Service("tMessageService")
public class TMessageServiceImpl implements TMessageService {

	@Autowired
	private TMessageManager tMessageManager;

	@Override
	public Page<TMessageEntity> listTMessage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TMessageEntity> page = new Page<>(query);
		tMessageManager.listTMessage(page, query);
		return page;
	}

	@Override
	public R saveTMessage(TMessageEntity role) {
		int count = tMessageManager.saveTMessage(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getTMessageById(Long id) {
		TMessageEntity tMessage = tMessageManager.getTMessageById(id);
		return CommonUtils.msg(tMessage);
	}

	@Override
	public R updateTMessage(TMessageEntity tMessage) {
		int count = tMessageManager.updateTMessage(tMessage);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = tMessageManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
