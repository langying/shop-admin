package net.chenlin.dp.modules.cms.manager.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TMerchantsMapper;
import net.chenlin.dp.modules.cms.dao.TProductLogMapper;
import net.chenlin.dp.modules.cms.entity.TMerchantsEntity;
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;
import net.chenlin.dp.modules.cms.manager.TProductLogManager;
import net.chenlin.dp.modules.quartz.utils.DateUtil;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
@Component("tProductLogManager")
public class TProductLogManagerImpl implements TProductLogManager {

    @Autowired
    private TProductLogMapper tProductLogMapper;

    @Autowired
    private TMerchantsMapper tMerchantsMapper;

    @Override
    public List<TProductLogEntity> listTProductLog(Page<TProductLogEntity> page, Query search) {
        List<TProductLogEntity> list = tProductLogMapper.listForPage(page, search);
        TProductLogEntity productLogEntity = new TProductLogEntity();
        for (int i = 0; i < list.size(); i++) {
            productLogEntity.setDays(list.get(i).getDays());
            productLogEntity.setPv(productLogEntity.getPv() + list.get(i).getPv());
            productLogEntity.setUv(productLogEntity.getUv() + list.get(i).getUv());
            productLogEntity.setEarnings(productLogEntity.getEarnings() + list.get(i).getEarnings());
            productLogEntity.setIncome(productLogEntity.getIncome() + list.get(i).getIncome());
            productLogEntity.setPrice(productLogEntity.getPrice() + list.get(i).getPrice());
            productLogEntity.setRegistrations(productLogEntity.getRegistrations() + list.get(i).getRegistrations());
        }
        if (productLogEntity.getUv() > 0) {
            productLogEntity.setEarnings(productLogEntity.getIncome() / productLogEntity.getUv());
            BigDecimal bigmal = new BigDecimal(productLogEntity.getEarnings());
            productLogEntity.setEarnings(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        productLogEntity.setProductName("总计");

        list.add(0, productLogEntity);
        return list;

    }

    @Override
    public List<TProductLogEntity> listMerchants(Page<TProductLogEntity> page, Query search) {
        List<TProductLogEntity> list = tProductLogMapper.listPage(page, search);
        return list;
    }

    @Override
    public List<TProductLogEntity> realList(Page<TProductLogEntity> page, Query search) {
        List<TProductLogEntity> list = tProductLogMapper.realList(page, search);
        TProductLogEntity productLogEntity = new TProductLogEntity();
        String days = DateUtil.getStringDateShort();// 获取当前时间
        for (int i = 0; i < list.size(); i++) {

            list.get(i).setDays(days);
            productLogEntity.setDays(list.get(i).getDays());
            productLogEntity.setPv(productLogEntity.getPv() + list.get(i).getPv());
            productLogEntity.setUv(productLogEntity.getUv() + list.get(i).getUv());
            productLogEntity.setEarnings(productLogEntity.getEarnings() + list.get(i).getEarnings());
            productLogEntity.setIncome(productLogEntity.getIncome() + list.get(i).getIncome());
            productLogEntity.setPrice(productLogEntity.getPrice() + list.get(i).getPrice());
            productLogEntity.setRegistrations(productLogEntity.getRegistrations() + list.get(i).getRegistrations());

        }
        if (productLogEntity.getUv() <= 0) {
            productLogEntity.setEarnings(productLogEntity.getIncome());
        }
        else {
            productLogEntity.setEarnings(productLogEntity.getIncome() / productLogEntity.getUv());
        }

        BigDecimal bigmal = new BigDecimal(productLogEntity.getEarnings());
        productLogEntity.setEarnings(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        productLogEntity.setProductName("总计");
        list.add(0, productLogEntity);
        return list;

    }

    @Override
    public int saveTProductLog(TProductLogEntity tProductLog) {
        return tProductLogMapper.save(tProductLog);
    }

    @Override
    public TProductLogEntity getTProductLogById(Long id) {
        TProductLogEntity tProductLog = tProductLogMapper.getObjectById(id);
        return tProductLog;
    }

    @Override
    public int updateTProductLog(TProductLogEntity tProductLog) {
        TMerchantsEntity merchantsEntity = tMerchantsMapper.getObjectById(tProductLog.getMerchantsId());
        if (tProductLog.getUpPayment() > 0) {
            // 客户充值
            tProductLog.setResPayment(tProductLog.getUpPayment() + tProductLog.getResPayment());
        }
        else {
            // !TODO: 如果用户充值为0，那么重复扣除甲方的额度
            tProductLog.setIncome(tProductLog.getRegistrations() * tProductLog.getPrice());
            tProductLog.setEarnings(tProductLog.getIncome() / tProductLog.getUv());
            tProductLog.setResPayment(merchantsEntity.getWallet() - tProductLog.getIncome());
        }

        TMerchantsEntity merchants = new TMerchantsEntity();
        merchants.setId(tProductLog.getMerchantsId());
        merchants.setWallet(tProductLog.getResPayment());
        tMerchantsMapper.update(merchants);
        return tProductLogMapper.update(tProductLog);
    }

    @Override
    public int batchRemove(Long[] id) {
        int count = tProductLogMapper.batchRemove(id);
        return count;
    }

    @Override
    public List<TProductLogEntity> recordList(String days) {
        List<TProductLogEntity> list = tProductLogMapper.recordList(days);
        return list;
    }

    @Override
    public int save(TProductLogEntity entity) {
        return tProductLogMapper.save(entity);
    }

}
