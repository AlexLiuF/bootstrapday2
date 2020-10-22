package com.baizhi.dao;

import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Package: com.baizhi.dao
 * @ClassName: PersonDao
 * @Author: alex
 * @CreateTime: 2020/10/18 15:23
 * @Description:
 */
public interface PersonDao {
    List<Person> selectAll();
    //根据id删除
    void deleteById(List<Integer> ids);
    //根据条件查
    List<Person> selectAllByPerson(@Param("sort") String sort,@Param("order") String order,@Param("offset")Integer offset,@Param("limit") Integer limit,@Param("search")String search);
    //查询条数
    Integer selectCount();
    //添加
    void insertPerson(Person person);
    //根据一个id删除
    void removePerson(Integer id);
    //根据id查询
    Person selectById(Integer id);
    //修改
    void updatePerson(Person person);
}
