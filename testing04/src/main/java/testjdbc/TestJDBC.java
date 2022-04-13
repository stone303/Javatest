package testjdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) throws SQLException {
        //先实例化 数据连接、sql语句、结果
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://192.168.247.6:3306/testing";
            String user = "root";
            String password = "123456";
            connection = (Connection) DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "select * from tb_user where id=?";
            prepareStatement = (PreparedStatement) connection.prepareStatement(sql);

            // 设置参数
            prepareStatement.setLong(1, 990L);
            // 执行查询
            rs = prepareStatement.executeQuery();
            // 处理结果集

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
