package com.dabing.week2.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Date now = new Date();
        PrintWriter writer = response.getWriter();
        writer.println("Name:Zhang Boshi");
        writer.println( "ID:2022211001000523");
        writer.println(now);



    }
}
