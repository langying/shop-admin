package net.chenlin.dp.modules.quartz.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.modules.cms.service.TChannelLogService;

/**
 * 测试任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月21日 上午1:09:44
 */
@Component("channelTask")
public class ChannelTask {

    @Autowired
    private TChannelLogService tChannelLogService;

    /**
     * 统计第三方的pv，nv
     */
    public void exectue() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // 获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
        // 获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
        String lastDay = format.format(cale.getTime());
        tChannelLogService.taskMonth(firstDay, lastDay);
        System.out.println("current timestapmp is : " + System.currentTimeMillis());
    }

}
