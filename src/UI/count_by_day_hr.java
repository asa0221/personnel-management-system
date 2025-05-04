/*
 * Created by JFormDesigner on Tue Oct 04 11:46:19 GMT+08:00 2022
 */

package UI;

import java.awt.event.*;
import dao.Attendance_data_dao;
import dao.Staff_dao;
import subject.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

/**
 * @author unknown
 */
public class count_by_day_hr extends JFrame {
    public static final Database db = new Database();

    public static final Connection con;

    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public count_by_day_hr() {
        initComponents();
        comboBox1();
    }

    private void comboBox1() {
        try (Connection c = db.getCon()) {
            Staff_dao staff_dao = new Staff_dao();
            ResultSet resultSet = staff_dao.selectallStaff(c);
            Vector<String> v = new Vector<>();
            while (resultSet.next()) {
                v.add(resultSet.getString("S_id"));
            }
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
                Staff_dao staff_dao = new Staff_dao();
                ResultSet resultSet = staff_dao.SelectStaff(con, sid);
                if (resultSet.next()) {
                    String sname = resultSet.getString("Name");
                    label7.setText(sname);
                    label7.setForeground(Color.blue);
                }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void checkMouseClicked(MouseEvent e) {
        try {
            label4.setText("");
            String year = comboBoxyear.getSelectedItem().toString();
            String month = comboBoxmonth.getSelectedItem().toString();
            String day = comboBoxday.getSelectedItem().toString();
            String date = year + "-" + month + "-" + day;
            String s_id = (String) comboBox1.getSelectedItem();
            Attendance_data_dao attendance_data_dao = new Attendance_data_dao();
            ResultSet values = attendance_data_dao.SelectAtten_data(con, s_id, Date.valueOf(date));
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            Vector<String> v = null;
            if (values.next()) {
                v = new Vector<>();
                v.add(values.getString("S_id"));
                v.add(values.getDate("Time").toString());
                v.add(values.getString("Attendance"));
                v.add(values.getString("D_name"));
            } else {
                label4.setText("当日无考勤数据");
                label4.setForeground(Color.red);
            }
            model.setRowCount(0);
            model.addRow(v);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private void turn_to_month_button(ActionEvent e) {
        try {
            this.dispose();
            count_by_month_hr count_by_month_hr = new count_by_month_hr();
            count_by_month_hr.setVisible(true);
            dialog1.setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void button3(ActionEvent e) {
        this.dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        comboBoxyear = new JComboBox<>();
        comboBoxmonth = new JComboBox<>();
        comboBoxday = new JComboBox<>();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        label6 = new JLabel();
        comboBox1 = new JComboBox();
        label7 = new JLabel();
        label8 = new JLabel();
        dialog1 = new JDialog();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u65e5\u62a5\u67e5\u8be2");
        var contentPane = getContentPane();

        //---- comboBoxyear ----
        comboBoxyear.setModel(new DefaultComboBoxModel<>(new String[] {
            "2022",
            "2021",
            "2020",
            "2019",
            "2018",
            "2017",
            "2016",
            "2015"
        }));

        //---- comboBoxmonth ----
        comboBoxmonth.setModel(new DefaultComboBoxModel<>(new String[] {
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

        //---- comboBoxday ----
        comboBoxday.setModel(new DefaultComboBoxModel<>(new String[] {
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

        //---- label1 ----
        label1.setText("\u5e74");

        //---- label2 ----
        label2.setText("\u6708");

        //---- label3 ----
        label3.setText("\u65e5");

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u65e5\u62a5");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkMouseClicked(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "S_id", "Time", "Attendance", "D_name"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- button2 ----
        button2.setText("\u5207\u6362\u5230\u6708\u62a5");
        button2.addActionListener(e -> turn_to_month_button(e));

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        button3.addActionListener(e -> button3(e));

        //---- label6 ----
        label6.setText("\u804c\u5de5\u53f7\uff1a");

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

        //---- label8 ----
        label8.setText("\u804c\u5de5\u59d3\u540d\uff1a");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                    .addGap(128, 128, 128))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(comboBoxyear, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxday, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label8)
                        .addComponent(label6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1))
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxyear)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxmonth)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxday)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBox1)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label8)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addGap(49, 49, 49))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a\u9875");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label5 ----
            label5.setText("\u5207\u6362\u6210\u529f");
            label5.setForeground(Color.red);
            label5.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JComboBox<String> comboBoxyear;
    private JComboBox<String> comboBoxmonth;
    private JComboBox<String> comboBoxday;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JLabel label6;
    private JComboBox comboBox1;
    private JLabel label7;
    private JLabel label8;
    private JDialog dialog1;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
