package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:35:24
 */
@Mapper
public interface TChannelMapper extends BaseMapper<TChannelEntity> {

    List<TSelectEntity> selectAll();

    TChannelEntity findByAccount(String account);
	
}
