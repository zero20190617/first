package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Img;
import pojo.User;
import server.ImgServer;
import to.UploadResult;
import utlis.Conversion;
import utlis.JsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "uploadServlet", value = "/upload")
public class UploadServlet extends HttpServlet {
    private ImgServer imgServer;
    private SimpleDateFormat simpleDateFormat;


    public UploadServlet() {
        this.imgServer = new ImgServer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Img img = new Img();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time= sdf.format( new Date());
        img.setUploadtime(time);
        HttpSession session = request.getSession();
        User longin_info = (User) session.getAttribute("LONGIN_INFO");
        String userName = img.getUsername();
        userName = longin_info.getUserName();
        img.setUsername(userName);
        UploadResult result = new UploadResult();
        String uploadPath = "E:/1111/img/";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓存区的大小
        factory.setSizeThreshold(10240);
        //设置临时文件的位置
        factory.setRepository(new File("E:/22222/temp"));
        //得到文件上传的工具类

        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");
        sfu.setFileSizeMax(1024 * 1024 * 150);
        sfu.setSizeMax(1024 * 1024 * 2 * 100);
        FileOutputStream fos = null;
        try {
            //解析request，得到FileItem对象,把表单上传的每一项封装成FIleItem对象
            List<FileItem> fileItems = sfu.parseRequest(request);
            for (FileItem fileItem : fileItems){
                if (fileItem.isFormField()) {

                    //得到input标签的name属性值
                    String fieldName = fileItem.getFieldName();

                    //得到上传的表单内容
                    String value = fileItem.getString("UTF-8");
                    System.out.println(fieldName  +   value);
                    switch (fieldName) {
                        case "resourceName":
                            img.setResourcename(value);
                            //语句
                            break; //可选
                        case "antistop":
                            //语句
                            img.setAntistop(value);
                            break; //可选
                        //你可以有任意数量的case语句
                        case "downIntegral": //可选
                            img.setDownintegral(value);
                            //语句
                            break;
                        case "description":
                            //语句
                            img.setDescription(value);
                            break; //可选
                        //你可以有任意数量的case语句
                    }

                } else  {
                    //得到上传文件的文件名
                    String fileName = fileItem.getName();

                    fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
                    //封装上传后的文件名（防止上传文件同名）
                    String uploadName = uploadPath + fileName;
                    img.setFilename(fileName);
                    //得到输出流
                    fos = new FileOutputStream(uploadName);
                    byte[] buf = new byte[1024];
                    //得到文件上传的输入流
                    InputStream inputStream = fileItem.getInputStream();
                    long available = inputStream.available();
                    String size = Conversion.getPrintSize(available);
                    img.setSize(size);
                    int len = 0;
                    while ((len = inputStream.read(buf)) > 0) {
                        fos.write(buf, 0, len);
                    }
                    //删除临时文件
                    fileItem.delete();

                    img.setPath("http://192.168.7.115:8080/img/" + fileName);
//                    //把上传的信息保存到数据

                    //返回图片地址给wangEdito
                    result.setErrno(0);
                    result.getData().add("http://192,168,7,115:8080/img/" + fileName);

                }
            }
          img.setDownloads(0);
            imgServer.add(img);
            session.setAttribute("IMG_INFO",img);
            request.getRequestDispatcher("/all?index=1&number=2").forward(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
            result.setErrno(1);
        } finally {
            if (fos != null) {
                fos.close();
            }
            PrintWriter writer = response.getWriter();
            writer.print(JsonUtils.objectToJson(result));
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
