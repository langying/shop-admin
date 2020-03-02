package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.service.TProductService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
@RestController
@RequestMapping("/app/product")
public class TProductController extends AbstractController {
	
	@Autowired
	private TProductService tProductService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TProductEntity> list(@RequestBody Map<String, Object> params) {
		return tProductService.listTProduct(params);
	}
		
	/**
	 * 新增
	 * @param tProduct
	 * @return
	 */
	@SysLog("新增产品表")
	@RequestMapping("/save")
	public R save(@RequestBody TProductEntity tProduct) {
		if(tProduct.getLinkUrl()!=null){
			tProduct.setLinkUrl(tProduct.getLinkUrl().replaceAll("&amp;","&"));
		}
		return tProductService.saveTProduct(tProduct);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tProductService.getTProductById(id);
	}
	
	/**
	 * 修改
	 * @param tProduct
	 * @return
	 */
	@SysLog("修改产品表")
	@RequestMapping("/update")
	public R update(@RequestBody TProductEntity tProduct) {
		if(tProduct.getLinkUrl()!=null){
			tProduct.setLinkUrl(tProduct.getLinkUrl().replaceAll("&amp;","&"));
		}
		return tProductService.updateTProduct(tProduct);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除产品表")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tProductService.batchRemove(id);
	}



	
}
