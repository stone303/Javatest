package crudtesting.dao.impl;

import crudtesting.bean.Tb_User;
import crudtesting.dao.Tb_UserDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Tb_UserDaoImpl implements Tb_UserDao {
    public SqlSession sqlSession;

    public Tb_UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Tb_User queryUserById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public List<Tb_User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public void insertUser(Tb_User user) {
        this.sqlSession.insert("UserDao.insertUser", user);

    }

    @Override
    public void updateUser(Tb_User user) {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    @Override
    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
