package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductApplyEntity;
import net.chenlin.dp.modules.cms.service.TProductApplyService;
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
 * @date 2018年11月01日 下午5:13:06
 */
@RestController
@RequestMapping("/app/productApply")
public class TProductApplyController extends AbstractController {
	
	@Autowired
	private TProductApplyService tProductApplyService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TProductApplyEntity> list(@RequestBody Map<String, Object> params) {
		return tProductApplyService.listTProductApply(params);
	}
		
	/**
	 * 新增
	 * @param tProductApply
	 * @return
	 */
	@SysLog("新增申请记录表")
	@RequestMapping("/save")
	public R save(@RequestBody TProductApplyEntity tProductApply) {
		return tProductApplyService.saveTProductApply(tProductApply);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tProductApplyService.getTProductApplyById(id);
	}
	
	/**
	 * 修改
	 * @param tProductApply
	 * @return
	 */
	@SysLog("修改申请记录表")
	@RequestMapping("/update")
	public R update(@RequestBody TProductApplyEntity tProductApply) {
		return tProductApplyService.updateTProductApply(tProductApply);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除申请记录表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tProductApplyService.batchRemove(id);
	}
	
}
