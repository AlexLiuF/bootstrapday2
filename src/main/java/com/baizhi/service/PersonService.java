package com.baizhi.service;

import com.baizhi.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package: com.baizhi.service
 * @ClassName: PersonService
 * @Author: alex
 * @CreateTime: 2020/10/18 15:31
 * @Description:
 */
public interface PersonService {
    List<Person> selectAll();
    //根据id删除
    void deleteById(List<Integer> list);
    //根据条件查
    List<Person> selectAllByPerson(String sort,String order,Integer offset,Integer limit,String search);
    //查询条数
    Integer selectCount();
    //插入
    void insertPerson(Person person);
    //根据id删除一个
    void removePerson(Integer id);
    //根据id查询
    Person selectById(Integer id);
    //修改
    void updatePerson(Person person);
}
