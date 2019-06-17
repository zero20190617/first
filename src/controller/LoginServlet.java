package controller;

import pojo.User;
import server.UserServer;
import utlis.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/longin")
public class LoginServlet extends HttpServlet {

    private UserServer userServer;

    public LoginServlet() {
        this.userServer = new UserServer();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String value = req.getParameter("remember");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        if (userServer.islongin(user)) {
            userServer.updatetime(user);
            if ("true".equals(value)) {
                String userJson = JsonUtils.objectToJson(user);
                Cookie cookie = new Cookie("AUTOLOGIN_INFO", URLEncoder.encode(userJson, "utf-8"));
                cookie.setMaxAge(3600 * 24 * 30);
                resp.addCookie(cookie);
            }
            User selectinfo = userServer.selectUserInfo(user.getUserName());
            session.setAttribute("LONGIN_INFO", selectinfo);
            resp.sendRedirect(req.getContextPath() + "/all?index=1&number=2");
        } else {
            resp.sendRedirect(req.getContextPath() + "/longin.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
