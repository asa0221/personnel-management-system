/*
 * Created by JFormDesigner on Tue Oct 04 14:29:10 CST 2022
 */

package UI;

import subject.Database;
import subject.Staff;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author unknown
 */
public class Staff_performance_fiilin extends JFrame {
    public Staff_performance_fiilin() {
        initComponents();
    }

    Staff staff = new Staff();
    Database db = new Database();

    private void button2(ActionEvent e) {
        textField1.setText("Unreviewed");
        textField2.setText("Null");
        String year = comboBox1.getSelectedItem().toString();
        String month = comboBox2.getSelectedItem().toString();
        staff.setS_id(UI.log.currents.getS_id());
        String sql = "Select * from Count_performance where Year='" + year + "' and month ='" + month + "' and S_id ='" + staff.getS_id() + "'";
        System.out.println(sql);
        try (Connection c = db.getCon(); PreparedStatement pstmt = c.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("Report"));
                v.add(rs.getString("Review"));
                v.add(rs.getString("Rate"));
                textArea1.setText(String.valueOf(v.elementAt(0)));
                textField1.setText(String.valueOf(v.elementAt(1)));
                textField2.setText(String.valueOf(v.elementAt(2)));
            } else {
                dialog1.setVisible(true);
                textArea1.setText(null);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private void button1(ActionEvent e) {
        String year = comboBox1.getSelectedItem().toString();
        String month = comboBox2.getSelectedItem().toString();
        staff.setS_id(UI.log.currents.getS_id());
        String sql = "Select * from Count_performance where Year='" + year + "' and month ='" + month + "' and S_id ='" + staff.getS_id() + "'";

        try (Connection c = db.getCon(); 
             PreparedStatement pstmt = c.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {             //之前提交过了一遍的report
                Vector<String> v = new Vector<>();
                v.add(rs.getString("Report"));
                v.add(rs.getString("Review"));
                v.add(rs.getString("Rate"));
                String view = rs.getString("Review");
                if (view.equals("Unreviewed") || view.equals("Not Pass")) {
                    String report = textArea1.getText();
                    String sql_update = "Update Count_performance set Report = ? where Year='" + year + "'and month ='" + month + "' and S_id ='" + staff.getS_id() + "'";
                    try (Connection co = db.getCon(); PreparedStatement pstmtt = co.prepareStatement(sql_update)) {
                        pstmtt.setString(1, report);
                        System.out.println(report);
                        pstmtt.executeUpdate();
                        dialog3.setVisible(true);
                    }
                } else {                          //绩效信息已经过审核，弹窗提示不可修改
                    dialog2.setVisible(true);
                    textArea1.setText(v.elementAt(0));
                }
            } else {                           //数据库中无当月信息，将文本框中的数据加入至数据库中
                String report = textArea1.getText();
                String sql_insert = "INSERT INTO Count_performance (Year, Month, S_id, Report) VALUES ('" + year + "', '" + month + "', '" + staff.getS_id() + "', '" + report + "');";
                System.out.println(sql_insert);
                try (Connection co = db.getCon(); PreparedStatement pstmttt = co.prepareStatement(sql_insert)) {
                    System.out.println(report);
                    pstmttt.executeUpdate();
                    dialog3.setVisible(true);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        comboBox1 = new JComboBox<>();
        label1 = new JLabel();
        comboBox2 = new JComboBox<>();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        dialog1 = new JDialog();
        label6 = new JLabel();
        label7 = new JLabel();
        dialog2 = new JDialog();
        label8 = new JLabel();
        label9 = new JLabel();
        dialog3 = new JDialog();
        label10 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "2020",
                    "2021",
                    "2022",
                    "2023"
                }));
                comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 4f));

                //---- label1 ----
                label1.setText("\u5e74");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));

                //---- comboBox2 ----
                comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
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
                comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 4f));

                //---- label2 ----
                label2.setText("\u6708");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));

                //---- label3 ----
                label3.setText("\u6708\u5ea6\u5de5\u4f5c\u6c47\u62a5");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setLineWrap(true);
                    scrollPane1.setViewportView(textArea1);
                }

                //---- button1 ----
                button1.setText("\u63d0\u4ea4");
                button1.addActionListener(e -> button1(e));

                //---- button2 ----
                button2.setText("\u67e5\u8be2\u5f53\u6708\u7ee9\u6548\u72b6\u6001");
                button2.addActionListener(e -> button2(e));

                //---- label4 ----
                label4.setText("\u5ba1\u6838\u72b6\u6001\uff1a");

                //---- label5 ----
                label5.setText("\u8bc4\u7ea7\uff1a");

                //---- textField1 ----
                textField1.setEditable(false);
                textField1.setEnabled(false);
                textField1.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 13));

                //---- textField2 ----
                textField2.setEditable(false);
                textField2.setEnabled(false);
                textField2.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 13));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addComponent(scrollPane1)
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(button1)
                                                .addComponent(textField2)))))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button2)
                                    .addGap(48, 48, 48))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2)
                                .addComponent(label2)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53)
                                    .addComponent(button1)))
                            .addContainerGap(16, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label6 ----
            label6.setText("\u672a\u67e5\u5230\u5f53\u6708\u7ee9\u6548\u6570\u636e   ");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

            //---- label7 ----
            label7.setText("\u8bf7\u8fd4\u56de\u4e0a\u4e00\u754c\u9762\u8f93\u5165");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label7)
                            .addComponent(label6))
                        .addContainerGap(26, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7)
                        .addContainerGap(66, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label8 ----
            label8.setText("\u7ee9\u6548\u4fe1\u606f\u5df2\u7ecf\u4e3b\u7ba1\u5ba1\u6838");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 6f));

            //---- label9 ----
            label9.setText("\u65e0\u6cd5\u4fee\u6539");
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 6f));

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialog2ContentPaneLayout.createParallelGroup()
                            .addComponent(label8)
                            .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(label9)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(label8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label9)
                        .addContainerGap(63, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //======== dialog3 ========
        {
            dialog3.setTitle("\u63d0\u793a");
            var dialog3ContentPane = dialog3.getContentPane();

            //---- label10 ----
            label10.setText("\u6570\u636e\u4e0a\u4f20\u6210\u529f");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.ITALIC, label10.getFont().getSize() + 5f));

            GroupLayout dialog3ContentPaneLayout = new GroupLayout(dialog3ContentPane);
            dialog3ContentPane.setLayout(dialog3ContentPaneLayout);
            dialog3ContentPaneLayout.setHorizontalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(label10)
                        .addContainerGap(57, Short.MAX_VALUE))
            );
            dialog3ContentPaneLayout.setVerticalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(label10)
                        .addContainerGap(87, Short.MAX_VALUE))
            );
            dialog3.pack();
            dialog3.setLocationRelativeTo(dialog3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JComboBox<String> comboBox1;
    private JLabel label1;
    private JComboBox<String> comboBox2;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JDialog dialog1;
    private JLabel label6;
    private JLabel label7;
    private JDialog dialog2;
    private JLabel label8;
    private JLabel label9;
    private JDialog dialog3;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
