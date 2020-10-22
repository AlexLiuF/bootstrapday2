package com.baizhi.test;

import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import com.baizhi.service.impl.PersonServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.baizhi.test
 * @ClassName: PersonServiceTest
 * @Author: alex
 * @CreateTime: 2020/10/18 15:40
 * @Description:
 */
public class PersonServiceTest {
    @Test
    public void personServiceSelectAllTest(){
        PersonServiceImpl psi = new PersonServiceImpl();
        List<Person> list = psi.selectAll();
        for (Person p: list) {
            System.out.println(p);
        }
    }
    @Test
    public void personDeleteById(){
        PersonServiceImpl psi = new PersonServiceImpl();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        psi.deleteById(list);
    }
    @Test
    public void selectById(){
        PersonServiceImpl psi = new PersonServiceImpl();
        List<Person> list = psi.selectAllByPerson("person_id", "asc", 0, 10, null);
        for (Person p:list) {
            System.out.println(p);
        }
    }
    @Test
    public void selectCount(){
        PersonServiceImpl psi = new PersonServiceImpl();
        Integer count = psi.selectCount();
        System.out.println(count);
    }
    @Test
    public void insertTest(){
        Date date = new Date();
        Person person = new Person(null,"丫丫",12,1,"2121212",date);
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.insertPerson(person);
    }
    @Test
    public void removeTest(){
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.removePerson(43);
    }
    @Test
    public void selectByIdTest(){
        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = personService.selectById(48);
        System.out.println(person);
    }
    @Test
    public void updateTest(){
        Date date = new Date();
        Person person = new Person(48,"丫丫",12,1,"2121212",date);
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.updatePerson(person);
    }
}
