package com.zimo.wangbangqi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Value("${uploadDir}")
    private String uploadDir;

    public String uploadImg(MultipartFile file) throws RuntimeException{
        if (file.isEmpty())
            return "文件不能为空";
        //获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为:"+fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = uploadDir;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        //检测是否存在目录
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功后的文件路径未：" + filePath + fileName);
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "文件上传失败";
    }
}
