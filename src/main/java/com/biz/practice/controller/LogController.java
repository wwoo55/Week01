package com.biz.practice.controller;

import com.biz.practice.pojo.ResultInfoDTO;
import com.biz.practice.util.JedisUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: Week01
 * @className: LogController
 * @description:
 * @author: xy
 * @time: 2021/4/23 10:45
 */
@RestController
@RequestMapping("/log")
public class LogController {

    /**
     * 查找指定用户的登录日志
     *
     * @param name
     * @return
     */
    @GetMapping("/login")
    public ResultInfoDTO loginLog(String name) {
        List<String> list = JedisUtils.readLoginLog(name);
        ResultInfoDTO infoDTO = new ResultInfoDTO();
        if (CollectionUtils.isEmpty(list)) {
            infoDTO.setFlag(false);
            infoDTO.setMsg("该用户还未登录过");
        } else {
            infoDTO.setFlag(true);
            infoDTO.setData(list);
        }

        return infoDTO;
    }
}
