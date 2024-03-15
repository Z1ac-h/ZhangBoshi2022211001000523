package com.dabing.week2.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "work02")
public class HelloWorldServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:Zhang Boshi");
        writer.println( "ID:2022211001000523");
        writer.println("Data and TimeSun Mar 14 17:23:41 CST 2024");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
