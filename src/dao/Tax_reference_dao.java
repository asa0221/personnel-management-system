package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tax_reference_dao {
    public ResultSet Select_Tax_reference(Connection con, Float Before_tax) throws Exception {
        String sql = "select *from Tax_reference where Salary_lower<= ? and Salary_upper>= ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setFloat(1,Before_tax);
        pstmt.setFloat(2,Before_tax);
        return pstmt.executeQuery();
    }
}
