package net.chenlin.dp.modules.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.dao.TChannelLogMapper;
import net.chenlin.dp.modules.cms.entity.TChannelLogEntity;
import net.chenlin.dp.modules.cms.manager.TChannelLogManager;
import net.chenlin.dp.modules.cms.service.TChannelLogService;

/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
@Service("tChannelLogService")
public class TChannelLogServiceImpl implements TChannelLogService {

    @Autowired
    private TChannelLogManager tChannelLogManager;

    @Autowired
    private TChannelLogMapper tChannelLogMapper;

    @Override
    public Page<TChannelLogEntity> listTChannelLog(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TChannelLogEntity> page = new Page<>(query);
        tChannelLogManager.listTChannelLog(page, query);
        return page;
    }

    @Override
    public R saveTChannelLog(TChannelLogEntity role) {
        int count = tChannelLogManager.saveTChannelLog(role);
        return CommonUtils.msg(count);
    }

    @Override
    public R getTChannelLogById(Long id) {
        TChannelLogEntity tChannelLog = tChannelLogManager.getTChannelLogById(id);
        return CommonUtils.msg(tChannelLog);
    }

    @Override
    public R updateTChannelLog(TChannelLogEntity tChannelLog) {
        int count = tChannelLogManager.updateTChannelLog(tChannelLog);
        return CommonUtils.msg(count);
    }

    @Override
    public R batchRemove(Long[] id) {
        int count = tChannelLogManager.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

    @Override
    public void taskMonth(String startDate, String endDate) {
        // 获取每天的数据统计
        List<TChannelLogEntity> list = tChannelLogManager.taskMonth(startDate, endDate);
        for (TChannelLogEntity entity : list) {
            TChannelLogEntity tEntity = tChannelLogMapper.getByDays(entity.getDays(), entity.getChannelId());
            if (tEntity != null) {
                tEntity.setPrice(entity.getPrice());
                tEntity.setSettleNumber(entity.getSettleNumber());
                tEntity.setRealCost(entity.getRealCost());
                tChannelLogManager.updateTChannelLog(tEntity);
            }
            else {
                tChannelLogManager.saveTChannelLog(entity);
            }
        }
    }
}
