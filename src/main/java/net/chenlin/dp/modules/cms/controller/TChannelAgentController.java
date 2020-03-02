package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;
import net.chenlin.dp.modules.cms.service.TChannelAgentService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午9:28:08
 */
@RestController
@RequestMapping("/app/channelAgent")
public class TChannelAgentController extends AbstractController {
	
	@Autowired
	private TChannelAgentService tChannelAgentService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TChannelAgentEntity> list(@RequestBody Map<String, Object> params) {
		return tChannelAgentService.listTChannelAgent(params);
	}
		
	/**
	 * 新增
	 * @param tChannelAgent
	 * @return
	 */
	@SysLog("新增渠道的代理(推广)表")
	@RequestMapping("/save")
	public R save(@RequestBody TChannelAgentEntity tChannelAgent) {
		return tChannelAgentService.saveTChannelAgent(tChannelAgent);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tChannelAgentService.getTChannelAgentById(id);
	}
	
	/**
	 * 修改
	 * @param tChannelAgent
	 * @return
	 */
	@SysLog("修改渠道的代理(推广)表")
	@RequestMapping("/update")
	public R update(@RequestBody TChannelAgentEntity tChannelAgent) {
		return tChannelAgentService.updateTChannelAgent(tChannelAgent);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道的代理(推广)表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tChannelAgentService.batchRemove(id);
	}
	
}
