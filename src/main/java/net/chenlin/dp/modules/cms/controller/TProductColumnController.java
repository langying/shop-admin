package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductColumnEntity;
import net.chenlin.dp.modules.cms.service.TProductColumnService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
@RestController
@RequestMapping("/app/productColumn")
public class TProductColumnController extends AbstractController {
	
	@Autowired
	private TProductColumnService tProductColumnService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TProductColumnEntity> list(@RequestBody Map<String, Object> params) {
		return tProductColumnService.listTProductColumn(params);
	}
		
	/**
	 * 新增
	 * @param tProductColumn
	 * @return
	 */
	@SysLog("新增产品栏目关联表")
	@RequestMapping("/save")
	public R save(@RequestBody TProductColumnEntity tProductColumn) {
		return tProductColumnService.saveTProductColumn(tProductColumn);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tProductColumnService.getTProductColumnById(id);
	}
	
	/**
	 * 修改
	 * @param tProductColumn
	 * @return
	 */
	@SysLog("修改产品栏目关联表")
	@RequestMapping("/update")
	public R update(@RequestBody TProductColumnEntity tProductColumn) {
		return tProductColumnService.updateTProductColumn(tProductColumn);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除产品栏目关联表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tProductColumnService.batchRemove(id);
	}
	
}
