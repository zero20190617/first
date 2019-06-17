package controller;

import pojo.Img;
import pojo.User;
import server.ImgServer;
import to.AllImg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToMyServlet", value = "/my")
public class ToMyServlet extends HttpServlet {
    private ImgServer imgServer;

    public ToMyServlet() {
        this.imgServer = new ImgServer();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User longin_info = (User) session.getAttribute("LONGIN_INFO");
        String userName = longin_info.getUserName();
        Img img = new Img();
        img.setUsername(userName);
        String index = req.getParameter("index");
        String number = req.getParameter("number");
        req.getSession().setAttribute("INDEX_PAGE",index);
        //查询到我想要的结果
        AllImg allImg = imgServer.myPaging(Integer.parseInt(index), Integer.parseInt(number), img.getUsername() );
        //返回 1. 总页数  2.当前页面 3.当页的数据
        req.setAttribute("MY_INFO",allImg);
        //转发到博客管理页面
       req.getRequestDispatcher("/my.jsp").forward(req, resp);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
