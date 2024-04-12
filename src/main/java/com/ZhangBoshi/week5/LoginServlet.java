package com.ZhangBoshi.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.Date;


@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"},
        loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Login-->   ConnectionID"+conn);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        if (Username == null || Password == null || Username.isEmpty() || Password.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username and Password cannot be empty.");
            return;
        }

        String selectSQL = "select * from Usertable where Username = ? " +
                "AND Password = ?";

        try {
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, Username);
            pstmt.setString(2, Password);
            rs = pstmt.executeQuery();


            if (rs.next()) {

                    //request.setAttribute("id",rs.getInt("id"));
                    request.setAttribute("Username",rs.getString("Username"));
                    request.setAttribute("Password",rs.getString("Password"));
                    request.setAttribute("Email",rs.getString("Email"));
                    request.setAttribute("Gender",rs.getString("Gender"));
                    request.setAttribute("Birthdate",rs.getString("Birthdate"));
                try {
                    request.getRequestDispatcher("userinfo.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }

                /*response.setContentType("text/html");
                out.println("<html><head><title>login result</title></head><body>");
                out.println("<br><b>Login Success!!!</b>");
                out.println("<br><b>Welcome, "+Username+"</b>");
                out.println("</body></html>");*/
            } else {
                //response.setContentType("text/html");
                //out.println("<br><b>Username or Password Error!!!</b>");
                //out.println("</body></html>");
                request.setAttribute("message","Username or Password Error!!!");
                try {
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
}
