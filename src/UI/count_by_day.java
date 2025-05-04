/*
 * Created by JFormDesigner on Tue Oct 04 11:46:19 GMT+08:00 2022
 */

package UI;

import dao.Attendance_data_dao;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author unknown
 */
public class count_by_day extends JFrame {
    public static final Database db = new Database();

    public static final Connection con;

    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public count_by_day() {
        initComponents();
    }


    private void checkMouseClicked(MouseEvent e) {
        try {
            label4.setText("");
            String year = comboBoxyear.getSelectedItem().toString();
            String month = comboBoxmonth.getSelectedItem().toString();
            String day = comboBoxday.getSelectedItem().toString();
            String date = year + "-" + month + "-" + day;
            String s_id = UI.log.currents.getS_id();
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
        this.dispose();
        count_by_month count_by_month = new count_by_month();
        count_by_month.setVisible(true);
        dialog1.setVisible(true);
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
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(comboBoxyear, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(comboBoxmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBoxday, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(98, 98, 98))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(310, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxyear, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxmonth, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxday, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
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
                        .addContainerGap(105, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(72, Short.MAX_VALUE))
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
    private JDialog dialog1;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
