package crudtesting.dao;

import crudtesting.bean.Tb_User;

import java.util.List;

public interface Tb_UserDao {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public Tb_User queryUserById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Tb_User> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(Tb_User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(Tb_User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(String id);
}
