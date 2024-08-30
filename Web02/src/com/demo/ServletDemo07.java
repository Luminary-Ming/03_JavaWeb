package com.demo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码
 */
@WebServlet("/captcha")
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * Image是一个抽象类，BufferedImage是其实现类，是一个带缓冲区图像类，
         * 主要作用是将一幅图片加载到内存中（ BufferedImage生成的图片在内存里有一个图像缓冲区，
         * 利用这个缓冲区我们可以很方便地操作这个图片），提供获得绘图对象、图像缩放、选择图像平滑度等功能，
         * 通常用来做图片大小变换、图片变灰、设置透明不透明等。
         * public abstract Graphics getGraphics()； //获得在图像上绘图的Graphics对象
         */
        int width = 160;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        // 填充一个矩形
        g.fillRect(0, 0, width, height);

        // 随机画验证码里的点点
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            // 画笔设置随机 RGB 颜色
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            // 画椭圆，半长轴和半短轴为零，画点点，随机坐标
            g.drawOval(random.nextInt(width), random.nextInt(height), 0, 0);
        }

        // 随机画线
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            // 随机坐标，随机的两个点，随机画线
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        // 验证码的四个字符
        String data = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        // 验证码的 x 坐标
        int x = 25;
        for (int i = 0; i < 4; i++) {
            // 随机颜色
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            // 随机取出一个字符
            char ch = data.charAt(random.nextInt(data.length()));
            // 设置字体 样式 字号
            g.setFont(new Font("宋体",Font.BOLD,26));
            // 把每个字符写在图片上
            g.drawString(ch+"",x,25);
            // 每个字符之间在x轴方向上的间隔距离
            x+=35;
        }
        // 给客户端响应不同的文件类型时，对应的类型可以在 Tomcat 的 conf/web.xml 中找到
        resp.setContentType("image/jpeg");
        ImageIO.write(image,"jpeg",resp.getOutputStream());
    }
}
