package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.modules.cms.entity.TProductEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
@Mapper
public interface TProductMapper extends BaseMapper<TProductEntity> {


    List<TSelectEntity> selectAll();
	
}
