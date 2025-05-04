/*
 * Created by JFormDesigner on Mon Oct 03 22:41:53 GMT+08:00 2022
 */

package UI;

import dao.Attendance_count_dao;
import dao.Attendance_data_dao;
import dao.Staff_dao;
import subject.Database;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author unknown
 */
public class count_by_month_hr extends JFrame {
    public static final Database db = new Database();

     Connection con=db.getCon();




    public count_by_month_hr() throws Exception {
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

    private void button1(ActionEvent e) {
        this.dispose();
    }


    private void turn_to_day_button(ActionEvent e) {
        this.dispose();
        count_by_day_hr count_by_day_hr = new count_by_day_hr();
        count_by_day_hr.setVisible(true);
        dialog1.setVisible(true);

    }

    private void flushM(ActionEvent e) {
        try {
            label3.setText("");
            String year = YearComboBoxM.getSelectedItem().toString();
            String month = MonthComboBoxM.getSelectedItem().toString();
            String s_id = (String) comboBox1.getSelectedItem();
            Attendance_count_dao attendance_count_dao = new Attendance_count_dao();
            ResultSet es = attendance_count_dao.SelectAttend_count(con, year, month, s_id);
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            Vector<String> v = null;
            model.setRowCount(0);
            while (es.next()) {
                v = new Vector<>();
                v.add(es.getString("Year"));
                v.add(es.getString("Month"));
                v.add(es.getString("S_id"));
                v.add(es.getString("D_id"));
                v.add(String.valueOf(es.getInt("Attendance")));
                v.add(String.valueOf(es.getInt("Absence")));
                v.add(String.valueOf(es.getFloat("Absence_fine")));
                v.add(String.valueOf(es.getInt("LoE")));
                v.add(String.valueOf(es.getFloat("LoE_fine")));
                v.add(String.valueOf(es.getInt("Days_personal_leave")));
                v.add(String.valueOf(es.getInt("Days_sick_leave")));
                v.add(String.valueOf(es.getFloat("Attendance_fine")));
            }
            model.addRow(v);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private void button2(ActionEvent e)  {
        try {
            String year = (String) YearComboBoxM.getSelectedItem();
            String month = (String) MonthComboBoxM.getSelectedItem();
            String date = year + "-" + month;
            String s_id = (String) comboBox1.getSelectedItem();
            Attendance_data_dao attendance_data_dao = new Attendance_data_dao();
            Attendance_count_dao attendance_count_dao = new Attendance_count_dao();
            ResultSet rs = attendance_data_dao.SelectALLAtt(con, date, s_id);
            ResultSet rs1 = attendance_data_dao.SelectALLAtt(con, date, s_id);
            if (rs1.next()) {
                attendance_count_dao.Cre_cou(con, rs);
                dialog2.setVisible(true);
            } else {
                label3.setText("当月暂无考勤数据");
                label3.setForeground(Color.red);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        toggleButton1 = new JToggleButton();
        button1 = new JButton();
        YearComboBoxM = new JComboBox<>();
        MonthComboBoxM = new JComboBox<>();
        flushM = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table2 = new JTable();
        button2 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        comboBox1 = new JComboBox();
        label7 = new JLabel();
        label8 = new JLabel();
        dialog1 = new JDialog();
        label5 = new JLabel();
        dialog2 = new JDialog();
        label6 = new JLabel();

        //======== this ========
        setTitle("\u6708\u62a5\u67e5\u8be2");
        var contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setMaximumSize(new Dimension(33340, 60000));

                //---- toggleButton1 ----
                toggleButton1.setText("\u5207\u6362\u5230\u65e5\u62a5");
                toggleButton1.addActionListener(e -> turn_to_day_button(e));

                //---- button1 ----
                button1.setText("\u8fd4\u56de");
                button1.addActionListener(e -> button1(e));

                //---- YearComboBoxM ----
                YearComboBoxM.setFont(YearComboBoxM.getFont().deriveFont(YearComboBoxM.getFont().getStyle() | Font.BOLD));
                YearComboBoxM.setModel(new DefaultComboBoxModel<>(new String[] {
                    "2022",
                    "2021",
                    "2020",
                    "2019",
                    "2018",
                    "2017",
                    "2016",
                    "2015"
                }));

                //---- MonthComboBoxM ----
                MonthComboBoxM.setModel(new DefaultComboBoxModel<>(new String[] {
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

                //---- flushM ----
                flushM.setText("\u67e5\u8be2\u62a5\u8868");
                flushM.addActionListener(e -> flushM(e));

                //---- label1 ----
                label1.setText("\u5e74");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

                //---- label2 ----
                label2.setText("\u6708");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

                //======== scrollPane1 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Year", "Month", "S_id", "D_id", "Attendance", "Absence", "Absence_fine", "LoE", "LoE_fine", "Days_personal_leave", "Days_sick_leave", "Attendance_fine"
                        }
                    ));
                    table2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                    table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    scrollPane1.setViewportView(table2);
                }

                //---- button2 ----
                button2.setText("\u751f\u6210\u62a5\u8868");
                button2.addActionListener(e -> button2(e));

                //---- label4 ----
                label4.setText("\u804c\u5de5\u53f7\uff1a");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

                //---- comboBox1 ----
                comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

                //---- label8 ----
                label8.setText("\u804c\u5de5\u59d3\u540d\uff1a");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addGap(92, 92, 92))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label8)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(YearComboBoxM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(MonthComboBoxM, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label4)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(flushM)
                            .addGap(25, 25, 25))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(YearComboBoxM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(MonthComboBoxM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2)
                                .addComponent(flushM))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(label8))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(50, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(dialogPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a\u9875");
            dialog1.setFont(new Font(Font.DIALOG, Font.ITALIC, 24));
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
                        .addGap(56, 56, 56)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a\u9875");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label6 ----
            label6.setForeground(Color.red);
            label6.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
            label6.setText("\u751f\u6210\u6210\u529f");

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JToggleButton toggleButton1;
    private JButton button1;
    private JComboBox<String> YearComboBoxM;
    private JComboBox<String> MonthComboBoxM;
    private JButton flushM;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table2;
    private JButton button2;
    private JLabel label3;
    private JLabel label4;
    private JComboBox comboBox1;
    private JLabel label7;
    private JLabel label8;
    private JDialog dialog1;
    private JLabel label5;
    private JDialog dialog2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
