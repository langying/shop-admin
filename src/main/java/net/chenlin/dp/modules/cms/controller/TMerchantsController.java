package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.service.TMerchantsService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午10:23:41
 */
@RestController
@RequestMapping("/app/merchants")
public class TMerchantsController extends AbstractController {
	
	@Autowired
	private TMerchantsService tMerchantsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TMerchantsEntity> list(@RequestBody Map<String, Object> params) {
		return tMerchantsService.listTMerchants(params);
	}
		
	/**
	 * 新增
	 * @param tMerchants
	 * @return
	 */
	@SysLog("新增商户表")
	@RequestMapping("/save")
	public R save(@RequestBody TMerchantsEntity tMerchants) {
		return tMerchantsService.saveTMerchants(tMerchants);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tMerchantsService.getTMerchantsById(id);
	}
	
	/**
	 * 修改
	 * @param tMerchants
	 * @return
	 */
	@SysLog("修改商户表")
	@RequestMapping("/update")
	public R update(@RequestBody TMerchantsEntity tMerchants) {
		return tMerchantsService.updateTMerchants(tMerchants);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除商户表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tMerchantsService.batchRemove(id);
	}
	
}
