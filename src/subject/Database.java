package subject;

import java.sql.*;
public class Database {
    private String dbUser="ms20110106";
    private String dbPassword="20110106";
    private String dbPath="jdbc:mysql://124.71.135.160/mysql20110106";
    private String cname="com.mysql.cj.jdbc.Driver";

    public Connection getCon()throws Exception  {
        try {
            //连接数据库
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库链接
            Connection con = DriverManager.getConnection(dbPath, dbUser, dbPassword);
            System.out.println("数据库链接成功!");
            return con;
        } catch (Exception se) {
            se.printStackTrace();
        }
        return null;
    }}
