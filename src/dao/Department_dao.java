package dao;

import subject.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department_dao {
    public int AddDepart(Connection con, Department depart) throws Exception {

        String sql = "insert into Department values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, depart.getD_name());
        pstmt.setString(2, depart.getD_id());
        pstmt.setString(3, depart.getS_id());
        pstmt.setString(4, depart.getName());

        return pstmt.executeUpdate();
    }

    public int MOdifyDepart(Connection con, Department depart) throws Exception {
        String sql = "update Department set D_name = ?,  S_id = ? ," +
                " Name = ? , State=? where D_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, depart.getD_name());
        pstmt.setString(2, depart.getS_id());
        pstmt.setString(3, depart.getName());
        pstmt.setString(4, depart.getD_id());

        return pstmt.executeUpdate();
    }

    public int DeleteDepart(Connection con, String D_id) throws Exception {
        String sql = "delete from Department where D_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, D_id);
        return pstmt.executeUpdate();
    }

    public ResultSet SelectAllDepart(Connection con) throws Exception {
        String sql = "select *from Department";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public ResultSet SelectDepartby_D_id(Connection con, String D_id) throws Exception {
        String sql = "select *from Staff where D_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, D_id);
        System.out.println(pstmt);
        return pstmt.executeQuery();
    }
    public String didTansdname(Connection con,String D_id) throws SQLException {
        String sql = "select *from Department where D_id =?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,D_id);
        System.out.println(pstmt);
        ResultSet rs=pstmt.executeQuery();
        String did=null;
        if (rs.next()){
            did=rs.getString("D_name");
        }
        return did;
    }

    public String SelectDepartby_D_idToS_id(Connection con, String D_id) throws Exception {
        String sql = "select S_id from Department where D_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, D_id);
        ResultSet rs=pstmt.executeQuery();
        String S_id=null;
        if (rs.next()){
            S_id=rs.getString("S_id");
        }
        return S_id;
    }
    public String SelectDepartby_S_idToD_id(Connection con, String S_id) throws Exception {
        String sql = "select D_id from Department where S_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, S_id);
        ResultSet rs=pstmt.executeQuery();
        String D_id=null;
        if (rs.next()){
            D_id=rs.getString("D_id");
        }
        return D_id;
    }


}