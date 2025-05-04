package dao;



import subject.Administraor;
import subject.Database;
import subject.Performance;

import java.sql.*;
import java.util.ArrayList;

public class Administrator_dao {
    Database db=new Database();
    public int AddAdmin(Connection con, Administraor admin) throws Exception {

        String sql = "insert into Administrator values(?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, admin.getAdministraor_id());
        pstmt.setString(2, admin.getAdministraor_passward());
        pstmt.setString(3, admin.getAdministraor_name());

        return pstmt.executeUpdate();
    }

    public int ModifyAdmin(Connection con, String Administrator_password,String Administrator_id) throws Exception {
        String sql = "update Administrator set Administrator_password = ? " +
                " where Administrator_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Administrator_password);
        pstmt.setString(2, Administrator_id);
        return pstmt.executeUpdate();
    }

    public int DeleteAdmin(Connection con, String Administrator_id) throws Exception {
        String sql = "delete from Administrator where Administrator_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Administrator_id);
        return pstmt.executeUpdate();
    }

    public ResultSet SelectAdmin_byid(Connection con, String Administrator_id) throws Exception {
        String sql = "select * from Administrator where Administrator_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Administrator_id);
        return pstmt.executeQuery();
    }
    public ResultSet SelectAdmin_byname(Connection con, String Administrator_name) throws Exception {
        String sql = "select *from Administrator where Administrator_name =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Administrator_name);
        return pstmt.executeQuery();
    }
    public ResultSet SelectAdmin_fuzzy(Connection con, String Administrator_name) throws Exception {
        String sql = "select *from Administrator where Administrator_name LIKE '%"+Administrator_name+"%'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
    public ResultSet selectallAdmin(Connection con)throws Exception{
        String sql="select*from Administrator";
        PreparedStatement pstmt=con.prepareStatement(sql);
        return pstmt.executeQuery();
    }}
