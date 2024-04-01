package com.ZhangBoshi.week4.Homework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name="ConfigDemoServlet"//,
        //urlPatterns = {"/config"},
        //initParams = {
        //@WebInitParam(name="name1",value = "Zhang Boshi"),
        //@WebInitParam(name="studentId1",value = "2022211001000523"),
        //@WebInitParam(name="name2",value = "Zhang Boshi ()"),
        //@WebInitParam(name="studentId2",value = "2022211001000523 ()")
        //},loadOnStartup = 1
)


public class ConfigDemoServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name1");
        String studentId=config.getInitParameter("studentId1");
        String Name=config.getInitParameter("name2");
        String StudentId=config.getInitParameter("studentId2");






        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Exercise#1</title></head><body>");
        writer.println("<p style='font-size: 24px; font-weight: bold;'>");
        writer.println("Task1 web.xml");
        writer.println("</p>");
        writer.println("<p>name :" + name + "</p>");
        writer.println("<p>studentId :" + studentId + "</p>");

        //writer.println("<p style='font-size: 24px; font-weight: bold;'>");
        //writer.println("Task2 @WebServlet");
        //writer.println("</p>");
        //writer.println("<p>Name :" + Name + "</p>");
        //writer.println("<p>StudentId :" + StudentId + "</p>");
        writer.println("</body></html>");    }



    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
