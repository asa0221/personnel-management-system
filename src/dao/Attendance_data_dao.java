package dao;
import subject.Attendance_data;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Attendance_data_dao {

    public Date convertJavaDateToSqlDate(java.util.Date date) {
        return new Date(date.getTime());
    }
    public ResultSet SelectAtten_data(Connection con, String S_id, Date Time) throws Exception {
        String sql = "select *from Attendance_data where S_id='"+S_id+"' and Time=? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        Date sqldate = convertJavaDateToSqlDate(Time);
        pstmt.setDate(1,sqldate);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public void AddAtten_data(Connection con, String S_id,String Time,String Attendance,String D_name) throws Exception {
        String sql = "insert into Attendance_data values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, S_id);
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//        String Time= df.format(e.getTime());
//        System.out.println(e.getTime());
        pstmt.setString(2,Time);
        pstmt.setString(3, Attendance);
        pstmt.setString(4, D_name);
        pstmt.executeUpdate();
    }

    public int deleteAtt_da(Connection con, String S_id, Date Time) throws Exception {
        String sql = "delete from Attendance_data where S_id=? and Time=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, S_id);
        pstmt.setDate(2, (Date) Time);
        return pstmt.executeUpdate();
    }
    public ResultSet SelectALLAtt(Connection con, String Date, String S_id) throws  Exception{
        try{String sql="SELECT * FROM Attendance_data WHERE Time like '"+Date+"%' and S_id='"+S_id+"'";
            System.out.println(sql);
            PreparedStatement pstmt=con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch(SQLException e1){
            e1.printStackTrace();
        }
        return null;
    }
}