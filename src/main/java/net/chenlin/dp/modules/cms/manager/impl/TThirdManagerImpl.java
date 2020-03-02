package net.chenlin.dp.modules.cms.manager.impl;

import java.util.List;

import net.chenlin.dp.common.jpush.InitJiGuangConfig;
import net.chenlin.dp.common.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TThirdMapper;
import net.chenlin.dp.modules.cms.entity.TThirdEntity;
import net.chenlin.dp.modules.cms.manager.TThirdManager;

/**
 * 第三方链接
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:46
 */
@Component("tThirdManager")
public class TThirdManagerImpl implements TThirdManager {

	@Autowired
	private TThirdMapper tThirdMapper;
	

	@Override
	public List<TThirdEntity> listTThird(Page<TThirdEntity> page, Query search) {
		return tThirdMapper.listForPage(page, search);
	}

	@Override
	public int saveTThird(TThirdEntity tThird) {
		if(tThird.getCode()==null || "".equals(tThird.getCode())){
			tThird.setCode(NumberUtil.toRandom(5));//跳转码
		}
		if(tThird.getType()==1){
			tThird.setLinkUrl("");
		}else{
			tThird.setProductId(0);
		}
		tThird.setMirrorUrl(InitJiGuangConfig.THIRD_URL+"?sign="+tThird.getCode());

		return tThirdMapper.save(tThird);
	}

	@Override
	public TThirdEntity getTThirdById(Long id) {
		TThirdEntity tThird = tThirdMapper.getObjectById(id);
		return tThird;
	}

	@Override
	public int updateTThird(TThirdEntity tThird) {
		if(tThird.getCode()==null || "".equals(tThird.getCode())){
			tThird.setCode(NumberUtil.toRandom(5));//跳转码
		}
		if(tThird.getType()==1){
			tThird.setLinkUrl("");
		}else{
			tThird.setProductId(0);
		}
		tThird.setMirrorUrl(InitJiGuangConfig.THIRD_URL+"?sign="+tThird.getCode());
		return tThirdMapper.update(tThird);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = tThirdMapper.batchRemove(id);
		return count;
	}
	
}
