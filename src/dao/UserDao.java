package dao;

import pojo.User;
import utlis.DBQueryUtil;
import utlis.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public UserDao() {
        this.connection = DBUtil.getConnection();
    }

    public void inselt(User user) throws SQLException {
        String sql = "INSERT user(USER_NAME,password,email,phone) VALUES (?,?,?,?)";
        DBQueryUtil.executeUpdate(sql, user.getUserName(), user.getPassword(), user.getEmail(), user.getPhone());
    }

    public User selectByName(String name) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM user WHERE USER_NAME = ?";
        PreparedStatement pst = null;
//		结果集
        ResultSet rset = null;
//		查询的结果需要一个类对象来保存
        User user = null;
        try {
//			得到句柄,预编译句柄
            pst = connection.prepareStatement(sql);
            pst.setString(1, name);
//			执行sql语句后得到的结果用结果集来保存
            rset = pst.executeQuery();
//			循环读取每一行
            while (rset.next()) {
//				如果有数据则 new一个类对象,然后对应添加属性值
                user = new User();
                user.setId(rset.getInt("ID"));
                user.setUserName(rset.getString("USER_NAME"));
                user.setPassword(rset.getString("password"));
                user.setEmail(rset.getString("email"));
                user.setPhone(rset.getString("phone"));
                user.setLasttime(rset.getString("lasttime"));
                user.setThistime(rset.getString("thistime"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
//		返回结果,类对象
        return user;
    }

    public void updateTimeById(User user) throws SQLException {
        String sql = "UPDATE user SET lasttime = ?,thistime=? WHERE id = ?";
        PreparedStatement pst = null;
        try {
//            预编译句柄
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getLasttime());
            pst.setString(2, user.getThistime());
            pst.setInt(3, user.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
