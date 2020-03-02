package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TEarningsEntity;
import net.chenlin.dp.modules.cms.service.TEarningsService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
@RestController
@RequestMapping("/app/earnings")
public class TEarningsController extends AbstractController {
	
	@Autowired
	private TEarningsService tEarningsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TEarningsEntity> list(@RequestBody Map<String, Object> params) {
		return tEarningsService.listTEarnings(params);
	}
		
	/**
	 * 新增
	 * @param tEarnings
	 * @return
	 */
	@SysLog("新增收益分析表")
	@RequestMapping("/save")
	public R save(@RequestBody TEarningsEntity tEarnings) {
		return tEarningsService.saveTEarnings(tEarnings);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tEarningsService.getTEarningsById(id);
	}
	
	/**
	 * 修改
	 * @param tEarnings
	 * @return
	 */
	@SysLog("修改收益分析表")
	@RequestMapping("/update")
	public R update(@RequestBody TEarningsEntity tEarnings) {
		return tEarningsService.updateTEarnings(tEarnings);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除收益分析表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tEarningsService.batchRemove(id);
	}
	
}
