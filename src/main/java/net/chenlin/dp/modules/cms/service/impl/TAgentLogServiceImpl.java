package net.chenlin.dp.modules.cms.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;
import net.chenlin.dp.modules.cms.manager.TAgentLogManager;
import net.chenlin.dp.modules.cms.service.TAgentLogService;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
@Service("tAgentLogService")
public class TAgentLogServiceImpl implements TAgentLogService {

    @Autowired
    private TAgentLogManager tAgentLogManager;

    @Override
    public Page<TAgentLogEntity> listTAgentLog(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TAgentLogEntity> page = new Page<>(query);
        tAgentLogManager.listTAgentLog(page, query);
        return page;
    }

    @Override
    public Page<TAgentLogEntity> list(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TAgentLogEntity> page = new Page<>(query);
        tAgentLogManager.list(page, query);
        return page;
    }

    @Override
    public Page<TAgentLogEntity> allList(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TAgentLogEntity> page = new Page<>(query);
        tAgentLogManager.allList(page, query);
        return page;
    }

    @Override
    public Page<TAgentLogEntity> realList(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TAgentLogEntity> page = new Page<>(query);
        tAgentLogManager.realList(page, query);
        return page;
    }

    @Override
    public R saveTAgentLog(TAgentLogEntity role) {
        int count = tAgentLogManager.saveTAgentLog(role);
        return CommonUtils.msg(count);
    }

    @Override
    public R getTAgentLogById(Long id) {
        TAgentLogEntity tAgentLog = tAgentLogManager.getTAgentLogById(id);
        return CommonUtils.msg(tAgentLog);
    }

    @Override
    public R updateTAgentLog(TAgentLogEntity tAgentLog) {
        int count = tAgentLogManager.updateTAgentLog(tAgentLog);
        return CommonUtils.msg(count);
    }

    @Override
    public R batchRemove(Long[] id) {
        int count = tAgentLogManager.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

    @Override
    public void taskRecord(String days) {
        // 获取每天的数据统计
        List<TAgentLogEntity> list = tAgentLogManager.recordList(days);
        for (TAgentLogEntity entity : list) {
            entity.setDays(days);
            if (entity.getRegisterNum() > 0) {
                // 登录率
                double firstLoginNum = entity.getFirstLoginNum();
                double registerNum = entity.getRegisterNum();
                entity.setLoginRate(firstLoginNum / registerNum);
                // 保留两位小数点
                BigDecimal loginReate = new BigDecimal(entity.getLoginRate());
                entity.setLoginRate(loginReate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                // 注册用户平均申请订单数
                double nowApplyNum = entity.getNowApplyNum();
                entity.setAverageRegisterApplyNum(nowApplyNum / registerNum);
                // 保留两位小数点
                BigDecimal aran = new BigDecimal(entity.getAverageRegisterApplyNum());
                entity.setAverageRegisterApplyNum(aran.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            if (entity.getNowApplyPnum() > 0) {

                // 平均立即申请
                double nowApplyPnum = entity.getNowApplyPnum();
                double nowApplyNum = entity.getNowApplyNum();
                entity.setAverageNowApplyNum(nowApplyNum / nowApplyPnum);

                // 保留两位小数点
                BigDecimal anan = new BigDecimal(entity.getAverageNowApplyNum());
                entity.setAverageNowApplyNum(anan.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                // 平均我已申请
                double applySuccessNum = entity.getApplySuccessNum();
                entity.setAverageApplySuccessNum(applySuccessNum / nowApplyPnum);
                // 保留两位小数点
                BigDecimal aasn = new BigDecimal(entity.getAverageApplySuccessNum());
                entity.setAverageApplySuccessNum(aasn.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

            }
            if (entity.getLoginSevenNum() > 0) {
                // APP首次登陆用户平均立即申请订单数
                double loginNum = entity.getLoginNum();
                double registerNum = entity.getRegisterNum();
                double nowApplyNum = entity.getNowApplyNum();
                entity.setAverageSevenApplyNum(nowApplyNum / registerNum);

                // 保留两位小数点
                BigDecimal asan = new BigDecimal(entity.getAverageSevenApplyNum());
                entity.setAverageSevenApplyNum(asan.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                // 立即申请率
                double nowApplyPnum = entity.getNowApplyPnum();
                entity.setNowApplyRate(nowApplyPnum / loginNum);

                // 保留两位小数点
                BigDecimal nar = new BigDecimal(entity.getNowApplyRate());
                entity.setNowApplyRate(nar.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            // 费用
            entity.setCost(entity.getPrice() * entity.getRegisterNum());

            if (entity.getRegisterNum() > entity.getInitNumber()) {
                Double num = (entity.getRegisterNum() - entity.getInitNumber()) * entity.getDiscount();
                entity.setSettleNumber(entity.getInitNumber() + num.intValue());
                entity.setRealCost(entity.getPrice() * (entity.getInitNumber() + num.intValue()));
            }
            else {
                entity.setRealCost(entity.getPrice() * entity.getRegisterNum());
                entity.setSettleNumber(entity.getRegisterNum());
            }
            tAgentLogManager.save(entity);
        }
    }

}
