/*
 * Created by JFormDesigner on Tue Oct 11 13:35:53 GMT+08:00 2022
 */

package UI;

import dao.Salary_dao;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author unknown
 */
public class salary_for_Staff extends JFrame {
    public static final Database db = new Database();

    public static final Connection con;

    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String S_id = UI.log.currents.getS_id();

    public salary_for_Staff() {
        initComponents();
    }


    private void button1(ActionEvent e) {
        try {
            label1.setText("");
            String Year = comboBox2.getSelectedItem().toString();
            String Month = comboBox3.getSelectedItem().toString();
            Salary_dao salary_dao = new Salary_dao();
            ResultSet es = salary_dao.select_salary(con, Year, Month, S_id);
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            Vector<String> v = null;
            if (es.next()) {
                v = new Vector<>();
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
            } else {
                label1.setText("暂无当月工资信息");
                label1.setForeground(Color.red);
            }
            model.addRow(v);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private void button3(ActionEvent e) {
        try (Connection c = db.getCon()) {
            Salary_photo salaryphoto =new Salary_photo(c,comboBox2.getSelectedItem().toString(),S_id);
            JFrame frame =new JFrame("月度部门员工奖金提成柱状统计");
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
        label1 = new JLabel();

        //======== this ========
        setTitle("\u5458\u5de5\u6708\u5de5\u8d44\u67e5\u8be2");
        var contentPane = getContentPane();

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
            "12"
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addGap(118, 118, 118))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4)
                                .addGap(54, 54, 54)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox3))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 9, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                            .addGap(8, 8, 8)))
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
