package com.ZhangBoshi.week6.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet",value = "/Search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String txt = request.getParameter("txt");
        String search = request.getParameter("search");


        if ("0".equals(txt)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            switch (search) {
                case "baidu":
                    response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
                    break;
                case "bing":
                    response.sendRedirect("https://www.bing.com/search?q=" + txt);
                    break;
                case "google":
                    response.sendRedirect("https://www.google.com/search?q=" + txt);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    break;
            }
        }

    }
}
