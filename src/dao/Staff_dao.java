package dao;

import subject.Staff;

import javax.naming.Name;
import java.sql.*;

public class Staff_dao {
    public int AddStaff(Connection con, Staff staff) throws Exception {

        String sql = "insert into Staff values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,staff.getS_id());
        pstmt.setString(2, staff.getName());
        pstmt.setString(3, staff.getSex());
        pstmt.setString(4, staff.getD_id());
        pstmt.setString(5, staff.getPosition());
        pstmt.setString(6, staff.getAge());
        pstmt.setString(7, staff.getTelephone());
        pstmt.setString(8, staff.getEmail());
        pstmt.setString(9, staff.getAddress());
        pstmt.setString(10, staff.getPassword());
        pstmt.setString(11, staff.getState());
        System.out.println(pstmt);
        System.out.println(staff.getSex());


        return pstmt.executeUpdate();
    }

    public int MOdifyStaff(Connection con, Staff staff) throws Exception {
        String sql = "update Staff set Name = ?, Sex = ?, D_id = ? , Position = ? ,Age = ?,Telephone = ?, Email = ?, Address = ?, Password = ?, State=? where S_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(11, staff.getS_id());
        pstmt.setString(1, staff.getName());
        pstmt.setString(2, staff.getSex());
        pstmt.setString(3, staff.getD_id());
        pstmt.setString(4, staff.getPosition());
        pstmt.setString(5, staff.getAge());
        pstmt.setString(6, staff.getTelephone());
        pstmt.setString(7, staff.getEmail());
        pstmt.setString(8, staff.getAddress());
        pstmt.setString(9, staff.getPassword());
        pstmt.setString(10, staff.getState());
        System.out.println(pstmt);
        return pstmt.executeUpdate();
    }
    public int Change_staffP(Connection con,String Password,String S_id) throws SQLException {
        String sql="update Staff set Password=? where S_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,Password);
        pstmt.setString(2,S_id);
        return pstmt.executeUpdate();
    }

    public int DeleteStaff(Connection con, String S_id) throws Exception {
        String sql = "delete from Staff where S_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, S_id);
        return pstmt.executeUpdate();
    }

    public ResultSet SelectStaff(Connection con, String S_id) throws Exception {
        String sql = "select *from Staff where S_id =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, S_id);
        System.out.println(pstmt);
        return pstmt.executeQuery();

    }
    public ResultSet SelectStaff_byname(Connection con, String name) throws Exception {
        String sql = "select *from Staff where Name =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        System.out.println(pstmt);
        return pstmt.executeQuery();}
    public ResultSet selectallStaff(Connection con)throws Exception{
        String sql="select*from Staff";
        PreparedStatement pstmt=con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
}
