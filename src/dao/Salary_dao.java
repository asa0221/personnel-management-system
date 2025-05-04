package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Salary_dao {
    public void insert_salary(Connection con, String S_id, String Year, String Month) {
        try {
            String Name = null;
            String D_id = null;
            String Position = null;
            String D_name = null;
            Float Basic_salary=null;
            Staff_dao staff_dao = new Staff_dao();
            Department_dao department_dao = new Department_dao();
            ResultSet refirst = staff_dao.SelectStaff(con, S_id);
            while (refirst.next()) {
                Name = refirst.getString("Name");
                D_id = refirst.getString("D_id");
                Position = refirst.getString("Position");
            }
            String Manager = null;
            if (Objects.equals(Position, "manager") || Objects.equals(Position, "HR")) {
                Manager = "Y";
            } else {
                Manager = "N";
            }
            D_name=department_dao.didTansdname(con,D_id);
            System.out.println(10);
            String SQL_Basic_salary_reference = "select * from Basic_salary_reference where D_id=? and Manager=?";
            PreparedStatement pstmt = con.prepareStatement(SQL_Basic_salary_reference);
            pstmt.setString(1, D_id);
            pstmt.setString(2, Manager);
            ResultSet rethird = pstmt.executeQuery();
            while(rethird.next()){
                Basic_salary = rethird.getFloat("Basic_salary");
            }
            System.out.println(19);
            Count_performance_dao count_performance_dao = new Count_performance_dao();
            ResultSet reforth = count_performance_dao.Select_by_time_and_s_id(con, Year, Month, S_id);
            String Rate=null;
            while(reforth.next()){
                Rate = reforth.getString("Rate");
            }
            Performance_rules_dao performance_rules_dao = new Performance_rules_dao();
            ResultSet refifth = performance_rules_dao.Select_by_rate(con, Rate);
            Float Bonus= (float) 0;
            while(refifth.next()){
                Bonus = refifth.getFloat("Bonus");
            }
            Float Bonus_salary = (Basic_salary) * Bonus;
            Attendance_count_dao attendance_count_dao = new Attendance_count_dao();
            ResultSet resixth = attendance_count_dao.SelectAttend_count(con, Year, Month, S_id);
            Float Attendance_fine = (float) 0;
            System.out.println(20);
            System.out.println(Rate);
            while(resixth.next()){
                Attendance_fine=resixth.getFloat("Attendance_fine");
                System.out.println(Attendance_fine);
            }
            Float Before_tax = Bonus_salary - Attendance_fine;
            Tax_reference_dao tax_reference_dao = new Tax_reference_dao();
            ResultSet reseventh = tax_reference_dao.Select_Tax_reference(con, Before_tax);
            Float tax_rate= (float) 0;
            while (reseventh.next()){
                tax_rate = reseventh.getFloat("Tax_rate");
            }
            Float tax = (Before_tax * tax_rate);
            Float After_tax = Before_tax - tax;
            String insert_Salary="insert into Salary values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmts=con.prepareStatement(insert_Salary);
            pstmts.setString(1,Year);
            pstmts.setString(2,Month);
            pstmts.setString(3,S_id);
            pstmts.setString(4,Name);
            pstmts.setString(5,D_id);
            pstmts.setString(6,D_name);
            pstmts.setFloat(7,Basic_salary);
            pstmts.setString(8,Rate);
            pstmts.setFloat(9,Bonus);
            pstmts.setFloat(10,Bonus_salary);
            pstmts.setFloat(11,Attendance_fine);
            pstmts.setFloat(12,Before_tax);
            pstmts.setFloat(13,tax_rate);
            pstmts.setFloat(14,tax);
            pstmts.setFloat(15,After_tax);
            pstmts.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet select_salary(Connection con,String Year,String Month,String S_id) throws Exception{
        String sql = "select *from Salary where Year=? and Month=? and S_id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,Year);
        pstmt.setString(2,Month);
        pstmt.setString(3,S_id);
        System.out.println(pstmt);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
    public  ResultSet select_year_salary(Connection con,String Year,String S_id)throws  Exception{
        String sql="select * from Salary where Year=? and S_id=? ORDER BY CAST(Month AS UNSIGNED) ASC";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,Year);
        pstmt.setString(2,S_id);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
    public  ResultSet select_all_by_D_id(Connection con,String D_id)throws Exception{
        String sql="select * from Salary where D_id=? ORDER BY S_id";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,D_id);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
    public  ResultSet select_all_by_time(Connection con,String Year,String Month)throws Exception{
        String sql="select * from Salary where Year=? and Month=? ORDER BY S_id";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,Year);
        pstmt.setString(2,Month);
        System.out.println(pstmt);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
}
