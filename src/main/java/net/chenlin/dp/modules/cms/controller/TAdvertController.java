package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TAdvertEntity;
import net.chenlin.dp.modules.cms.service.TAdvertService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
@RestController
@RequestMapping("/app/advert")
public class TAdvertController extends AbstractController {
	
	@Autowired
	private TAdvertService tAdvertService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TAdvertEntity> list(@RequestBody Map<String, Object> params) {
		return tAdvertService.listTAdvert(params);
	}
		
	/**
	 * 新增
	 * @param tAdvert
	 * @return
	 */
	@SysLog("新增banner表")
	@RequestMapping("/save")
	public R save(@RequestBody TAdvertEntity tAdvert) {
		return tAdvertService.saveTAdvert(tAdvert);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tAdvertService.getTAdvertById(id);
	}
	
	/**
	 * 修改
	 * @param tAdvert
	 * @return
	 */
	@SysLog("修改banner表")
	@RequestMapping("/update")
	public R update(@RequestBody TAdvertEntity tAdvert) {
		return tAdvertService.updateTAdvert(tAdvert);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除banner表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tAdvertService.batchRemove(id);
	}



	
}
