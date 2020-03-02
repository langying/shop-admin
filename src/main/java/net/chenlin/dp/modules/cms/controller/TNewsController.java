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
import net.chenlin.dp.modules.cms.entity.TNewsEntity;
import net.chenlin.dp.modules.cms.service.TNewsService;

/**
 * 资讯表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:28
 */
@RestController
@RequestMapping("/app/cms")
public class TNewsController extends AbstractController {
	
	@Autowired
	private TNewsService tNewsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TNewsEntity> list(@RequestBody Map<String, Object> params) {
		return tNewsService.listTNews(params);
	}
		
	/**
	 * 新增
	 * @param tNews
	 * @return
	 */
	@SysLog("新增资讯表")
	@RequestMapping("/save")
	public R save(@RequestBody TNewsEntity tNews) {
		return tNewsService.saveTNews(tNews);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tNewsService.getTNewsById(id);
	}
	
	/**
	 * 修改
	 * @param tNews
	 * @return
	 */
	@SysLog("修改资讯表")
	@RequestMapping("/update")
	public R update(@RequestBody TNewsEntity tNews) {
		return tNewsService.updateTNews(tNews);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除资讯表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tNewsService.batchRemove(id);
	}
	
}
