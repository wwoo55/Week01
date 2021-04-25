package com.biz.practice.controller;

import com.biz.practice.entity.Consumer;
import com.biz.practice.pojo.ConsumerDTO;
import com.biz.practice.pojo.ConsumerVO;
import com.biz.practice.pojo.PageResponseDTO;
import com.biz.practice.util.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.biz.practice.service.IConsumerService;

import javax.servlet.http.HttpSession;

/**
 * @projectName: Week01
 * @className: ConsumerController
 * @description:
 * @author: xy
 * @time: 2021/4/20 16:42
 */
@RestController
public class ConsumerController {

    @Autowired
    private IConsumerService iConsumerService;


    /**
     * 插入新用户
     *
     * @param consumerVo
     * @return
     */
    @PostMapping("/consumer")
    public boolean insertConsumer(ConsumerVO consumerVo) {
        return this.iConsumerService.insertConsumer(consumerVo);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @DeleteMapping("/consumer")
    public boolean deleteConsumer(@RequestParam(name = "id", required = true) Long id) {
        return this.iConsumerService.deleteConsumer(id);
    }

    /**
     * 更新用户
     *
     * @param consumerVo
     * @return
     */
    @PutMapping("/consumer")
    public boolean updateConsumer(ConsumerVO consumerVo) {
        return this.iConsumerService.updateConsumer(consumerVo);
    }

    /**
     * 根据id返回对象
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer")
    public Consumer getConsumer(@RequestParam(name = "id", required = true) Long id) {
        return this.iConsumerService.getConsumerById(id);
    }

    /**
     * 用户登录
     *
     * @param consumerVo
     * @param httpSession
     * @return
     */
    @PostMapping("/consumer/login")
    public boolean loginConsumer(ConsumerVO consumerVo, HttpSession httpSession) {
        // 核验验证码
        String verify = consumerVo.getVerify();
        String verifyCode = (String) httpSession.getAttribute("verifyCode");
        // 判断是否为 null 或 ”“
        if (StringUtils.isEmpty(verify)) {
            return false;
        }
        // 验证码校验
        if (!verify.equalsIgnoreCase(verifyCode)) {
            return false;
        }
        // 验证码校验成功
        Consumer consumer = this.iConsumerService.loginConsumer(consumerVo);
        if (consumer == null) {
            return false;
        }
        // !使用ResponseBody 就无法保存session数据
        // thymeleaf 无法读取
        httpSession.setAttribute("consumer", consumer);

        // 登陆成功在redis中放入日志
        // 未开启服务端会异常
        try {
            JedisUtils.writeLoginLog(consumer.getName());
        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    /**
     * 检查是否登录
     *
     * @param httpSession
     * @return
     */
    @GetMapping("/consumer/checkLogin")
    public boolean checkLoginConsumer(HttpSession httpSession) {
        Consumer consumer = (Consumer) httpSession.getAttribute("consumer");
        if (consumer == null) {
            return false;
        }
        return true;
    }

    /**
     * 条件分页查询
     *
     * @param key
     * @param page
     * @param limit
     */
    @GetMapping("/consumer/listConsumer")
    public PageResponseDTO<ConsumerDTO> listConsumer(@RequestParam(name = "key", required = false) String key,
                                                     @RequestParam(name = "page", required = false) Integer page,
                                                     @RequestParam(name = "limit", required = false) Integer limit) {
        if (StringUtils.isEmpty(key)) {
            key = "";
        }
        if (page == null) {
            // 默认页数
            page = 1;
        }
        if (limit == null) {
            // 默认一页条数
            limit = 3;
        }
        return this.iConsumerService.listConsumer(key, page, limit);
    }
}
