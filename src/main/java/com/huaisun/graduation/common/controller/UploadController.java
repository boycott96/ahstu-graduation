package com.huaisun.graduation.common.controller;

import com.huaisun.graduation.constants.ResultCode;
import com.huaisun.graduation.util.Result;
import com.huaisun.graduation.util.Tools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author sunruiguang
 * @date 2019/4/17
 * Updated by sunruiguang on 2019/4/17.
 */
@RestController
@RequestMapping("/sun/file")
public class UploadController {

    @RequestMapping("/uploadImg")
    public Result uploadImg(@RequestParam(value = "img") MultipartFile img) {
        if (Tools.isEmpty(img)) {
            return Result.failure(ResultCode.PARAM_NOT_COMPLETE);
        }

        String fileName = "img" + System.currentTimeMillis() + ".jpg";
        String filePath = "/home/huaisun/apache-tomcat-9.0.19/webapps/ROOT/static/img/milk/";
        File dest = new File(filePath + fileName);
        try {
            img.transferTo(dest);
            return Result.success(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.failure(ResultCode.FILE_UPLOAD_ERROR);
    }
}
