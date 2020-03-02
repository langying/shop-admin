package net.chenlin.dp.modules.cms.manager.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TEarningsMapper;
import net.chenlin.dp.modules.cms.entity.TEarningsEntity;
import net.chenlin.dp.modules.cms.manager.TEarningsManager;

/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
@Component("tEarningsManager")
public class TEarningsManagerImpl implements TEarningsManager {

    @Autowired
    private TEarningsMapper tEarningsMapper;

    @Override
    public List<TEarningsEntity> listTEarnings(Page<TEarningsEntity> page, Query search) {
        List<TEarningsEntity> list = tEarningsMapper.listForPage(page, search);
        TEarningsEntity entity = new TEarningsEntity();
        for (int i = 0; i < list.size(); i++) {
            entity.setIncome(entity.getIncome() + list.get(i).getIncome());
            entity.setRealCost(entity.getRealCost() + list.get(i).getRealCost());
            entity.setProfit(entity.getProfit() + list.get(i).getProfit());
        }
        BigDecimal bigmal = new BigDecimal(entity.getIncome());
        entity.setIncome(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigmal = new BigDecimal(entity.getRealCost());
        entity.setRealCost(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        bigmal = new BigDecimal(entity.getProfit());
        entity.setProfit(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        entity.setInterRate(entity.getProfit() / entity.getIncome() * 100);
        bigmal = new BigDecimal(entity.getInterRate());
        entity.setInterRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        entity.setDays("总计");
        list.add(0, entity);
        return list;
    }

    @Override
    public int saveTEarnings(TEarningsEntity tEarnings) {

        TEarningsEntity entity = tEarningsMapper.findByDays(tEarnings.getDays());
        if (entity != null) {// 更新
            entity.setIncome(tEarnings.getIncome());
            BigDecimal bigmal = new BigDecimal(entity.getIncome());
            entity.setIncome(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            entity.setRealCost(tEarnings.getRealCost());
            bigmal = new BigDecimal(entity.getRealCost());
            entity.setRealCost(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            entity.setProfit(entity.getIncome() - entity.getRealCost());
            bigmal = new BigDecimal(entity.getProfit());
            entity.setProfit(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            entity.setInterRate(entity.getProfit() / entity.getIncome() * 100);
            bigmal = new BigDecimal(entity.getInterRate());
            entity.setInterRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            return tEarningsMapper.update(entity);
        }
        else {// 新增
            return tEarningsMapper.save(tEarnings);
        }

    }

    @Override
    public TEarningsEntity getTEarningsById(Long id) {
        TEarningsEntity tEarnings = tEarningsMapper.getObjectById(id);
        return tEarnings;
    }

    @Override
    public TEarningsEntity getDays(String days) {
        TEarningsEntity entity = tEarningsMapper.getDays(days);
        if (entity != null) {
            double income = entity.getIncome() == null ? 0 : entity.getIncome();
            double realCost = entity.getRealCost() == null ? 0 : entity.getRealCost();
            double profit = income - realCost;
            double interRate = income == 0 ? 0 : profit / income * 100;

            entity.setDays(days);
            entity.setProfit(profit);
            entity.setInterRate(interRate);
        }
        else {
            entity = new TEarningsEntity();
            entity.setDays(days);
        }
        return entity;
    }

    @Override
    public int updateTEarnings(TEarningsEntity tEarnings) {
        return tEarningsMapper.update(tEarnings);
    }

    @Override
    public int batchRemove(Long[] id) {
        int count = tEarningsMapper.batchRemove(id);
        return count;
    }

}
