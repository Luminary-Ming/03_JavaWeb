package com.demo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        /**
         * 字节流 和 字符流
         * 字节流： 它处理单元为1个字节（byte），操作字节和字节数组，存储的是二进制文件。
         * 字符流： 它处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串，
         *         字符流是由Java虚拟机将字节转化为2个字节的Unicode字符为单位的字符而成的。
         * 字节流：音频文、图片、歌曲等。
         * 字符流：文本。
         * 万物皆文件，那就将文件在记事本里面打开，如果打开后能看的懂的就是字符流，如果看不懂那就是字节流。
         */
        // 字符流
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h3>resp响应的数据</h3>");
        printWriter.write("天津");
        printWriter.write("东软");
        printWriter.write("上课");

        // 字节流
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(97);
        outputStream.write(65);
        outputStream.write(12);
    }
}
