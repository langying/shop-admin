package net.chenlin.dp.modules.cms.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.DateUtils;
import net.chenlin.dp.common.utils.excel.ExcelUtil;
import net.chenlin.dp.modules.cms.dao.TChannelAgentMapper;
import net.chenlin.dp.modules.cms.dao.TChannelMapper;
import net.chenlin.dp.modules.cms.entity.TAgentLogEntity;
import net.chenlin.dp.modules.cms.entity.TChannelAgentEntity;
import net.chenlin.dp.modules.cms.entity.TChannelEntity;
import net.chenlin.dp.modules.cms.service.TAgentLogService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.modules.sys.entity.SysUserEntity;

/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
@RestController
@RequestMapping("/app/agentLog")
public class TAgentLogController extends AbstractController {

    @Autowired
    private TAgentLogService tAgentLogService;

    @Autowired
    private TChannelMapper tChannelMapper;

    @Autowired
    private TChannelAgentMapper tChannelAgentMapper;

    /**
     * 历史列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<TAgentLogEntity> list(@RequestBody Map<String, Object> params) {
        return tAgentLogService.listTAgentLog(params);
    }

    /**
     * 实时列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/allList")
    public Page<TAgentLogEntity> allList(@RequestBody Map<String, Object> params) {
        return tAgentLogService.allList(params);
    }

    /**
     * 渠道查询信息
     *
     * @param params
     * @return
     */
    @RequestMapping("/agentList")
    public Page<TAgentLogEntity> agentList(@RequestBody Map<String, Object> params) {

        SysUserEntity user = getUser();
        System.out.print("user:" + user.getUsername());

        TChannelEntity tChannelEntity = tChannelMapper.findByAccount(user.getUsername());
        TChannelAgentEntity tChannelAgentEntity = null;
        if (tChannelEntity != null) {
            params.put("channelId", tChannelEntity.getId());
        }
        else {
            tChannelAgentEntity = tChannelAgentMapper.findByAccount(user.getUsername());
            if (tChannelAgentEntity != null) {
                params.put("agentId", tChannelAgentEntity.getId());
            }
        }

        return tAgentLogService.list(params);
    }

    /**
     * 渠道查询信息
     *
     * @param params
     * @return
     */
    @RequestMapping("/realList")
    public Page<TAgentLogEntity> realList(@RequestBody Map<String, Object> params) {

        SysUserEntity user = getUser();
        System.out.print("user:" + user.getUsername());

        TChannelEntity tChannelEntity = tChannelMapper.findByAccount(user.getUsername());
        if (tChannelEntity != null) {
            params.put("channelId", tChannelEntity.getId());
        }
        else {
            TChannelAgentEntity tChannelAgentEntity = tChannelAgentMapper.findByAccount(user.getUsername());
            if (tChannelAgentEntity != null) {
                params.put("agentId", tChannelAgentEntity.getId());

            }
        }

        return tAgentLogService.realList(params);
    }

    /**
     * 新增
     *
     * @param tAgentLog
     * @return
     */
    @SysLog("新增渠道的推广统计")
    @RequestMapping("/save")
    public R save(@RequestBody TAgentLogEntity tAgentLog) {
        return tAgentLogService.saveTAgentLog(tAgentLog);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R getById(@RequestBody Long id) {
        return tAgentLogService.getTAgentLogById(id);
    }

    /**
     * 修改
     *
     * @param tAgentLog
     * @return
     */
    @SysLog("修改渠道的推广统计")
    @RequestMapping("/update")
    public R update(@RequestBody TAgentLogEntity tAgentLog) {
        return tAgentLogService.updateTAgentLog(tAgentLog);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @SysLog("删除渠道的推广统计")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return tAgentLogService.batchRemove(id);
    }

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping("/export")
    public void export(TAgentLogEntity tAgentLog, HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNumber", tAgentLog.getPageNumber());
        params.put("pageSize", tAgentLog.getPageSize());
        params.put("startDate", tAgentLog.getStartDate());
        params.put("endDate", tAgentLog.getEndDate());
        if (tAgentLog.getAgentName() != null) {
            params.put("name", tAgentLog.getAgentName());
        }
        // 获取数据
        Page<TAgentLogEntity> pageData = tAgentLogService.listTAgentLog(params);
        List<TAgentLogEntity> list = pageData.getRows();

        // excel标题
        String[] title = { "渠道名称", "推广名称", "日期", "PV", "UV", "单价", "渠道结算数据", "结算费用", "app首次登录数", "用户注册数", "成功登录数", "登录率", "立即申请数量", "立即申请人数", "立即申请率",
                "平均立即申请数", "成功申请数", "平均我已申请数", "注册用户平均申请订单数", "七天内登录数", "APP首次登录用户平均立即申请订单数" };

        // excel文件名
        String fileName = "渠道统计" + DateUtils.getDate("yyyyMMddHHmmss") + ".xls";

        // sheet名
        String sheetName = "渠道列表";

        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            TAgentLogEntity obj = list.get(i);
            content[i][0] = obj.getChannelName();
            content[i][1] = obj.getAgentName();
            content[i][2] = obj.getDays();
            content[i][3] = obj.getPv().toString();
            content[i][4] = obj.getUv().toString();
            content[i][5] = obj.getPrice().toString();
            content[i][6] = obj.getSettleNumber() + "";
            content[i][7] = obj.getRealCost().toString();
            content[i][8] = obj.getFirstLoginNum().toString();
            content[i][9] = obj.getRegisterNum().toString();
            content[i][10] = obj.getLoginNum().toString();
            content[i][11] = obj.getLoginRate().toString();
            content[i][12] = obj.getNowApplyNum().toString();
            content[i][13] = obj.getNowApplyPnum().toString();
            content[i][14] = obj.getNowApplyRate().toString();
            content[i][15] = obj.getAverageNowApplyNum().toString();
            content[i][16] = obj.getApplySuccessNum().toString();
            content[i][17] = obj.getAverageApplySuccessNum().toString();
            content[i][18] = obj.getAverageRegisterApplyNum().toString();
            content[i][19] = obj.getLoginSevenNum().toString();
            content[i][20] = obj.getAverageSevenApplyNum().toString();

        }

        // 创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        // 响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            }
            catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
