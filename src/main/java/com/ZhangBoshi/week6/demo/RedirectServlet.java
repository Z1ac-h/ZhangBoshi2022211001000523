package com.ZhangBoshi.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.witnout"/"
        //System.out.println("before redirect");
        //response.sendRedirect("index.jsp");
        //System.out.println("after redirect");

        //2.with"/"
        //System.out.println("before redirect");
        //response.sendRedirect("/ZhangBoshi2022211001000523_war_exploded/index.jsp");
        //System.out.println("after redirect");

        //3.full url
        response.sendRedirect("https://www.baidu.com/");
    }
}
