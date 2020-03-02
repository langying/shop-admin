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
import net.chenlin.dp.modules.cms.entity.TProductLogEntity;
import net.chenlin.dp.modules.cms.service.TProductLogService;
import net.chenlin.dp.modules.sys.controller.AbstractController;

/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
@RestController
@RequestMapping("/app/productLog")
public class TProductLogController extends AbstractController {

    @Autowired
    private TProductLogService tProductLogService;

    /**
     * 产品数据（历史）列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<TProductLogEntity> list(@RequestBody Map<String, Object> params) {
        return tProductLogService.listTProductLog(params);
    }

    /**
     * 列表
     * @param params
     * @return
     */
    @RequestMapping("/listMerchants")
    public Page<TProductLogEntity> listMerchants(@RequestBody Map<String, Object> params) {
        return tProductLogService.listMerchants(params);
    }


    /**
     * 产品数据（实时）列表
     * @param params
     * @return
     */
    @RequestMapping("/realList")
    public Page<TProductLogEntity> realList(@RequestBody Map<String, Object> params) {
        return tProductLogService.realList(params);

    }


    /**
     * 新增
     * @param tProductLog
     * @return
     */
    @SysLog("新增产品统计")
    @RequestMapping("/save")
    public R save(@RequestBody TProductLogEntity tProductLog) {
        return tProductLogService.saveTProductLog(tProductLog);
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R getById(@RequestBody Long id) {
        return tProductLogService.getTProductLogById(id);
    }

    /**
     * 修改
     * @param tProductLog
     * @return
     */
    @SysLog("修改产品统计")
    @RequestMapping("/update")
    public R update(@RequestBody TProductLogEntity tProductLog) {
        return tProductLogService.updateTProductLog(tProductLog);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @SysLog("删除产品统计")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return tProductLogService.batchRemove(id);
    }


    /**
     * 导出报表
     * @return
     */
    @RequestMapping("/export")
    public void export(TProductLogEntity entity, HttpServletResponse response) throws Exception {
        Map<String, Object> params=new HashMap<>();
        params.put("pageNumber",entity.getPageNumber());
        params.put("pageSize",entity.getPageSize());
        params.put("startDate",entity.getStartDate());
        params.put("endDate",entity.getEndDate());
        if(entity.getName()!=null){
            params.put("name",entity.getName());
        }
        //获取数据
        Page<TProductLogEntity>  pageData = tProductLogService.listTProductLog(params);
        List<TProductLogEntity> list=pageData.getRows();

        //excel标题
        String[] title = {"产品名称","日期","产品单价","PV","UV","注册量","uv收益","日收入"};

        //excel文件名
        String fileName = "产品统计"+ DateUtils.getDate("yyyyMMddHHmmss")+".xls";

        //sheet名
        String sheetName = "产品列表";

        String [][] content=new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            TProductLogEntity obj = list.get(i);
            content[i][0] = obj.getProductName();
            content[i][1] = obj.getDays();
            content[i][2] = obj.getPrice().toString();
            content[i][3] = obj.getPv().toString();
            content[i][4] = obj.getUv().toString();
            content[i][5] = obj.getRegistrations().toString();
            content[i][6] = obj.getEarnings().toString();
            content[i][7] = obj.getIncome().toString();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
