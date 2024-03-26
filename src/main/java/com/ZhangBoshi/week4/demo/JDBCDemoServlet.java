package com.ZhangBoshi.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( //name="JDBCDemoServlet"
        urlPatterns = {"/jdbc"},
        //initParams = {
                //@WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                //@WebInitParam(name="url",value = "jdbc:sqlserver://localhost;databaseName=userdb;"),
                //@WebInitParam(name="username",value = "sa"),
                //@WebInitParam(name="password",value = "@10%10/1-+0#$2*&4")
        //},
        loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url = "jdbc:sqlserver://localhost;databaseName=userdb;";
        //String username = "sa";
        //String password = "@10%10/1-+0#$2*&4";

        //ServletConfig config=getServletConfig();
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String username=config.getInitParameter("username");
        //String password=config.getInitParameter("password");

        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("i am in doGet()");
        String sql="select * from Usertable";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while (rs.next() ){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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
