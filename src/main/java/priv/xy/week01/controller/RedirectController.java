package priv.xy.week01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: Week01
 * @className: RedirectController
 * @description: 页面跳转controller
 * @author: xy
 * @time: 2021/4/20 19:29
 */
@Controller
public class RedirectController {

    @RequestMapping("/page/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/page/task01")
    public String task01(){
        return "task01";
    }

    @RequestMapping("/page/task02")
    public String task02(){
        return "task02";
    }

    @RequestMapping("/page/task03")
    public String task03(){
        return "task03";
    }

    @RequestMapping("/page/task05")
    public String task05(){
        return "task05";
    }

    @RequestMapping("/page/task05/update")
    public String task05Update(){
        return "task05-update";
    }

}
