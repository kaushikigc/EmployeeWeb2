/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.empweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gaura
 */
public class JDBCConnectionManager {//public static Connection getMySQLConnection()
//    {
//        Connection connection = null;
//
//        try {
//            // we use use the url, userid and passowrd to ge the connection
//         Class.forName("com.mysql.cj.jdbc.Driver"); // loading the call in memory 
//
//     //
//        } 
//      catch (ClassNotFoundException  ex) {
//        ex.printStackTrace();
//        }
//
//
//        return connection;
//    }
//    
//}
public static Connection getMySQLConnection()
    {Connection connection =null;
    try {
        PropertyFileReader util= PropertyFileReader.getInstance();
        	String user = util.getPropertyValue("user");
        	String pass= util.getPropertyValue("pass");
        	String url = util.getPropertyValue("url");
        	String dbName = util.getPropertyValue("dbName");
        	String driveName = util.getPropertyValue("driveName");
            // we use use the url, userid and passowrd to ge the connection
            Class.forName(driveName);
            // loading the call in memory
            connection = DriverManager.getConnection(url+dbName,user,pass);
    } catch (ClassNotFoundException | SQLException ex) {
        //ex.printStackTrace();
    }
    return connection;
}
}
