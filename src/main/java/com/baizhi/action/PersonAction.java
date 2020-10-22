package com.baizhi.action;

import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import com.baizhi.service.impl.PersonServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Authenticator;
import javassist.ClassPath;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.baizhi.action
 * @ClassName: PersonAction
 * @Author: alex
 * @CreateTime: 2020/10/21 15:56
 * @Description:
 */
public class PersonAction {
    private Integer id;
    private String name;
    private Integer sex;
    private List<Integer> ids;
    private List<Person> list;
    private String sort;
    private String order;
    private Integer offset;
    private Integer limit;
    private String search;
    private List<Person> rows;
    private Integer total;
    private String status;
    private Integer age;
    private String mobile;
    private Date brithday;
    private Person person;
    private PersonService psi;
    //不分页查
    public String selectAll() throws IOException {
        list = psi.selectAll();
        return "success";
    }

    //复选框删除
    public String deleteById() throws IOException {
        try {
            psi.deleteById(ids);
            status="success";
        } catch (Exception e) {
            status="error";
            e.printStackTrace();
        }
        return "success";
    }


    //根据条件查询展示所有(分页)
    public String selectByPerson() throws Exception {


        //利用对象调用方法
        if(sort.equals("id")){
            sort="person_id";
        }
        rows = psi.selectAllByPerson(sort, order, offset, limit, search);
        System.out.println(rows);
        total = psi.selectCount();

        return "success";
    }

    //添加员工
    public String addPerson() throws IOException {
        //创建bean工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        person = (Person)context.getBean("person");
     //   Person person = new Person(null,name,age,sex,mobile,brithday);
        person.setName(name);
        person.setAge(age);
        person.setSex(sex);
        person.setMobile(mobile);
        person.setBrithday(brithday);
        try {
            psi.insertPerson(person);
           status="success";
        } catch (Exception e) {
            status="error";
            throw new RuntimeException(e);
        }
        return "success";
    }

    //删除
    public String removePerson() throws IOException {

        try {
            psi.removePerson(id);
           status="success";
        } catch (Exception e) {
            status="error";
            throw new RuntimeException(e);
        }
        return "success";
    }

    //查找
    public String showOneUser() throws Exception {
        person = psi.selectById(id);
        System.out.println(person);
        return "success";
    }

    //修改
    //添加员工
    public String updatePerson() throws IOException {

        Person person = new Person(id,name,age,sex,mobile,brithday);

        try {
            psi.updatePerson(person);
            status="success";
        } catch (Exception e) {
           status="error";
           throw new RuntimeException(e);
        }
        return "success";
    }

    public void setPsi(PersonService psi) {
        this.psi = psi;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Person> getRows() {
        return rows;
    }

    public void setRows(List<Person> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
