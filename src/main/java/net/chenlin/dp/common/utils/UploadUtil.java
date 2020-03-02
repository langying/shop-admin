package net.chenlin.dp.common.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-08-21 下午 22:02
 */
public class UploadUtil {

    public static boolean uploadFile(HttpServletRequest request, String filePath, String fileName) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            String pathDir = getUploadDir(request, filePath);
            File dirFile = new File(pathDir);
            if (!dirFile.isDirectory()) {
                dirFile.mkdirs();
            }
            MultipartFile multipartFile = multiRequest.getFile("file");
            if (multipartFile != null) {
                String name = multipartFile.getOriginalFilename();
                //String postFix = name.substring(name.lastIndexOf(".")).toLowerCase();
                String saveName = fileName + ".jpg";//postFix;
                String savePath = pathDir + File.separator + saveName;
                System.out.println("保存的目录地址为："+savePath);
                File file = new File(savePath);
                file.setWritable(true, false);
                try {
                    multipartFile.transferTo(file);
                    return true;
                } catch (Exception e) {
                    //Log.error(name + "保存失败", e);
                }
            }}
        return false;
    }

    public static String getUploadDir(HttpServletRequest request, String path) {
        String result="/data/www/images"+path;
        return result;
    }
}
