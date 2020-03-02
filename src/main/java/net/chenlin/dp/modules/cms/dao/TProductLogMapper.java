package net.chenlin.dp.modules.cms.dao;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
@Mapper
public interface TProductLogMapper extends BaseMapper<TProductLogEntity> {

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TProductLogEntity> list(Page<TProductLogEntity> page, Query query);

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TProductLogEntity> listPage(Page<TProductLogEntity> page, Query query);

    /**查询统计*/
    List<TProductLogEntity> recordList(@Param("days") String days);


    List<TProductLogEntity> realList(Page<TProductLogEntity> page, Query query);
	
}
