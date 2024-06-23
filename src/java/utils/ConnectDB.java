/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thai.ngoc
 */
public class ConnectDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //load drive
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //tạo chuỗi String để connect
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ProductIntro";
        //mở con
        Connection con = DriverManager.getConnection(url, "SA", "12345");
        return con;
    }

    public static void closeConnection(Connection con){
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

