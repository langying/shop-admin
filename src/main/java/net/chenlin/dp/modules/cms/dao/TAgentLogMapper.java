package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
@Mapper
public interface TAgentLogMapper extends BaseMapper<TAgentLogEntity> {

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TAgentLogEntity> list(Page<TAgentLogEntity> page, Query query);

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TAgentLogEntity> allList(Page<TAgentLogEntity> page, Query query);

    /**查询统计*/
    List<TAgentLogEntity> recordList(@Param("days") String days);


    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TAgentLogEntity> realList(Page<TAgentLogEntity> page, Query query);
}
