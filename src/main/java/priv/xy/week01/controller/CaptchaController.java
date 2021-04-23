package priv.xy.week01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.xy.week01.util.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @projectName: Week01
 * @className: CaptchaController
 * @description:
 * @author: xy
 * @time: 2021/4/21 17:03
 */

@RestController
public class CaptchaController {

    /**
     * 获取验证码图片
     * @param response
     * @param request
     */
    @RequestMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;

            // 生成对应宽高的初始图片
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            // 单独的一个类方法，出于代码复用考虑，进行了封装。功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            String randomText = VerifyCode.drawRandomText(width, height, verifyImg);

            request.getSession().setAttribute("verifyCode", randomText);
            // 必须设置响应内容类型为图片，否则前台不识别
            response.setContentType("image/png");

            //获取文件输出流
            OutputStream os = response.getOutputStream();
            //输出图片流
            ImageIO.write(verifyImg, "png", os);
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
