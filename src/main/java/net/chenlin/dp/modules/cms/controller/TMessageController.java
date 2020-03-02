package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TMessageEntity;
import net.chenlin.dp.modules.cms.service.TMessageService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
@RestController
@RequestMapping("/app/message")
public class TMessageController extends AbstractController {
	
	@Autowired
	private TMessageService tMessageService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TMessageEntity> list(@RequestBody Map<String, Object> params) {
		return tMessageService.listTMessage(params);
	}
		
	/**
	 * 新增
	 * @param tMessage
	 * @return
	 */
	@SysLog("新增消息推送表")
	@RequestMapping("/save")
	public R save(@RequestBody TMessageEntity tMessage) {
		return tMessageService.saveTMessage(tMessage);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tMessageService.getTMessageById(id);
	}
	
	/**
	 * 修改
	 * @param tMessage
	 * @return
	 */
	@SysLog("修改消息推送表")
	@RequestMapping("/update")
	public R update(@RequestBody TMessageEntity tMessage) {
		return tMessageService.updateTMessage(tMessage);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除消息推送表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tMessageService.batchRemove(id);
	}


	
}
