package com.ZhangBoshi.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(//name = "RegisterServlet",
        urlPatterns = {"/register"},
        loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection conn = null;

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
        System.out.println("Register-->   ConnectionID"+conn);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String Birthdate = request.getParameter("Birthdate");

        String sqlinsert = "insert into Usertable(Username,Password,Email,Gender,Birthdate)" +
                " values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlinsert);
            ps.setString(1, Username);
            ps.setString(2, Password);
            ps.setString(3, Email);
            ps.setString(4, Gender);
            ps.setString(5, Birthdate);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Successfully added" + row + "data ！");
            }
        } catch (SQLException throwables) {
            System.out.println("Failed to add");
            throwables.printStackTrace();
        }





        List<Map<String, Object>> results = new ArrayList<>();
        int rowIndex = 1;
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usertable");
             ResultSet rs = ps.executeQuery())
        {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowMap.put(metaData.getColumnName(i), rs.getObject(i));
                }
                rowMap.put("ID", rowIndex++);
                results.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //PrintWriter writer = response.getWriter();
        //writer.println("<br> Username :"+Username);
        //writer.println("<br> Password :"+Password);
        //writer.println("<br> Email :"+Email);
        //writer.println("<br> Gender :"+Gender);
        //writer.println("<br> Birthdate :"+Birthdate);
        //System.out.println("here is OK" + Username);


        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html><head><title>Select SQL result</title></head><body>");
            writer.println("<table border='1'>");
            writer.println("<tr>");

            writer.println("<th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th>");
            writer.println("</tr>");


            for (Map<String, Object> row : results) {
                writer.println("<tr>");
                writer.println("<td>" + row.get("ID") + "</td>");
                writer.println("<td>" + row.get("Username") + "</td>");
                writer.println("<td>" + row.get("Password") + "</td>");
                writer.println("<td>" + row.get("Email") + "</td>");
                writer.println("<td>" + row.get("Gender") + "</td>");
                writer.println("<td>" + row.get("Birthdate") + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body></html>");
        }
        System.out.println("select is OK");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("doGet() is OK");

    }
}
