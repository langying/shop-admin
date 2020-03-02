package net.chenlin.dp.modules.cms.manager;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TThirdEntity;

import java.util.List;

/**
 * 第三方链接
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:46
 */
public interface TThirdManager {

	List<TThirdEntity> listTThird(Page<TThirdEntity> page, Query search);
	
	int saveTThird(TThirdEntity tThird);
	
	TThirdEntity getTThirdById(Long id);
	
	int updateTThird(TThirdEntity tThird);
	
	int batchRemove(Long[] id);
	
}
