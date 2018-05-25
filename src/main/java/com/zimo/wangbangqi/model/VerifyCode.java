package com.zimo.wangbangqi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class VerifyCode {
    @Id
    private String phone;
    private Long createTime = System.currentTimeMillis();
    private String code = String.format("%06d",new Random().nextInt(999999));

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
