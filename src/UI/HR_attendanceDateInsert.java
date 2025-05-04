/*
 * Created by JFormDesigner on Tue Oct 11 10:36:10 GMT+08:00 2022
 */

package UI;

import dao.Attendance_data_dao;
import dao.Staff_dao;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * @author unknown
 */
public class HR_attendanceDateInsert extends JFrame {
    public static final Database db=new Database();

    public static final Connection con;

    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Staff user;


    public HR_attendanceDateInsert() {
        initComponents();
        comboBox1();
    }




    private void button1(ActionEvent e) {
        try {
            String S_id = (String) comboBox1.getSelectedItem();
            String Year = comboBox2.getSelectedItem().toString();
            String Month = comboBox3.getSelectedItem().toString();
            String Day = comboBox4.getSelectedItem().toString();
            String time = Year +"-"+ Month +"-"+ Day;
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date Time = dateFormat.parse(time);
            String Attendance = (String) comboBox5.getSelectedItem();
            String D_name=label10.getText();
            String sql = "select D_name from Department INNER JOIN Staff ON Department.D_id=Staff.D_id WHERE Staff.S_id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, (String) comboBox1.getSelectedItem());
            ResultSet re=pstmt.executeQuery();
            if (re.next()){
               D_name=re.getString("D_name") ;
            }
            Attendance_data_dao attendance_data_dao=new Attendance_data_dao();
            attendance_data_dao.AddAtten_data(con,S_id,time,Attendance,D_name);
            dialog1.setVisible(true);
        }catch (Exception se) {
            se.printStackTrace();
            dialog2.setVisible(true);
        }
    }

    private void button3(ActionEvent e) {
        try {
            String sql = "select D_name from Department INNER JOIN Staff ON Department.D_id=Staff.D_id WHERE Staff.S_id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println(pstmt);
            pstmt.setString(1, (String) comboBox1.getSelectedItem());
            ResultSet re=pstmt.executeQuery();
            if (re.next()){
                label10.setText(re.getString("D_name"));
                label10.setForeground(Color.BLACK);
            }else {
                label10.setText("员工不存在！");
                label10.setForeground(Color.red);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void comboBox1() {
        try  {
            Staff_dao staff_dao = new Staff_dao();
            ResultSet resultSet = staff_dao.selectallStaff(con);
            Vector<String> v = new Vector<>();
            while (resultSet.next()) {
                v.add(resultSet.getString("S_id"));
            }
            v.add("all");
            comboBox1.setModel(new DefaultComboBoxModel(v));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox2 = new JComboBox<>();
        label3 = new JLabel();
        comboBox3 = new JComboBox<>();
        label4 = new JLabel();
        comboBox4 = new JComboBox<>();
        label5 = new JLabel();
        label6 = new JLabel();
        comboBox5 = new JComboBox<>();
        label7 = new JLabel();
        button1 = new JButton();
        button3 = new JButton();
        label10 = new JLabel();
        comboBox1 = new JComboBox();
        dialog1 = new JDialog();
        label8 = new JLabel();
        dialog2 = new JDialog();
        label9 = new JLabel();

        //======== this ========
        setTitle("\u8003\u52e4\u4fe1\u606f\u5f55\u5165");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u5458\u5de5\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

        //---- label2 ----
        label2.setText("\u8bf7\u9009\u62e9\u6253\u5361\u65f6\u95f4\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "2022",
            "2021",
            "2020",
            "2019",
            "2018"
        }));

        //---- label3 ----
        label3.setText("\u5e74");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- comboBox3 ----
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
        }));

        //---- label4 ----
        label4.setText("\u6708");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- comboBox4 ----
        comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
        }));

        //---- label5 ----
        label5.setText("\u65e5");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

        //---- label6 ----
        label6.setText("\u8bf7\u9009\u62e9\u5458\u5de5\u8003\u52e4\u7c7b\u578b\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));

        //---- comboBox5 ----
        comboBox5.setModel(new DefaultComboBoxModel<>(new String[] {
            "attendance",
            "absence",
            "late or leave early",
            "personal leave",
            "sick leave"
        }));
        comboBox5.setFont(comboBox5.getFont().deriveFont(comboBox5.getFont().getSize() + 1f));

        //---- label7 ----
        label7.setText("\u8bf7\u9009\u62e9\u5458\u5de5\u6240\u5c5e\u90e8\u95e8\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));

        //---- button1 ----
        button1.setText("\u6267\u884c\u5f55\u5165");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> button1(e));

        //---- button3 ----
        button3.setText("\u5237\u65b0\u90e8\u95e8");
        button3.addActionListener(e -> button3(e));

        //---- comboBox1 ----
        comboBox1.addActionListener(e -> comboBox1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox5)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(82, 82, 82)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label5)))
                                .addComponent(button3, GroupLayout.Alignment.LEADING))))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(label5)
                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)
                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3))
                    .addGap(56, 56, 56)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a\u9875");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label8 ----
            label8.setText("\u5f55\u5165\u6210\u529f");
            label8.setFont(label8.getFont().deriveFont(Font.BOLD, label8.getFont().getSize() + 9f));
            label8.setForeground(new Color(0xff3333));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(103, Short.MAX_VALUE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(label8)
                        .addContainerGap(83, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a\u9875");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label9 ----
            label9.setText("\u5f55\u5165\u5931\u8d25");
            label9.setFont(label9.getFont().deriveFont(Font.BOLD, label9.getFont().getSize() + 9f));
            label9.setForeground(new Color(0xff3333));

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(label9)
                        .addContainerGap(84, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JComboBox<String> comboBox2;
    private JLabel label3;
    private JComboBox<String> comboBox3;
    private JLabel label4;
    private JComboBox<String> comboBox4;
    private JLabel label5;
    private JLabel label6;
    private JComboBox<String> comboBox5;
    private JLabel label7;
    private JButton button1;
    private JButton button3;
    private JLabel label10;
    private JComboBox comboBox1;
    private JDialog dialog1;
    private JLabel label8;
    private JDialog dialog2;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
