package server;

import dao.UserDao;
import pojo.User;
import utlis.JsonUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServer {
    private UserDao userdao;
    private SimpleDateFormat simpleDateFormat;

    public UserServer() {
        this.userdao = new UserDao();
        this.simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    public boolean register(User user) {
        try {
            userdao.inselt(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean islongin(User user) {
        User result = null;
        try {

            result = userdao.selectByName(user.getUserName());
            if (result == null) {
                return false;
            }
            return result.getPassword().equals(user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }

    public void updatetime(User user) {
        try {
            User usertime = userdao.selectByName(user.getUserName());
            usertime.setLasttime(usertime.getThistime());
            usertime.setThistime(simpleDateFormat.format(new Date()));
            userdao.updateTimeById(usertime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User selectUserInfo(String name) {
        try {
            return userdao.selectByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void longOut( HttpServletRequest request ,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("LONGIN_INFO");
            Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("AUTOLOGIN_INFO".equals(cookie.getName())) {
                   cookie.setMaxAge(0);
                   response.addCookie(cookie);

                }
            }
        }
    }
}
