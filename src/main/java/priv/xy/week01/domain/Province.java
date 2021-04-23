package priv.xy.week01.domain;

import java.io.Serializable;

/**
 * @projectName: Week01
 * @className: Province
 * @description:
 * @author: xy
 * @time: 2021/4/20 17:04
 */
public class Province implements Serializable {
    private Long id;
    private Long pid;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
