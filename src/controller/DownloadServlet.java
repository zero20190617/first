package controller;

import dao.Imgdao;
import pojo.Img;
import pojo.User;
import server.ImgServer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    private ImgServer imgServer;

    public DownloadServlet() {
        this.imgServer = new ImgServer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String downloads = request.getParameter("downloads");
        Integer a = Integer.parseInt(downloads);
        System.out.println("downloads = " + downloads);
        Img img = new Img();
        img.setDownloads(a + 1);
        String downloadPath = "E:/1111/img/";
        String fileName = request.getParameter("fileName");
        File file = new File(downloadPath + fileName);
        if (!file.exists()) {
//            跳转下载失败页面，提示，该文件不存在
            return;
        }
        //设置下载的文件名
        response.setHeader("content-disposition", "attachment;filename="
                + URLEncoder.encode(fileName, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        FileInputStream fis = new FileInputStream(file);

        byte[] buf = new byte[1024];
        int len = 0;

        while ((len = fis.read(buf)) > 0) {
            outputStream.write(buf, 0, len);
        }

        fis.close();
//        下载成功
        imgServer.updateDownloads(id, img);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}