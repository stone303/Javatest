package crudtesting.dao;

import crudtesting.bean.Tb_User;
import crudtesting.dao.impl.Tb_UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class Tb_UserDaoTest {
    public Tb_UserDao tb_userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        // this.tb_userDao = new Tb_UserDaoImpl(sqlSession);
        this.tb_userDao = sqlSession.getMapper(Tb_UserDao.class);
    }

    @Test
    public void queryUserById() {
        System.out.println(this.tb_userDao.queryUserById("1"));
    }

    @Test
    public void queryUserAll() {
        List<Tb_User> userList = this.tb_userDao.queryUserAll();
        for (Tb_User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {

        Tb_User tb_user = new Tb_User();
        tb_user.setId("970");
        tb_user.setAge(16);
        tb_user.setBirthday(new Date("1990/09/02"));
        tb_user.setName("大鹏");
        tb_user.setPassword("123456");
        tb_user.setSex(1);
        tb_user.setUserName("evan");
        this.tb_userDao.insertUser(tb_user);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() {
        Tb_User tb_user = new Tb_User();
        tb_user.setBirthday(new Date());
        tb_user.setName("静鹏");
        tb_user.setPassword("654321");
        tb_user.setSex(1);
        tb_user.setUserName("evanjin");
        tb_user.setId("1");
        this.tb_userDao.updateUser(tb_user);
        this.sqlSession.commit();

    }

    @Test
    public void deleteUser() {
        this.tb_userDao.deleteUser("970");
        this.sqlSession.commit();
    }
}