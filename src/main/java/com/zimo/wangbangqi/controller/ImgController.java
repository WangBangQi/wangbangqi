package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.service.FileService;
import com.zimo.wangbangqi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class ImgController {

    @Autowired
    private FileService fileService;

    @PostMapping("file/uploadImg")
    public Result upload(HttpServletRequest request,
                         @RequestParam("img")MultipartFile multipartFile,
                         HttpSession httpSession){
        return ResultUtil.success(fileService.uploadImg(multipartFile));
    }
}
