package controller;

import server.ImgServer;
import to.AllImg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToAllServlet", value = "/all")
public class ToAllServlet extends HttpServlet {
    private ImgServer imgServer;
    public ToAllServlet(){
        this.imgServer = new ImgServer();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询数据库，把数据携带到页面进行显示
        //分页查询 你需要查询的页码（index） 每页的数据量(number)
        String index = req.getParameter("index");
        String number = req.getParameter("number");
        req.getSession().setAttribute("INDEX_PAGE",index);
        //查询到我想要的结果
        AllImg allImg = imgServer.allPaging(Integer.parseInt(index), Integer.parseInt(number));
        //返回 1. 总页数  2.当前页面 3.当页的数据
        req.setAttribute("ALL_INFO",allImg);
        //转发到博客管理页面
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
