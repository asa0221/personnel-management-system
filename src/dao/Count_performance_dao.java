package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Count_performance_dao {

    public ResultSet Select_by_time_and_s_id(Connection con, String Year,String Month,String S_id) throws Exception {
        String sql = "select *from Count_performance where Year=? and Month=? and S_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Year);
        pstmt.setString(2,Month);
        pstmt.setString(3,S_id);
        return pstmt.executeQuery();
    }
}
