/*
 * Created by JFormDesigner on Mon Oct 03 22:41:53 GMT+08:00 2022
 */

package UI;

import dao.Attendance_count_dao;
import dao.Attendance_data_dao;
import subject.Database;
import subject.Staff;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author unknown
 */
public class count_by_month extends JFrame {
    public static final Database db = new Database();

    public static final Connection con;


    static {
        try {
            con = db.getCon();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public count_by_month() {
        initComponents();

    }

    private void button1(ActionEvent e) {
        this.dispose();
    }


    private void turn_to_day_button(ActionEvent e) {
        this.dispose();
        count_by_day count_by_day = new count_by_day();
        count_by_day.setVisible(true);
        dialog1.setVisible(true);

    }

    private void flushM(ActionEvent e) {
        try {
            label3.setText("");
            String year = YearComboBoxM.getSelectedItem().toString();
            String month = MonthComboBoxM.getSelectedItem().toString();
            String s_id = UI.log.currents.getS_id();
            Attendance_count_dao attendance_count_dao = new Attendance_count_dao();
            ResultSet es = attendance_count_dao.SelectAttend_count(con, year, month, s_id);
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            Vector<String>v=new Vector<>();
            model.setRowCount(0);
            while (es.next()) {
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
            if (v.isEmpty()){
                label3.setText("当月暂无考勤数据");
                label3.setForeground(Color.red);
            }
            model.addRow(v);
        } catch (Exception se) {
            se.printStackTrace();
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
        label3 = new JLabel();
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

                //---- label2 ----
                label2.setText("\u6708");

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(YearComboBoxM, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(MonthComboBoxM, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addGap(59, 59, 59)
                            .addComponent(flushM, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(YearComboBoxM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(MonthComboBoxM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(flushM))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addGap(19, 19, 19)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(65, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JLabel label3;
    private JDialog dialog1;
    private JLabel label5;
    private JDialog dialog2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
