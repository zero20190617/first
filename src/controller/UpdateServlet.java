package controller;

import pojo.Img;
import server.ImgServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    private ImgServer imgServer;

    public UpdateServlet() {
       this.imgServer=new ImgServer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String resourcename = request.getParameter("resourcename");
        String antistop = request.getParameter("antistop");
        String downintegral = request.getParameter("downintegral");
        String description = request.getParameter("description");
        String id = (String) session.getAttribute("update_id");
        session.removeAttribute("update_id");
        Img img =new Img();
        img=imgServer.selectById(Integer.parseInt(id), img);
        if(resourcename!=null&&!"".equals(resourcename)){
            img.setResourcename(resourcename);
        }
        if(antistop!=null&&!"".equals(antistop)){
            img.setAntistop(antistop);
        }
        if(downintegral!=null&&!"".equals(downintegral)){
            img.setDownintegral(downintegral);
        }
        if(description!=null&&!"".equals(description)){
            img.setDescription(description);
        }
        imgServer.updateById(Integer.parseInt(id),img);
        response.sendRedirect(request.getContextPath()+"/my?index=1&number=2");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
