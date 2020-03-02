package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TUserEntity;
import net.chenlin.dp.modules.cms.service.TUserService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:08:17
 */
@RestController
@RequestMapping("/app/user")
public class TUserController extends AbstractController {
	
	@Autowired
	private TUserService tUserService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TUserEntity> list(@RequestBody Map<String, Object> params) {
		return tUserService.listTUser(params);
	}
		
	/**
	 * 新增
	 * @param tUser
	 * @return
	 */
	@SysLog("新增用户表")
	@RequestMapping("/save")
	public R save(@RequestBody TUserEntity tUser) {
		return tUserService.saveTUser(tUser);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tUserService.getTUserById(id);
	}
	
	/**
	 * 修改
	 * @param tUser
	 * @return
	 */
	@SysLog("修改用户表")
	@RequestMapping("/update")
	public R update(@RequestBody TUserEntity tUser) {
		return tUserService.updateTUser(tUser);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tUserService.batchRemove(id);
	}
	
}
