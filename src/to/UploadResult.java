package to;

import java.util.ArrayList;
import java.util.List;

public class UploadResult {
    private Integer errno;
    private List<String> data;

    public UploadResult() {
        data = new ArrayList<>();
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
