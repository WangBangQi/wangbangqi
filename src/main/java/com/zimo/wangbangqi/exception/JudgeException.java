package com.zimo.wangbangqi.exception;

import com.zimo.wangbangqi.enums.ResultEnum;

public class JudgeException extends  RuntimeException {
    private Integer code;


    public JudgeException(String msg){
        super(msg);
        this.code = ResultEnum.FAIL.getCode();
    }

    public JudgeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
