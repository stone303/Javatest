package dao;



import bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 注册用户
     * @param user 需要保存的用户
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId 用户id
     */
    void deleteUser(int userId);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return
     */
    User getIdUser(int userId);

}
