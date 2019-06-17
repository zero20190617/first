package server;

import dao.Imgdao;
import pojo.Img;
import to.AllImg;

import java.sql.SQLException;
import java.util.List;

public class ImgServer {
    private Imgdao Imgdao;

    public ImgServer() {
        this.Imgdao = new Imgdao();
    }

    public void add(Img img) {
        try {
            Imgdao.insert(img);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDownloads(String id,Img img) {
        try {
            Imgdao.UpdateDownloads(id,img);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Img> select() {
        try {
            return Imgdao.select();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Img> select(String username) {
        try {
            return Imgdao.select(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
    public List<Img> selectById(int id) {
        try {
            return Imgdao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
    public Img selectById(int id,Img img) {
        try {
            return Imgdao.selectById(id,img);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public void updateById(int id ,Img img) {
        try {
            Imgdao.update(id,img);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(String id) {
        try {
            Imgdao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //得到总页数
    public int getPageNumber(int number) {
        long count = 0;
        try {
            count = Imgdao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) (count / (number * 1.0) % 1 == 0 ? count / number : count / number + 1);
    }
    public int getMyPageNumber(int number,String name) {
        long count = 0;
        try {
            count = Imgdao.getMyCount(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) (count / (number * 1.0) % 1 == 0 ? count / number : count / number + 1);
    }

    public AllImg allPaging(int index, int number) {
        int paegNumber = 0;
        AllImg allImg = null;
        try {

            //根据查询到的数据计算总页码
            paegNumber = getPageNumber(number);
            //查询本页中的所有数据
            List<Img> imgs = Imgdao.selectPaging(index, number);

            allImg = new AllImg();
            // 1.总页数
            allImg.setPageNumber(paegNumber);
            // 2.当前页面 index
            allImg.setThisPage(index);
            // 3.当页的数据
            allImg.setImgs(imgs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allImg;
    }
    public AllImg myPaging(int index, int number,String username) {
        int paegNumber = 0;
        AllImg allImg = null;
        try {

            //根据查询到的数据计算总页码
            paegNumber = getMyPageNumber(number,username);
            //查询本页中的所有数据
            List<Img> imgs = Imgdao.selectPaging(index, number ,username);

            allImg = new AllImg();
            // 1.总页数
            allImg.setPageNumber(paegNumber);
            // 2.当前页面 index
            allImg.setThisPage(index);
            // 3.当页的数据
            allImg.setImgs(imgs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allImg;
    }
}

