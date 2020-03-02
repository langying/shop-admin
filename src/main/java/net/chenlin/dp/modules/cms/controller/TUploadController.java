package net.chenlin.dp.modules.cms.controller;

import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.jpush.InitJiGuangConfig;
import net.chenlin.dp.common.utils.DateUtils;
import net.chenlin.dp.common.utils.UploadUtil;
import net.chenlin.dp.modules.cms.entity.TSelectEntity;
import net.chenlin.dp.modules.cms.service.TChannelService;
import net.chenlin.dp.modules.cms.service.TColumnService;
import net.chenlin.dp.modules.cms.service.TMerchantsService;
import net.chenlin.dp.modules.cms.service.TProductService;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-08-22 下午 14:38
 */
@RestController
@RequestMapping("/app/comm")
public class TUploadController extends AbstractController {

    @Resource
    TProductService tProductService;

    @Resource
    TColumnService tColumnService;

    @Resource
    TChannelService tChannelService;

    @Resource
    TMerchantsService tMerchantsService;


    @RequestMapping("/upload")
    public R uploadTemplateCover(HttpServletRequest request) {
        String templateId = UUID.randomUUID().toString();
        String todayString = DateUtils.format(new Date());
        String templatePath = "/upload/" + todayString + "/";

        boolean success = UploadUtil.uploadFile(request, templatePath, templateId);
        System.out.println("地址为：" + templatePath + "success:" + success);
        if (success) {
            return R.ok("上传封面成功！").put("path", InitJiGuangConfig.IMAGE_PATH + templatePath + templateId + ".jpg");
        }
        return R.error("上传文件失败！");
    }

    /**
     * 获取产品下拉列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/select")
    public List<TSelectEntity> select(HttpServletRequest request) {
        return tProductService.select();
    }

    /**
     * 获取栏目下拉列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/selectColumn")
    public List<TSelectEntity> selectColumn(HttpServletRequest request) {
        return tColumnService.select();
    }

    /**
     * 获取渠道下拉列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/selectChannel")
    public List<TSelectEntity> selectChannel(HttpServletRequest request) {
        return tChannelService.select();
    }

    /**
     * 获取商户下拉列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/selectMerchants")
    public List<TSelectEntity> selectMerchants(HttpServletRequest request) {
        return tMerchantsService.select();
    }

}