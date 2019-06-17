package controller;

import server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LongoutServlet" ,value = "/longout")
public class LongoutServlet extends HttpServlet {
    private UserServer userServer;
    public LongoutServlet(){
        this.userServer=new UserServer();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       userServer.longOut(request,response);
       response.sendRedirect(request.getContextPath()+"/longin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
