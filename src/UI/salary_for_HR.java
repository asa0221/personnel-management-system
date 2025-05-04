/*
 * Created by JFormDesigner on Tue Oct 11 13:35:53 GMT+08:00 2022
 */

package UI;

import java.awt.*;

import dao.*;
import subject.Database;
import subject.Staff;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class salary_for_HR extends JFrame {
    public static final Database db = new Database();

    Connection con=db.getCon();


    public salary_for_HR() throws Exception {
        initComponents();
        comboBox1();
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

    private void comboBox1ItemStateChanged(ItemEvent e) {
        try {
            String sid = (String) comboBox1.getSelectedItem();
            if (!Objects.equals(sid, "all")) {
                Staff_dao staff_dao = new Staff_dao();
                ResultSet resultSet = staff_dao.SelectStaff(con, sid);
                if (resultSet.next()) {
                    String sname = resultSet.getString("Name");
                    label10.setText(sname);
                    label10.setForeground(Color.blue);
                }
            }else {
                label10.setText("");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button1(ActionEvent e) {
        String S_id = (String) comboBox1.getSelectedItem();
        String Year = Objects.requireNonNull(comboBox2.getSelectedItem()).toString();
        String Month = Objects.requireNonNull(comboBox3.getSelectedItem()).toString();
        if ((!Month.equals("all")) && (!Objects.equals(S_id, "all"))) {
            //查询不涉及到"all"的内容
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            try {
                if (S_id.isEmpty()) {
                    dialog2.setVisible(true);
                } else {
                    Salary_dao salary_dao = new Salary_dao();
                    ResultSet es = salary_dao.select_salary(con, Year, Month, S_id);
                    Vector<String> v = new Vector<>();
                    while (es.next()) {
                        v.add(es.getString("Year"));
                        v.add(es.getString("Month"));
                        v.add(es.getString("S_id"));
                        v.add(es.getString("Name"));
                        v.add(es.getString("D_id"));
                        v.add(es.getString("D_name"));
                        v.add(String.valueOf(es.getFloat("Basic_salary")));
                        v.add(es.getString("Rate"));
                        v.add(String.valueOf(es.getFloat("Bonus")));
                        v.add(String.valueOf(es.getFloat("Bonus_salary")));
                        v.add(String.valueOf(es.getFloat("Attendance_fine")));
                        v.add(String.valueOf(es.getFloat("Before_tax")));
                        v.add(String.valueOf(es.getFloat("tax_rate")));
                        v.add(String.valueOf(es.getFloat("tax")));
                        v.add(String.valueOf(es.getFloat("After_tax")));
                    }
                    model.addRow(v);
                    if (table1.getValueAt(0, 0) == null) {
                        label8.setText("暂无当月工资信息");
                        label8.setForeground(Color.red);
                    } else {
                        label8.setText("");
                        dialog1.setVisible(true);
                    }
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        } else if ((!Objects.equals(S_id, "all")) && (Month.equals("all"))) {
            //查询一个员工当年所有薪资数据。
            try {
                if (S_id.isEmpty()) {
                    dialog2.setVisible(true);
                } else {
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    for (int i = 1; i <= 12; i++) {
                        Salary_dao salary_dao = new Salary_dao();
                        String month;
                        if (i <= 9) {
                            month = "0" + i;
                        } else {
                            month = String.valueOf(i);
                        }
                        ResultSet es = salary_dao.select_salary(con, Year, month, S_id);
                        Vector<String> v = new Vector<>();
                        while (es.next()) {
                            v.add(es.getString("Year"));
                            v.add(es.getString("Month"));
                            v.add(es.getString("S_id"));
                            v.add(es.getString("Name"));
                            v.add(es.getString("D_id"));
                            v.add(es.getString("D_name"));
                            v.add(String.valueOf(es.getFloat("Basic_salary")));
                            v.add(es.getString("Rate"));
                            v.add(String.valueOf(es.getFloat("Bonus")));
                            v.add(String.valueOf(es.getFloat("Bonus_salary")));
                            v.add(String.valueOf(es.getFloat("Attendance_fine")));
                            v.add(String.valueOf(es.getFloat("Before_tax")));
                            v.add(String.valueOf(es.getFloat("tax_rate")));
                            v.add(String.valueOf(es.getFloat("tax")));
                            v.add(String.valueOf(es.getFloat("After_tax")));
                        }
                        if (!v.isEmpty()) {
                            model.addRow(v);
                        }
                    }
                    if (table1.getRowCount() == 0) {
                        label8.setText("暂无此员工工资信息");
                        label8.setForeground(Color.red);
                    } else {
                        label8.setText("");
                        dialog1.setVisible(true);
                    }
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        } else if ((S_id.equals("all")) && (!Month.equals("all"))) {
            try {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0);
                Salary_dao salary_dao = new Salary_dao();
                ResultSet es = salary_dao.select_all_by_time(con, Year, Month);
                while (es.next()) {
                    Vector<String> v = new Vector<>();
                    v.add(es.getString("Year"));
                    v.add(es.getString("Month"));
                    v.add(es.getString("S_id"));
                    v.add(es.getString("Name"));
                    v.add(es.getString("D_id"));
                    v.add(es.getString("D_name"));
                    v.add(String.valueOf(es.getFloat("Basic_salary")));
                    v.add(es.getString("Rate"));
                    v.add(String.valueOf(es.getFloat("Bonus")));
                    v.add(String.valueOf(es.getFloat("Bonus_salary")));
                    v.add(String.valueOf(es.getFloat("Attendance_fine")));
                    v.add(String.valueOf(es.getFloat("Before_tax")));
                    v.add(String.valueOf(es.getFloat("tax_rate")));
                    v.add(String.valueOf(es.getFloat("tax")));
                    v.add(String.valueOf(es.getFloat("After_tax")));
                    model.addRow(v);
                }
                if (table1.getRowCount() == 0) {
                    label8.setText("暂无当月工资信息");
                    label8.setForeground(Color.red);
                } else label8.setText("");
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
    }

    private void button3(ActionEvent e) {
        try (Connection c = db.getCon()) {
            Salary_photo salaryphoto = new Salary_photo(c, comboBox2.getSelectedItem().toString(), (String) comboBox1.getSelectedItem());
            JFrame frame = new JFrame("月度部门员工奖金提成柱状统计");
            frame.add(salaryphoto.getChartPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void button2(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox2 = new JComboBox<>();
        label3 = new JLabel();
        label4 = new JLabel();
        comboBox3 = new JComboBox<>();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label8 = new JLabel();
        label9 = new JLabel();
        comboBox1 = new JComboBox();
        label10 = new JLabel();
        dialog1 = new JDialog();
        label6 = new JLabel();
        dialog2 = new JDialog();
        label7 = new JLabel();

        //======== this ========
        setTitle("\u5458\u5de5\u6708\u5de5\u8d44\u67e5\u8be2");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u67e5\u8be2\u5458\u5de5\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u67e5\u8be2\u7684\u5e74\u4efd\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "2022",
            "2021",
            "2020",
            "2019",
            "2018"
        }));
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 2f));

        //---- label3 ----
        label3.setText("\u5e74");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- label4 ----
        label4.setText("\u8bf7\u8f93\u5165\u67e5\u8be2\u7684\u6708\u4efd\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- comboBox3 ----
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
            "11",
            "12",
            "all"
        }));

        //---- label5 ----
        label5.setText("\u6708");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Year", "Month", "S_id", "Name", "D_id", "D_name", "Basic_salary\t", "Rate", "Bonus", "Bonus_salary", "Attendance_fine", "Before_tax", "tax_rate", "tax", "After_tax"
                }
            ));
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u6267\u884c\u67e5\u8be2");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
        button2.addActionListener(e -> button2(e));

        //---- button3 ----
        button3.setText("\u751f\u6210\u6708\u62a5\u7edf\u8ba1\u56fe");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 2f));
        button3.addActionListener(e -> button3(e));

        //---- label9 ----
        label9.setText("\u652f\u6301\u67e5\u8be2\u5168\u90e8\u5458\u5de5\u5de5\u8d44\u4fe1\u606f\uff0c\u5728\u5de5\u53f7\u5904\u9009\u62e9\"all\"");
        label9.setForeground(Color.blue);

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addGap(117, 117, 117))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4))))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(label9)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(comboBox3, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label8)
                    .addGap(12, 12, 12)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a\u9875");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label6 ----
            label6.setForeground(Color.red);
            label6.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 17));
            label6.setText("\u67e5\u8be2\u6210\u529f");

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a\u9875");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label7 ----
            label7.setForeground(Color.red);
            label7.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 17));
            label7.setText("\u67e5\u8be2\u5931\u8d25");

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
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
    private JLabel label4;
    private JComboBox<String> comboBox3;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label8;
    private JLabel label9;
    private JComboBox comboBox1;
    private JLabel label10;
    private JDialog dialog1;
    private JLabel label6;
    private JDialog dialog2;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
