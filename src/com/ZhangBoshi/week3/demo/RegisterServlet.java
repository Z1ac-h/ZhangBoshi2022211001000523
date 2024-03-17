package com.ZhangBoshi.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "work03register",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String Birthdate = request.getParameter("Birthdate");

        PrintWriter writer = response.getWriter();
        writer.println("<br> Username :"+Username);
        writer.println("<br> Password :"+Password);
        writer.println("<br> Email :"+Email);
        writer.println("<br> Gender :"+Gender);
        writer.println("<br> Birthdate :"+Birthdate);
        System.out.println("here is OK"+Username);
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("doGet() is OK");

    }
}
