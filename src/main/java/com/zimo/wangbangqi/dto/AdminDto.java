package com.zimo.wangbangqi.dto;

import com.zimo.wangbangqi.model.Waiter;

import java.util.List;

public class AdminDto {
    private Integer id;
    private String accNum;  //唯一
    private Boolean root;
    private List<WaiterDto> waiterDtoList;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<WaiterDto> getWaiterDtoList() {
        return waiterDtoList;
    }

    public void setWaiterDtoList(List<WaiterDto> waiterDtoList) {
        this.waiterDtoList = waiterDtoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }
}
