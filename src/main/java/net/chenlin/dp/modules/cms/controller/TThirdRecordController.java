package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;
import net.chenlin.dp.modules.cms.service.TThirdRecordService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
@RestController
@RequestMapping("/app/thirdRecord")
public class TThirdRecordController extends AbstractController {
	
	@Autowired
	private TThirdRecordService tThirdRecordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TThirdRecordEntity> list(@RequestBody Map<String, Object> params) {
		return tThirdRecordService.listTThirdRecord(params);
	}

	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list_record")
	public Page<TThirdRecordEntity> list_record(@RequestBody Map<String, Object> params) {
		return tThirdRecordService.list(params);
	}
		
	/**
	 * 新增
	 * @param tThirdRecord
	 * @return
	 */
	@SysLog("新增第三方统计表")
	@RequestMapping("/save")
	public R save(@RequestBody TThirdRecordEntity tThirdRecord) {
		return tThirdRecordService.saveTThirdRecord(tThirdRecord);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tThirdRecordService.getTThirdRecordById(id);
	}
	
	/**
	 * 修改
	 * @param tThirdRecord
	 * @return
	 */
	@SysLog("修改第三方统计表")
	@RequestMapping("/update")
	public R update(@RequestBody TThirdRecordEntity tThirdRecord) {
		return tThirdRecordService.updateTThirdRecord(tThirdRecord);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除第三方统计表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tThirdRecordService.batchRemove(id);
	}
	
}
