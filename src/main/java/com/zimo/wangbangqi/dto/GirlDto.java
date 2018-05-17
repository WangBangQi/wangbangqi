package com.zimo.wangbangqi.dto;

import com.zimo.wangbangqi.model.Class;
import com.zimo.wangbangqi.validated.WorkTime;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class GirlDto {

    private Integer girlId;
    private String name;
    @Min(value = 18,message = "未满18岁无法添加")
    private Integer age;
    @Nullable
    @WorkTime(max = 7,message = "工作时间不能超过7小时")
    private Integer workTime;
    private String beauty;
    private List<Class> classes;  //课程编号集合。

    public Integer getGirlId() {
        return girlId;
    }

    public void setGirlId(Integer girlId) {
        this.girlId = girlId;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getBeauty() {
        return beauty;
    }

    public void setBeauty(String beauty) {
        this.beauty = beauty;
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

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
