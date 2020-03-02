package net.chenlin.dp.modules.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.service.TChannelService;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
@RestController
@RequestMapping("/app/channel")
public class TChannelController extends AbstractController {
	
	@Autowired
	private TChannelService tChannelService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TChannelEntity> list(@RequestBody Map<String, Object> params) {
		return tChannelService.listTChannel(params);
	}
		
	/**
	 * 新增
	 * @param tChannel
	 * @return
	 */
	@SysLog("新增渠道表")
	@RequestMapping("/save")
	public R save(@RequestBody TChannelEntity tChannel) {
		return tChannelService.saveTChannel(tChannel);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tChannelService.getTChannelById(id);
	}
	
	/**
	 * 修改
	 * @param tChannel
	 * @return
	 */
	@SysLog("修改渠道表")
	@RequestMapping("/update")
	public R update(@RequestBody TChannelEntity tChannel) {
		return tChannelService.updateTChannel(tChannel);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tChannelService.batchRemove(id);
	}
	
}
