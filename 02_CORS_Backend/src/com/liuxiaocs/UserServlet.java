package com.liuxiaocs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxiaocs
 * @date 2022/2/12 21:18
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=UTF-8");
        // 设置CORS(允许别人能够跨域访问)
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");

        StringBuilder sb = new StringBuilder();
        /*
           [
                {"name": "lx1", "age": 11},
                {"name": "lx2", "age": 12},
                {"name": "lx3", "age": 13},
                {"name": "lx4", "age": 14},
           ]
         */
        sb.append("[");
        sb.append("{\"name\": \"lx0\", \"age\": 10},");
        sb.append("{\"name\": \"lx1\", \"age\": 11},");
        sb.append("{\"name\": \"lx2\", \"age\": 12},");
        sb.append("{\"name\": \"lx3\", \"age\": 13},");
        sb.append("{\"name\": \"lx4\", \"age\": 14}");
        sb.append("]");
        response.getWriter().write(sb.toString());
    }
}
