package net.chenlin.dp.modules.quartz.task;

import net.chenlin.dp.modules.cms.service.TThirdRecordService;
import net.chenlin.dp.modules.quartz.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * 测试任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月21日 上午1:09:44
 */
@Component("thirdTask")
public class ThirdTask {

	@Autowired
	private TThirdRecordService tThirdRecordService;

	/**
	 * 统计第三方的pv，nv
	 */
	public void exectue() {
		Calendar ca = Calendar.getInstance();
		String days= DateUtil.getBeforeDay(ca);//获取当前时间
		tThirdRecordService.taskRecord(days);
		System.out.println("current timestapmp is : " + System.currentTimeMillis());
	}
	
}
