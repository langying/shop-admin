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
import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;
import net.chenlin.dp.modules.cms.service.TChannelLogService;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
@RestController
@RequestMapping("/app/channelLog")
public class TChannelLogController extends AbstractController {
	
	@Autowired
	private TChannelLogService tChannelLogService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TChannelLogEntity> list(@RequestBody Map<String, Object> params) {
		return tChannelLogService.listTChannelLog(params);
	}
		
	/**
	 * 新增
	 * @param tChannelLog
	 * @return
	 */
	@SysLog("新增渠道月统计")
	@RequestMapping("/save")
	public R save(@RequestBody TChannelLogEntity tChannelLog) {
		return tChannelLogService.saveTChannelLog(tChannelLog);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tChannelLogService.getTChannelLogById(id);
	}
	
	/**
	 * 修改
	 * @param tChannelLog
	 * @return
	 */
	@SysLog("修改渠道月统计")
	@RequestMapping("/update")
	public R update(@RequestBody TChannelLogEntity tChannelLog) {
		return tChannelLogService.updateTChannelLog(tChannelLog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除渠道月统计")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tChannelLogService.batchRemove(id);
	}
	
}
