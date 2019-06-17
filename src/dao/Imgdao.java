package dao;

import pojo.Img;
import utlis.DBQueryUtil;
import utlis.DBUtil;

import javax.lang.model.SourceVersion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Imgdao {
    private Connection connection;
    public Imgdao(){
        this.connection = DBUtil.getConnection();
    }

    public void insert(Img img) throws SQLException {
        String sql = "INSERT img(path,filename,username,resourcename,antistop,downintegral,uploadtime,size,downloads,description) VALUES (?,?,?,?,?,?,?,?,?,?)";
        DBQueryUtil.executeUpdate(sql, img.getPath(),img.getFilename(), img.getUsername(), img.getResourcename(), img.getAntistop(), img.getDownintegral(), img.getUploadtime(),img.getSize(),img.getDownloads(),img.getDescription());
    }
    public void UpdateDownloads(String id ,Img img) throws SQLException {
        String sql = "UPDATE img SET downloads=? WHERE id = ?";
        DBQueryUtil.executeUpdate(sql, img.getDownloads(),id);
    }
    public Img selectById( int id,Img img) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img WHERE id=?";
        List<Img> imgs = DBQueryUtil.executeQuery(Img.class, sql,id);
        return imgs!=null?imgs.get(0):null;
    }


    public List<Img> select() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img ";
        List<Img> imgs = DBQueryUtil.executeQuery(Img.class, sql);
        return imgs != null ? imgs : null;
    }

    public List<Img> select(String username) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img WHERE username=?";
        List<Img> mys = DBQueryUtil.executeQuery(Img.class, sql, username);
        return mys != null ? mys : null;
    }
    public List<Img> selectById( int id) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img WHERE id=?";
        List<Img> mys = DBQueryUtil.executeQuery(Img.class, sql, id);
        return mys != null ? mys : null;
    }

    public void update(int id ,Img img) throws SQLException {
        String sql = "UPDATE img SET resourcename=?,antistop=? ,downintegral=? WHERE id = ?";
        DBQueryUtil.executeUpdate(sql,img.getResourcename(),img.getAntistop(),img.getDownintegral(),id);
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE  FROM img WHERE id=?";
        DBQueryUtil.executeUpdate(sql, id);
    }

    public long getCount() throws SQLException {
        long result = 0;
        //1.写sql语句
        String sql = "SELECT COUNT(id) count FROM img";
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            //2.得到操作数据库的句柄
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();

            while (set.next()) {
                result = set.getLong("count");
            }
        } finally {
            if (set != null) {
                set.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return result;
    }
    public long getMyCount(String name) throws SQLException {
        long result = 0;
        //1.写sql语句
        String sql = "SELECT COUNT(id) count FROM img WHERE username = ?";
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            //2.得到操作数据库的句柄
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            set = ps.executeQuery();

            while (set.next()) {
                result = set.getLong("count");
            }
        } finally {
            if (set != null) {
                set.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return result;
    }
    public List<Img> selectPaging(int index, int number) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img LIMIT ?,?";
        List<Img> imgs = DBQueryUtil.executeQuery(Img.class, sql, (index - 1) * number, number);
        return imgs;
    }
    public List<Img> selectPaging(int index, int number,String username) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM img WHERE username=? LIMIT ?,?";
        List<Img> imgs = DBQueryUtil.executeQuery(Img.class, sql, username,(index - 1) * number, number);
        return imgs;
    }
}

//   public Img select(String userName){
//       String sql="SELECT * FROM img WHERE USER_NAME = ?";
//       PreparedStatement pst = null;
////		结果集
//       ResultSet rset = null;
////		查询的结果需要一个类对象来保存
//       Img img = null;
//       try {
////			得到句柄,预编译句柄
//           pst = connection.prepareStatement(sql);
//           pst.setString(1, userName);
////			执行sql语句后得到的结果用结果集来保存
//           rset = pst.executeQuery();
////			循环读取每一行
//           while (rset.next()) {
////				如果有数据则 new一个类对象,然后对应添加属性值
//               img = new Img();
//               img.setId(rset.getInt("id"));
//               img.setPath(rset.getString("path"));
//               img.setResourceName(rset.getString("resourceName"));
//               img.setAntistop(rset.getString("antistop"));
//               img.setDownIntegral(rset.getString("downIntegral"));
//               img.setSize(rset.getString("size"));
//               img.setUploadTime(rset.getString("uploadTime"));
//               img.setUserName(rset.getString("USER_NAME"));
//
//
//           }
//       } catch (SQLException e) {
//           // TODO Auto-generated catch block
//           e.printStackTrace();
//       } finally {
//           try {
//               rset.close();
//               pst.close();
//           } catch (SQLException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//           }
//       }
////		返回结果,类对象
//       return img;
//   }






