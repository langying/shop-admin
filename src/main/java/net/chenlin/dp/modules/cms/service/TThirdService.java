package net.chenlin.dp.modules.cms.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.cms.entity.TThirdEntity;

import java.util.Map;

/**
 * 第三方链接
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:46
 */
public interface TThirdService {

	Page<TThirdEntity> listTThird(Map<String, Object> params);
	
	R saveTThird(TThirdEntity tThird);
	
	R getTThirdById(Long id);
	
	R updateTThird(TThirdEntity tThird);
	
	R batchRemove(Long[] id);
	
}
