package com.liuxiaocs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录请求
 * 1. 继承HttpServlet，才能够处理HTTP请求
 * 2. 使用@WebServlet，说明它要处理的请求路径
 * @author liuxiaocs
 * @date 2021/3/18 15:13
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet ---- ");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取客户端发送的数据(请求参数)
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. 判断
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        if("123".equals(username) && "456".equals(password)) {
            // 登录成功
            // resp.getWriter().write("<h1 style=\"color: red\">登录成功!!!</h1>");
            // 让客户端重定向到home.html
            resp.sendRedirect("/hello/html/home.html");

            //等价于
            // resp.setStatus(302);
            // resp.setHeader("Location", "/hello/html/home.html");
        } else {
            // 登录失败
            resp.setStatus(400);
            resp.getWriter().write("<h1 style=\"color: red\">登录失败!!!</h1>");
        }
    }

    /**
     *
     * @param req  请求：用来获取客户端发送的数据
     * @param resp  响应：用来给客户端返回数据
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost ---- ");
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        try {
            System.out.println(1 / 0); } catch (Exception e) {
            resp.setStatus(400);
            resp.getWriter().write("服务端异常，请稍后再试");
        }

        // 1. 获取客户端发送的数据(请求参数)
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + "_" + password);

        // 2. 判断
        // resp.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        // resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        // resp.setHeader("Content-Type", "text/plain; charset=UTF-8");
        if("lucy".equals(username) && "123".equals(password)) {
            // 登录成功
            // resp.getWriter().write("Login Success!!!");
            // resp.getWriter().write("<h1 style=\"color: red\">登录成功!!!</h1>");
            resp.getWriter().write("登录成功!!!");
        } else {
            // 登录失败
            // resp.getWriter().write("Login Failure!!!");
            // resp.getWriter().write("<h1 style=\"color: red\">登录失败!!!</h1>");
            // 设置失败状态码
            resp.setStatus(400);
            resp.getWriter().write("登录失败!!!");
        }
    }
}
