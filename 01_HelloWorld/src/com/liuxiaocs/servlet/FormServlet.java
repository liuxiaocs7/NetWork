package com.liuxiaocs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxiaocs
 * @date 2022/2/12 14:59
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 对客户端提交的数据进行编码
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String photo = req.getParameter("photo");
        System.out.println(name + "_" + age);
        System.out.println(photo);

        // 使用第三方库解析实现
        // commons-fileupload
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Method Not Allowed
        resp.setStatus(405);
    }
}
