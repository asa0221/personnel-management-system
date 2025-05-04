package dao;

import subject.Performance;

import java.sql.*;
import java.util.ArrayList;

public class Performance_dao {
    public Performance_dao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://124.71.135.160/mysql20110106", "ms20110106", "20110106");
    }

    public void Add(Performance performance) {
        String sql = "insert into Count_performance values(?,?,?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, performance.getYear());
            pstmt.setString(2, performance.getMonth());
            pstmt.setString(3, performance.getS_id());
            pstmt.setString(4, performance.getReport());
            pstmt.setString(5, performance.getReview());
            pstmt.setString(6, performance.getRate());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Performance performance) {
        String sql = "update Count_performance set Review=?,Rate=? where Year=? and Month=? and S_id=? ";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, performance.getReview());
            pstmt.setString(2, performance.getRate());
            pstmt.setString(3, performance.getYear());
            pstmt.setString(4, performance.getMonth());
            pstmt.setString(5, performance.getS_id());
            System.out.println(pstmt);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatenull(Performance performance) {
        String sql = "update Count_performance set Review=? where Year=? and Month=? and S_id=? ";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, performance.getReview());
            pstmt.setString(2, performance.getYear());
            pstmt.setString(3, performance.getMonth());
            pstmt.setString(4, performance.getS_id());
            System.out.println(pstmt);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(String S_id) throws SQLException {
        String sql = "delete from Count_performance where S_id=?";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, S_id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Performance> Selectbyid(String Sid) {
        ArrayList<Performance> performances = new ArrayList<Performance>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select*from Count_performance where S_id=" + Sid;
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Performance performance = new Performance();
                String Year = rs.getString(1);
                String Month = rs.getString(2);
                String S_id = rs.getString(3);
                String Report = rs.getString(4);
                String Review = rs.getString(5);
                String Rate = rs.getString(6);
                performance.setYear(Year);
                performance.setMonth(Month);
                performance.setS_id(S_id);
                performance.setReport(Report);
                performance.setReview(Review);
                performance.setRate(Rate);
                performances.add(performance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performances;
    }

    public Performance SelectbyMonthP(String year, String month) {
        Performance performance = null;
        String sql = "select*from Count_performance where Year=? and Month=?";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, year);
            pstmt.setString(2, month);
            ResultSet rs = pstmt.executeQuery(sql);
            if (rs.next()) {
                performance = new Performance();
                String Year = rs.getString(1);
                String Month = rs.getString(2);
                String S_id = rs.getString(3);
                String Report = rs.getString(4);
                String Review = rs.getString(5);
                String Rate = rs.getString(6);
                performance.setYear(Year);
                performance.setMonth(Month);
                performance.setS_id(S_id);
                performance.setReport(Report);
                performance.setReview(Review);
                performance.setRate(Rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performance;

    }

    public Performance SelectReview(String year, String month, String s_id) {
        Performance performance = null;
        String sql = "select*from Count_performance where Year=? and Month=? and S_id =?";
        try (Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, year);
            pstmt.setString(2, month);
            pstmt.setString(3, s_id);
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(pstmt);
            if (rs.next()) {
                performance = new Performance();
                String Year = rs.getString(1);
                String Month = rs.getString(2);
                String S_id = rs.getString(3);
                String Report = rs.getString(4);
                String Review = rs.getString(5);
                String Rate = rs.getString(6);
                performance.setYear(Year);
                performance.setMonth(Month);
                performance.setS_id(S_id);
                performance.setReport(Report);
                performance.setReview(Review);
                performance.setRate(Rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performance;

    }
}
