package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月01日 下午10:23:41
 */
@Mapper
public interface TMerchantsMapper extends BaseMapper<TMerchantsEntity> {

    List<TSelectEntity> selectAll();
	
}
