import bean.User;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    InputStream in;
    SqlSession session;
    UserDao userDao;
    @Before
    public void init()throws Exception {
        // 1、读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3、使用工厂生产SQLSession对象
        session = factory.openSession();
        // 4、使用SQLSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy()throws Exception {
        // 6、释放资源
        session.close();
        in.close();
    }

    /**
     * 显示所有用户
     */
    @Test
    public void fandAll() {
        // 5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 注册用户
     */
    @Test
    public void saveUser(){
        User user=new User();
        user.setUsername("mybatis");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("蟠桃花园");
        // 5、执行保存方法
        userDao.saveUser(user);
        // 6、提交事务回滚
        session.commit();
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        User user=new User();
        user.setId(26);
        user.setUsername("mybatis");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("蟠桃花园");
        // 5、执行修改方法
        userDao.updateUser(user);
        // 6、提交事务回滚
        session.commit();
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        // 5、执行删除方法
        userDao.deleteUser(26);
        // 6、提交事务回滚
        session.commit();
    }

    /**
     * 根据用户id显示用户信息
     */
    @Test
    public void getIdUser() {
        // 5、使用代理对象执行方法
        User user = userDao.getIdUser(16);
        System.out.println(user);
    }

}

