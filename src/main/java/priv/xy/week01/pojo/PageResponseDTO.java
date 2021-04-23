package priv.xy.week01.pojo;

import java.util.List;

/**
 * @projectName: Week01
 * @className: PageResponseDTO
 * @description: 返回分页数据对象
 * @author: xy
 * @time: 2021/4/22 11:25
 */
public class PageResponseDTO<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
