package net.chenlin.dp.modules.cms.dao;


import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.entity.TThirdRecordEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
@Mapper
public interface TThirdRecordMapper extends BaseMapper<TThirdRecordEntity> {

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<TThirdRecordEntity> list(Page<TThirdRecordEntity> page, Query query);

    /**查询统计*/
    List<TThirdRecordEntity> recordList(@Param("days") String days);


	
}
