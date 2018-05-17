package com.zimo.wangbangqi.model;

import com.zimo.wangbangqi.enums.GirlStatusEnum;
import com.zimo.wangbangqi.validated.EnumValue;
import com.zimo.wangbangqi.validated.WorkTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Girl implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cupSize;
    private Integer age;
    private Double money;
    private Integer workTime;
//    @EnumValue(enumClass = GirlStatusEnum.class,enumMethod = "isValidName",message = "值是无效的")
    private String status;
    private Long createTime;
    private Long updateTime;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Girl() {
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", workTime=" + workTime +
                ", status='" + status + '\'' +
                '}';
    }
}
