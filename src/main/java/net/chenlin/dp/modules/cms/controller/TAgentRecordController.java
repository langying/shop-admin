package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TAgentRecordEntity;
import net.chenlin.dp.modules.cms.service.TAgentRecordService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 点击推广链接记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:25
 */
@RestController
@RequestMapping("/app/agentRecord")
public class TAgentRecordController extends AbstractController {
	
	@Autowired
	private TAgentRecordService tAgentRecordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TAgentRecordEntity> list(@RequestBody Map<String, Object> params) {
		return tAgentRecordService.listTAgentRecord(params);
	}
		
	/**
	 * 新增
	 * @param tAgentRecord
	 * @return
	 */
	@SysLog("新增点击推广链接记录表")
	@RequestMapping("/save")
	public R save(@RequestBody TAgentRecordEntity tAgentRecord) {
		return tAgentRecordService.saveTAgentRecord(tAgentRecord);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tAgentRecordService.getTAgentRecordById(id);
	}
	
	/**
	 * 修改
	 * @param tAgentRecord
	 * @return
	 */
	@SysLog("修改点击推广链接记录表")
	@RequestMapping("/update")
	public R update(@RequestBody TAgentRecordEntity tAgentRecord) {
		return tAgentRecordService.updateTAgentRecord(tAgentRecord);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除点击推广链接记录表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tAgentRecordService.batchRemove(id);
	}
	
}
