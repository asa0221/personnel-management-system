package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;

public class Attendance_count_dao {

    public void Cre_cou(Connection con, ResultSet rs) throws Exception {
        try {
            int a = 0, b = 0, c = 0, d = 0, e = 0;
            String time = null;
            String S_id = null;
            while (rs.next()) {
                if (rs.getString("Attendance").equals("attendance")) {
                    a++;
                    time = String.valueOf(rs.getDate("Time"));
                    S_id = rs.getString("S_id");
                } else if (rs.getString("Attendance").equals("absence")) {
                    b++;
                    time = String.valueOf(rs.getDate("Time"));
                    S_id = rs.getString("S_id");
                } else if (rs.getString("Attendance").equals("late or leave early")) {
                    c++;
                    time = String.valueOf(rs.getDate("Time"));
                    S_id = rs.getString("S_id");
                } else if (rs.getString("Attendance").equals("personal leave")) {
                    d++;
                    time = String.valueOf(rs.getDate("Time"));
                    S_id = rs.getString("S_id");
                } else if (rs.getString("Attendance").equals("sick leave")) {
                    e++;
                    time = String.valueOf(rs.getDate("Time"));
                    S_id = rs.getString("S_id");
                }
            }
            String year = time.substring(0, 4);
            String month =time.substring(5, 7);
            ResultSet resultSet=SelectAttend_count(con,year,month,S_id);
            if (resultSet.next()){
                deleteAttend_count(con, year, month,S_id);
            }
            String D_idsql = "select D_id from Staff where S_id=? ";
            PreparedStatement getD_id = con.prepareStatement(D_idsql);
            getD_id.setString(1, S_id);
            ResultSet rs1 = getD_id.executeQuery();
            String d_id = null;
            while (rs1.next()) {
                d_id = rs1.getString("D_id");
                break;
            }
            String D_id = d_id;
            String insert = "insert into Attendance_count values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preinsert = con.prepareStatement(insert);
            preinsert.setString(1, year);
            preinsert.setString(2, month);
            preinsert.setString(3, S_id);
            preinsert.setString(4, D_id);
            preinsert.setInt(5, a);
            preinsert.setInt(6, b);
            preinsert.setFloat(7, 100);
            preinsert.setInt(8, c);
            preinsert.setFloat(9, 50);
            preinsert.setInt(10, d);
            preinsert.setInt(11, e);
            preinsert.setFloat(12, (b * 100 + c * 50));
            System.out.println(preinsert);
            preinsert.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public ResultSet SelectAttend_count(Connection con, String Year, String Month, String S_id) throws Exception {
        String sql = "select *from Attendance_count where Year=? and Month=?and S_id=? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, Year);
        pstmt.setString(2, Month);
        pstmt.setString(3, S_id);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    public void deleteAttend_count(Connection con, String Year, String Month, String S_id) throws Exception {
        String sql="delete from Attendance_count where year=? and month=? and S_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,Year);
        pstmt.setString(2, Month);
        pstmt.setString(3, S_id);
        pstmt.execute();

    }
}

