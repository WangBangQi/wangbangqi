package com.zimo.wangbangqi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Waiter implements Serializable{

    /**
     * @Fields serialVersionUID : TODO
     */

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String headPic;
    private Boolean sex;    //true为男，false为女
    private String introduction;   //自我介绍
    private String address;
    private Double price;
    private String areaNo;      //与所属的管理员保持一致。
    private String cityNo;
    private Integer fakeServiceCount;   //初始订单数。

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public Integer getFakeServiceCount() {
        return fakeServiceCount;
    }

    public void setFakeServiceCount(Integer fakeServiceCount) {
        this.fakeServiceCount = fakeServiceCount;
    }
}
