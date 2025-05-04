package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlObject {
    public Boolean CanAdd(Connection con, String tablename, String columnname, String date) throws SQLException {
        String sql = "select*from" + tablename + "where" + columnname + "=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, date);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean CanModify(Connection con, String tablename, String columnname, String date) throws SQLException {
        String sql = "select*from" + tablename + "where" + columnname + "=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, date);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    public ResultSet QueryA_information(Connection con,String searchCondition,String searchContent) throws SQLException
    {
        String sql="";
        if (searchContent.isEmpty()){
            sql="select * from Administrator";
            PreparedStatement pstmt=con.prepareStatement(sql);
            return pstmt.executeQuery();
        }
        else{
            sql ="select * from Adminiatrator where " +  searchCondition + "  = ? ";
            PreparedStatement pstmt=con.prepareStatement(sql);
            System.out.println(sql);
            pstmt.setString(1,searchContent);
            return pstmt.executeQuery();
        }
    }

}

