package net.chenlin.dp.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
@Mapper
public interface TChannelLogMapper extends BaseMapper<TChannelLogEntity> {

    List<TChannelLogEntity> taskMonth(@Param("startDate") String startDate, @Param("endDate") String endDate);

    TChannelLogEntity getByDays(@Param("days") String days,@Param("channelId") int channelId);

	
}
