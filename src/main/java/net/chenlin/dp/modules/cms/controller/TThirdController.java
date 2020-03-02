package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TThirdEntity;
import net.chenlin.dp.modules.cms.service.TThirdService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 第三方链接
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:46
 */
@RestController
@RequestMapping("/app/third")
public class TThirdController extends AbstractController {
	
	@Autowired
	private TThirdService tThirdService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TThirdEntity> list(@RequestBody Map<String, Object> params) {
		return tThirdService.listTThird(params);
	}
		
	/**
	 * 新增
	 * @param tThird
	 * @return
	 */
	@SysLog("新增第三方链接")
	@RequestMapping("/save")
	public R save(@RequestBody TThirdEntity tThird) {
		return tThirdService.saveTThird(tThird);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tThirdService.getTThirdById(id);
	}
	
	/**
	 * 修改
	 * @param tThird
	 * @return
	 */
	@SysLog("修改第三方链接")
	@RequestMapping("/update")
	public R update(@RequestBody TThirdEntity tThird) {
		return tThirdService.updateTThird(tThird);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除第三方链接")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tThirdService.batchRemove(id);
	}



	
}
