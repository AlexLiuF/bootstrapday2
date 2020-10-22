package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.baizhi.entity
 * @ClassName: Person
 * @Author: alex
 * @CreateTime: 2020/10/18 15:20
 * @Description:
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private String mobile;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date brithday;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, Integer sex, String mobile, Date brithday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mobile = mobile;
        this.brithday = brithday;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", brithday=" + brithday +
                '}';
    }
}