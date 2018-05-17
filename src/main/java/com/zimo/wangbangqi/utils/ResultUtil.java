package com.zimo.wangbangqi.utils;

import com.zimo.wangbangqi.enums.Code;
import com.zimo.wangbangqi.enums.ResultEnum;
import com.zimo.wangbangqi.model.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }
    public static Result fail(Integer code,String failMessage){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(failMessage);
        return result;
    }
    public static Result fail(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMsg());
        return result;
    }

    public static Result fail(String errorMsg){
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMessage(errorMsg);
        return result;
    }
}
