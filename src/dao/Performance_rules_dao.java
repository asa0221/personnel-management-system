package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Performance_rules_dao {
    public ResultSet Select_by_rate(Connection con, String Rate) throws Exception {
        String sql = "select *from Preformance_rules where Rating=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Rate);
        return pstmt.executeQuery();
    }

}
