package controller;

import pojo.Img;
import pojo.User;
import server.ImgServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParticularsServlet",value = "/particulars")
public class ParticularsServlet extends HttpServlet {
private ImgServer imgServer;

    public ParticularsServlet() {
        this.imgServer = new  ImgServer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");List<Img> select = imgServer.selectById(Integer.parseInt(id));
        request.getSession().setAttribute("PAS_IFFO",select);
        response.sendRedirect(request.getContextPath()+"/particulars.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
