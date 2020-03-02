package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TColumnEntity;
import net.chenlin.dp.modules.cms.service.TColumnService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
@RestController
@RequestMapping("/app/column")
public class TColumnController extends AbstractController {
	
	@Autowired
	private TColumnService tColumnService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TColumnEntity> list(@RequestBody Map<String, Object> params) {
		return tColumnService.listTColumn(params);
	}
		
	/**
	 * 新增
	 * @param tColumn
	 * @return
	 */
	@SysLog("新增产品栏目表")
	@RequestMapping("/save")
	public R save(@RequestBody TColumnEntity tColumn) {
		return tColumnService.saveTColumn(tColumn);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tColumnService.getTColumnById(id);
	}
	
	/**
	 * 修改
	 * @param tColumn
	 * @return
	 */
	@SysLog("修改产品栏目表")
	@RequestMapping("/update")
	public R update(@RequestBody TColumnEntity tColumn) {
		return tColumnService.updateTColumn(tColumn);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除产品栏目表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tColumnService.batchRemove(id);
	}
	
}
