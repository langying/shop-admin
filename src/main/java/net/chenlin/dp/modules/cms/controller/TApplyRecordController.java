package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TApplyRecordEntity;
import net.chenlin.dp.modules.cms.service.TApplyRecordService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 申请记录表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月11日 下午3:04:32
 */
@RestController
@RequestMapping("/app/record")
public class TApplyRecordController extends AbstractController {
	
	@Autowired
	private TApplyRecordService tApplyRecordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TApplyRecordEntity> list(@RequestBody Map<String, Object> params) {
		return tApplyRecordService.listTApplyRecord(params);
	}
		
	/**
	 * 新增
	 * @param tApplyRecord
	 * @return
	 */
	@SysLog("新增申请记录表")
	@RequestMapping("/save")
	public R save(@RequestBody TApplyRecordEntity tApplyRecord) {
		return tApplyRecordService.saveTApplyRecord(tApplyRecord);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tApplyRecordService.getTApplyRecordById(id);
	}
	
	/**
	 * 修改
	 * @param tApplyRecord
	 * @return
	 */
	@SysLog("修改申请记录表")
	@RequestMapping("/update")
	public R update(@RequestBody TApplyRecordEntity tApplyRecord) {
		return tApplyRecordService.updateTApplyRecord(tApplyRecord);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除申请记录表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tApplyRecordService.batchRemove(id);
	}
	
}
