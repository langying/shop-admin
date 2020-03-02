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
import net.chenlin.dp.modules.cms.entity.TPromoteEntity;
import net.chenlin.dp.modules.cms.service.TPromoteService;

/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
@RestController
@RequestMapping("/app/promote")
public class TPromoteController extends AbstractController {
	
	@Autowired
	private TPromoteService tPromoteService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TPromoteEntity> list(@RequestBody Map<String, Object> params) {
		return tPromoteService.listTPromote(params);
	}
		
	/**
	 * 新增
	 * @param tPromote
	 * @return
	 */
	@SysLog("新增首页推荐位表")
	@RequestMapping("/save")
	public R save(@RequestBody TPromoteEntity tPromote) {
		return tPromoteService.saveTPromote(tPromote);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tPromoteService.getTPromoteById(id);
	}
	
	/**
	 * 修改
	 * @param tPromote
	 * @return
	 */
	@SysLog("修改首页推荐位表")
	@RequestMapping("/update")
	public R update(@RequestBody TPromoteEntity tPromote) {
		return tPromoteService.updateTPromote(tPromote);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除首页推荐位表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tPromoteService.batchRemove(id);
	}
	
}
