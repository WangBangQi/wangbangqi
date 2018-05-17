package com.zimo.wangbangqi.handler;

import com.zimo.wangbangqi.enums.ResultEnum;
import com.zimo.wangbangqi.exception.GirlException;
import com.zimo.wangbangqi.exception.JudgeException;
import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获所有的Controller中抛出的异常
 */

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.fail(girlException.getCode(),girlException.getMessage());
        } else if (e instanceof JudgeException){
            JudgeException judgeException = (JudgeException)e;
            return ResultUtil.fail(judgeException.getCode(),judgeException.getMessage());
        } else {
            logger.error("【系统错误】{}",e);
            return ResultUtil.fail(ResultEnum.UNKONW_ERROR);
        }
    }
}
