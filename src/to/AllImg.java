package to;

import pojo.Img;

import java.util.ArrayList;
import java.util.List;

public class AllImg {
    //返回 1. 总页数  2.当前页面 3.当页的数据
    private Integer pageNumber;
    private Integer thisPage;
    private List<Img> imgs;

    public AllImg() {
        this.imgs = new ArrayList<>();
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getThisPage() {
        return thisPage;
    }

    public void setThisPage(Integer thisPage) {
        this.thisPage = thisPage;
    }

    public List<Img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Img> imgs) {
        this.imgs = imgs;
    }
}