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
import net.chenlin.dp.modules.cms.entity.TFeedbackEntity;
import net.chenlin.dp.modules.cms.service.TFeedbackService;

/**
 * 意见反馈表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:50
 */
@RestController
@RequestMapping("/app/feedback")
public class TFeedbackController extends AbstractController {
	
	@Autowired
	private TFeedbackService tFeedbackService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TFeedbackEntity> list(@RequestBody Map<String, Object> params) {
		return tFeedbackService.listTFeedback(params);
	}
		
	/**
	 * 新增
	 * @param tFeedback
	 * @return
	 */
	@SysLog("新增意见反馈表")
	@RequestMapping("/save")
	public R save(@RequestBody TFeedbackEntity tFeedback) {
		return tFeedbackService.saveTFeedback(tFeedback);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tFeedbackService.getTFeedbackById(id);
	}
	
	/**
	 * 修改
	 * @param tFeedback
	 * @return
	 */
	@SysLog("修改意见反馈表")
	@RequestMapping("/update")
	public R update(@RequestBody TFeedbackEntity tFeedback) {
		return tFeedbackService.updateTFeedback(tFeedback);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除意见反馈表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tFeedbackService.batchRemove(id);
	}
	
}
