package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductBrowseEntity;
import net.chenlin.dp.modules.cms.service.TProductBrowseService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户浏览商品记录
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:46:22
 */
@RestController
@RequestMapping("/app/browse")
public class TProductBrowseController extends AbstractController {
	
	@Autowired
	private TProductBrowseService tProductBrowseService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TProductBrowseEntity> list(@RequestBody Map<String, Object> params) {
		return tProductBrowseService.listTProductBrowse(params);
	}
		
	/**
	 * 新增
	 * @param tProductBrowse
	 * @return
	 */
	@SysLog("新增用户浏览商品记录")
	@RequestMapping("/save")
	public R save(@RequestBody TProductBrowseEntity tProductBrowse) {
		return tProductBrowseService.saveTProductBrowse(tProductBrowse);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tProductBrowseService.getTProductBrowseById(id);
	}
	
	/**
	 * 修改
	 * @param tProductBrowse
	 * @return
	 */
	@SysLog("修改用户浏览商品记录")
	@RequestMapping("/update")
	public R update(@RequestBody TProductBrowseEntity tProductBrowse) {
		return tProductBrowseService.updateTProductBrowse(tProductBrowse);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户浏览商品记录")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tProductBrowseService.batchRemove(id);
	}
	
}
