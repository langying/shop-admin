package net.chenlin.dp.modules.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;
import net.chenlin.dp.modules.cms.manager.TMerchantsManager;
import net.chenlin.dp.modules.cms.manager.TProductLogManager;
import net.chenlin.dp.modules.cms.service.TProductLogService;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
@Service("tProductLogService")
public class TProductLogServiceImpl implements TProductLogService {

    @Autowired
    private TProductLogManager tProductLogManager;

    @Autowired
    private TMerchantsManager tMerchantsManager;

    @Override
    public Page<TProductLogEntity> listTProductLog(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TProductLogEntity> page = new Page<>(query);
        tProductLogManager.listTProductLog(page, query);
        return page;
    }

    @Override
    public Page<TProductLogEntity> listMerchants(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TProductLogEntity> page = new Page<>(query);
        tProductLogManager.listMerchants(page, query);
        return page;
    }

    @Override
    public Page<TProductLogEntity> realList(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TProductLogEntity> page = new Page<>(query);
        tProductLogManager.realList(page, query);
        return page;
    }

    @Override
    public R saveTProductLog(TProductLogEntity role) {
        int count = tProductLogManager.saveTProductLog(role);
        return CommonUtils.msg(count);
    }

    @Override
    public R getTProductLogById(Long id) {
        TProductLogEntity tProductLog = tProductLogManager.getTProductLogById(id);
        return CommonUtils.msg(tProductLog);
    }

    @Override
    public R updateTProductLog(TProductLogEntity tProductLog) {
        int count = tProductLogManager.updateTProductLog(tProductLog);
        return CommonUtils.msg(count);
    }

    @Override
    public R batchRemove(Long[] id) {
        int count = tProductLogManager.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

    @Override
    public void taskRecord(String days) {
        // 获取每天的数据统计
        List<TProductLogEntity> list = tProductLogManager.recordList(days);
        for (TProductLogEntity entity : list) {
            Integer merId = entity.getMerchantsId();
            if (merId == null || merId <= 0) {
                continue;
            }
            TMerchantsEntity merchantsEntity = tMerchantsManager.getTMerchantsById(merId.longValue());
            entity.setDays(days);
            entity.setResPayment(merchantsEntity.getWallet() - entity.getIncome());
            tProductLogManager.save(entity);

            TMerchantsEntity merchants = new TMerchantsEntity();
            merchants.setId(entity.getMerchantsId());
            merchants.setWallet(entity.getResPayment());
            tMerchantsManager.updateTMerchants(merchants);
        }
    }

}
