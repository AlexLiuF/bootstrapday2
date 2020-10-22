package com.baizhi.service.impl;

import com.baizhi.action.PersonAction;
import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import com.baizhi.util.MyBatisUtil;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Package: com.baizhi.service.impl
 * @ClassName: PersonServiceImpl
 * @Author: alex
 * @CreateTime: 2020/10/18 15:32
 * @Description:
 */
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> selectAll() {
        SqlSession sqlSession = null;
        List<Person> list = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao dao = sqlSession.getMapper(PersonDao.class);
            list = dao.selectAll();
            sqlSession.commit();
            sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyBatisUtil.close(sqlSession);
        return list;
    }

    @Override
    public void deleteById(List<Integer> list) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao mapper = (PersonDao)sqlSession.getMapper(PersonDao.class);
            mapper.deleteById(list);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            MyBatisUtil.close(sqlSession);
        }
    }

    @Override
    public List<Person> selectAllByPerson(String sort, String order, Integer offset, Integer limit, String search) {
        List<Person> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao dao = sqlSession.getMapper(PersonDao.class);
            list = dao.selectAllByPerson(sort, order, offset, limit, search);
            sqlSession.commit();

        } catch (Exception e) {
            sqlSession.rollback();
           throw new RuntimeException(e);
        }finally{
            MyBatisUtil.close(sqlSession);
        }
        return list;
    }

    @Override
    public Integer selectCount() {
        SqlSession sqlSession = null;
        Integer total = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao dao = sqlSession.getMapper(PersonDao.class);
            total = dao.selectCount();
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.close();
            throw new RuntimeException(e);
        }finally {
            MyBatisUtil.close(sqlSession);
        }
        return total;
    }

    @Override
    public void insertPerson(Person person) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao mapper = sqlSession.getMapper(PersonDao.class);
            mapper.insertPerson(person);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            MyBatisUtil.close(sqlSession);
        }

    }

    //根据id删除
    @Override
    public void removePerson(Integer id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao mapper = sqlSession.getMapper(PersonDao.class);
            mapper.removePerson(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            MyBatisUtil.close(sqlSession);
        }

    }

    @Override
    public Person selectById(Integer id) {
        SqlSession sqlSession = null;
        Person person = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao mapper = sqlSession.getMapper(PersonDao.class);
            person = mapper.selectById(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtil.close(sqlSession);
        }
        return person;
    }

    @Override
    public void updatePerson(Person person) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            PersonDao mapper = sqlSession.getMapper(PersonDao.class);
            mapper.updatePerson(person);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            MyBatisUtil.close(sqlSession);
        }
    }


}
