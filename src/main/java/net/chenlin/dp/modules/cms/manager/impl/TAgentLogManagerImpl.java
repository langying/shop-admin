package net.chenlin.dp.modules.cms.manager.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.cms.dao.TAgentLogMapper;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;
import net.chenlin.dp.modules.cms.manager.TAgentLogManager;
import net.chenlin.dp.modules.quartz.utils.DateUtil;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
@Component("tAgentLogManager")
public class TAgentLogManagerImpl implements TAgentLogManager {

    @Autowired
    private TAgentLogMapper tAgentLogMapper;

    @Override
    public List<TAgentLogEntity> listTAgentLog(Page<TAgentLogEntity> page, Query search) {

        List<TAgentLogEntity> list = tAgentLogMapper.listForPage(page, search);
        TAgentLogEntity totalEntity = new TAgentLogEntity();
        for (int i = 0; i < list.size(); i++) {
            TAgentLogEntity entity = list.get(i);
            totalEntity.setPv(totalEntity.getPv() + entity.getPv());
            totalEntity.setUv(totalEntity.getUv() + entity.getUv());
            totalEntity.setPrice(totalEntity.getPrice() + entity.getPrice());
            totalEntity.setSettleNumber(totalEntity.getSettleNumber() + entity.getSettleNumber());
            totalEntity.setLoginNum(totalEntity.getLoginNum() + entity.getLoginNum());
            totalEntity.setRegisterNum(totalEntity.getRegisterNum() + entity.getRegisterNum());
            totalEntity.setFirstLoginNum(totalEntity.getFirstLoginNum() + entity.getFirstLoginNum());
            totalEntity.setNowApplyNum(totalEntity.getNowApplyNum() + entity.getNowApplyNum());
            totalEntity.setNowApplyPnum(totalEntity.getNowApplyPnum() + entity.getNowApplyPnum());
            totalEntity.setAverageRegisterApplyNum(totalEntity.getAverageRegisterApplyNum() + entity.getAverageRegisterApplyNum());
            totalEntity.setAverageNowApplyNum(totalEntity.getAverageNowApplyNum() + entity.getAverageNowApplyNum());
            totalEntity.setAverageApplySuccessNum(totalEntity.getAverageApplySuccessNum() + entity.getAverageApplySuccessNum());
            totalEntity.setAverageSevenApplyNum(totalEntity.getAverageSevenApplyNum() + entity.getAverageSevenApplyNum());
            totalEntity.setNowApplyRate(totalEntity.getNowApplyRate() + entity.getNowApplyRate());
            totalEntity.setRealCost(totalEntity.getRealCost() + entity.getRealCost());
            totalEntity.setApplySuccessNum(totalEntity.getApplySuccessNum() + entity.getApplySuccessNum());
            totalEntity.setLoginSevenNum(totalEntity.getLoginSevenNum() + entity.getLoginSevenNum());
            /*
             * if (list.get(i).getSettleNumber() <= 0) {
             * if (list.get(i).getRegisterNum() > list.get(i).getInitNumber()) {
             * Double num = (list.get(i).getRegisterNum() - list.get(i).getInitNumber()) * list.get(i).getDiscount();
             * list.get(i).setSettleNumber(list.get(i).getInitNumber() + num.intValue());
             * } else {
             * list.get(i).setSettleNumber(list.get(i).getRegisterNum());
             * }
             * }
             */
        }
        // 算平均值
        if (list.size() > 0) {
            // 登录率
            double firstLoginNum = totalEntity.getFirstLoginNum();
            double registerNum = totalEntity.getRegisterNum();
            if (registerNum <= 0) {
                totalEntity.setLoginRate(0D);
            }
            else {
                totalEntity.setLoginRate(firstLoginNum / registerNum);
            }
            BigDecimal bigmal = new BigDecimal(totalEntity.getLoginRate());
            totalEntity.setLoginRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setNowApplyRate(totalEntity.getNowApplyRate() / list.size());
            bigmal = new BigDecimal(totalEntity.getNowApplyRate());
            totalEntity.setNowApplyRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageApplySuccessNum(totalEntity.getAverageApplySuccessNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageApplySuccessNum());
            totalEntity.setAverageApplySuccessNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageNowApplyNum(totalEntity.getAverageNowApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageNowApplyNum());
            totalEntity.setAverageNowApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageRegisterApplyNum(totalEntity.getAverageRegisterApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageRegisterApplyNum());
            totalEntity.setAverageRegisterApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageSevenApplyNum(totalEntity.getAverageSevenApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageSevenApplyNum());
            totalEntity.setAverageSevenApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            if (totalEntity.getSettleNumber() > 0) {
                totalEntity.setPrice(totalEntity.getRealCost() / totalEntity.getSettleNumber());
                bigmal = new BigDecimal(totalEntity.getPrice());
                totalEntity.setPrice(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }

        }
        totalEntity.setChannelName("总计");
        list.add(0, totalEntity);
        return list;
    }

    @Override
    public List<TAgentLogEntity> list(Page<TAgentLogEntity> page, Query search) {
        List<TAgentLogEntity> list = tAgentLogMapper.list(page, search);
        TAgentLogEntity totalEntity = new TAgentLogEntity();
        for (int i = 0; i < list.size(); i++) {
            TAgentLogEntity entity = list.get(i);
            if (list.get(i).getRegisterNum() > list.get(i).getInitNumber()) {
                Double num = (list.get(i).getRegisterNum() - list.get(i).getInitNumber()) * list.get(i).getDiscount();
                list.get(i).setRegisterNum(list.get(i).getInitNumber() + num.intValue());
            }
            else {
                list.get(i).setRegisterNum(list.get(i).getRegisterNum());
            }
            totalEntity.setRegisterNum(totalEntity.getRegisterNum() + entity.getRegisterNum());
            totalEntity.setChannelName("总计");
        }
        list.add(0, totalEntity);
        return list;
    }

    @Override
    public List<TAgentLogEntity> allList(Page<TAgentLogEntity> page, Query search) {
        List<TAgentLogEntity> list = tAgentLogMapper.allList(page, search);
        String days = DateUtil.getStringDateShort();// 获取当前时间
        TAgentLogEntity totalEntity = new TAgentLogEntity();
        for (int i = 0; i < list.size(); i++) {

            list.get(i).setDays(days);

            totalEntity.setPv(totalEntity.getPv() + list.get(i).getPv());
            totalEntity.setUv(totalEntity.getUv() + list.get(i).getUv());
            totalEntity.setPrice(totalEntity.getPrice() + list.get(i).getPrice());
            totalEntity.setLoginNum(totalEntity.getLoginNum() + list.get(i).getLoginNum());
            totalEntity.setRegisterNum(totalEntity.getRegisterNum() + list.get(i).getRegisterNum());
            totalEntity.setFirstLoginNum(totalEntity.getFirstLoginNum() + list.get(i).getFirstLoginNum());
            totalEntity.setNowApplyNum(totalEntity.getNowApplyNum() + list.get(i).getNowApplyNum());
            totalEntity.setNowApplyPnum(totalEntity.getNowApplyPnum() + list.get(i).getNowApplyPnum());
            totalEntity.setApplySuccessNum(totalEntity.getApplySuccessNum() + list.get(i).getApplySuccessNum());
            totalEntity.setLoginSevenNum(totalEntity.getLoginSevenNum() + list.get(i).getLoginSevenNum());

            if (list.get(i).getRegisterNum() > 0) {
                // 登录率
                double firstLoginNum = list.get(i).getFirstLoginNum();
                double registerNum = list.get(i).getRegisterNum();
                list.get(i).setLoginRate(firstLoginNum / registerNum);

                // 保留两位小数点
                BigDecimal loginReate = new BigDecimal(list.get(i).getLoginRate());
                list.get(i).setLoginRate(loginReate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setLoginRate(totalEntity.getLoginRate() + list.get(i).getLoginRate());

                // 注册用户平均申请订单数
                double nowApplyNum = list.get(i).getNowApplyNum();
                list.get(i).setAverageRegisterApplyNum(nowApplyNum / registerNum);

                // 保留两位小数点
                BigDecimal aran = new BigDecimal(list.get(i).getAverageRegisterApplyNum());
                list.get(i).setAverageRegisterApplyNum(aran.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setAverageRegisterApplyNum(totalEntity.getAverageRegisterApplyNum() + list.get(i).getAverageRegisterApplyNum());
            }
            if (list.get(i).getNowApplyPnum() > 0) {

                // 平均立即申请
                double nowApplyPnum = list.get(i).getNowApplyPnum();
                double nowApplyNum = list.get(i).getNowApplyNum();
                list.get(i).setAverageNowApplyNum(nowApplyNum / nowApplyPnum);

                // 保留两位小数点
                BigDecimal anan = new BigDecimal(list.get(i).getAverageNowApplyNum());
                list.get(i).setAverageNowApplyNum(anan.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setAverageNowApplyNum(totalEntity.getAverageNowApplyNum() + list.get(i).getAverageNowApplyNum());

                // 平均我已申请
                double applySuccessNum = list.get(i).getApplySuccessNum();
                list.get(i).setAverageApplySuccessNum(applySuccessNum / nowApplyPnum);

                // 保留两位小数点
                BigDecimal aasn = new BigDecimal(list.get(i).getAverageApplySuccessNum());
                list.get(i).setAverageApplySuccessNum(aasn.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setAverageApplySuccessNum(totalEntity.getAverageApplySuccessNum() + list.get(i).getAverageApplySuccessNum());

            }
            if (list.get(i).getLoginSevenNum() > 0) {
                // APP首次登陆用户平均立即申请订单数
                double loginSevenNum = list.get(i).getLoginSevenNum();
                double nowApplyNum = list.get(i).getNowApplyNum();
                list.get(i).setAverageSevenApplyNum(nowApplyNum / loginSevenNum);

                // 保留两位小数点
                BigDecimal asan = new BigDecimal(list.get(i).getAverageSevenApplyNum());
                list.get(i).setAverageSevenApplyNum(asan.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setAverageSevenApplyNum(totalEntity.getAverageSevenApplyNum() + list.get(i).getAverageSevenApplyNum());

                // 立即申请率
                double nowApplyPnum = list.get(i).getNowApplyPnum();
                list.get(i).setNowApplyRate(nowApplyPnum / loginSevenNum);

                // 保留两位小数点
                BigDecimal nar = new BigDecimal(list.get(i).getNowApplyRate());
                list.get(i).setNowApplyRate(nar.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                totalEntity.setNowApplyRate(totalEntity.getNowApplyRate() + list.get(i).getNowApplyRate());

            }
            // 费用
            list.get(i).setCost(list.get(i).getPrice() * list.get(i).getRegisterNum());
            if (list.get(i).getRegisterNum() > list.get(i).getInitNumber()) {
                Double num = (list.get(i).getRegisterNum() - list.get(i).getInitNumber()) * list.get(i).getDiscount();
                list.get(i).setRealCost(list.get(i).getPrice() * (list.get(i).getInitNumber() + num.intValue()));
                list.get(i).setSettleNumber(list.get(i).getInitNumber() + num.intValue());

            }
            else {
                list.get(i).setRealCost(list.get(i).getPrice() * list.get(i).getRegisterNum());
                list.get(i).setSettleNumber(list.get(i).getRegisterNum());
            }

            totalEntity.setSettleNumber(totalEntity.getSettleNumber() + list.get(i).getSettleNumber());
            totalEntity.setRealCost(totalEntity.getRealCost() + list.get(i).getRealCost());
        }
        totalEntity.setChannelName("总计");

        // 算平均值

        if (list.size() > 0) {
            double firstLoginNum = totalEntity.getFirstLoginNum();
            double registerNum = totalEntity.getRegisterNum();
            if (registerNum <= 0) {
                totalEntity.setLoginRate(0D);
            }
            else {
                totalEntity.setLoginRate(firstLoginNum / registerNum);
            }
            BigDecimal bigmal = new BigDecimal(totalEntity.getLoginRate());
            totalEntity.setLoginRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setNowApplyRate(totalEntity.getNowApplyRate() / list.size());
            bigmal = new BigDecimal(totalEntity.getNowApplyRate());
            totalEntity.setNowApplyRate(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageApplySuccessNum(totalEntity.getAverageApplySuccessNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageApplySuccessNum());
            totalEntity.setAverageApplySuccessNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageNowApplyNum(totalEntity.getAverageNowApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageNowApplyNum());
            totalEntity.setAverageNowApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageRegisterApplyNum(totalEntity.getAverageRegisterApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageRegisterApplyNum());
            totalEntity.setAverageRegisterApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            totalEntity.setAverageSevenApplyNum(totalEntity.getAverageSevenApplyNum() / list.size());
            bigmal = new BigDecimal(totalEntity.getAverageSevenApplyNum());
            totalEntity.setAverageSevenApplyNum(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            if (totalEntity.getSettleNumber() > 0) {
                totalEntity.setPrice(totalEntity.getRealCost() / totalEntity.getSettleNumber());
                bigmal = new BigDecimal(totalEntity.getPrice());
                totalEntity.setPrice(bigmal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        }
        list.add(0, totalEntity);
        return list;
    }

    @Override
    public List<TAgentLogEntity> realList(Page<TAgentLogEntity> page, Query search) {

        List<TAgentLogEntity> list = tAgentLogMapper.realList(page, search);
        String days = DateUtil.getStringDateShort();// 获取当前时间
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegisterNum() > list.get(i).getInitNumber()) {
                Double num = (list.get(i).getRegisterNum() - list.get(i).getInitNumber()) * list.get(i).getDiscount();

                list.get(i).setRegisterNum(list.get(i).getInitNumber() + num.intValue());
            }
            list.get(i).setDays(days);
        }

        return list;
    }

    @Override
    public int saveTAgentLog(TAgentLogEntity tAgentLog) {
        return tAgentLogMapper.save(tAgentLog);
    }

    @Override
    public TAgentLogEntity getTAgentLogById(Long id) {
        TAgentLogEntity tAgentLog = tAgentLogMapper.getObjectById(id);
        return tAgentLog;
    }

    @Override
    public int updateTAgentLog(TAgentLogEntity tAgentLog) {
        return tAgentLogMapper.update(tAgentLog);
    }

    @Override
    public int batchRemove(Long[] id) {
        int count = tAgentLogMapper.batchRemove(id);
        return count;
    }

    @Override
    public List<TAgentLogEntity> recordList(String days) {
        List<TAgentLogEntity> list = tAgentLogMapper.recordList(days);
        return list;
    }

    @Override
    public int save(TAgentLogEntity entity) {
        return tAgentLogMapper.save(entity);
    }
}
