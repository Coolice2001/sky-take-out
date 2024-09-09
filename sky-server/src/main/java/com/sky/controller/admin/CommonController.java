package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.compatqual.PolyNullType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author：Coolice
 * @date：Created in 2024/9/8 12:15
 * @description：通用接口
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);
        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀 .png
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            //使用UUID重命名(防止重复)
            String objectName = UUID.randomUUID().toString() + substring;

            //文件的请求路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);   //参数2：阿里云空间的文件名
            return Result.success(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
