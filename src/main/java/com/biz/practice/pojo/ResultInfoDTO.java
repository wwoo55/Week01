package com.biz.practice.pojo;

import java.io.Serializable;

/**
 * @projectName: Week01
 * @className: ResultInfoDTO
 * @description: 用于封装返回前端的结果
 * @author: xy
 * @time: 2021/4/23 11:09
 */
public class ResultInfoDTO implements Serializable {
    /**
     * flag //后端返回结果正常为true，发生异常返回false
     * data //后端返回结果数据对象
     * Msg //发生消息
     */
    private Boolean flag;
    private Object data;
    private String msg;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
