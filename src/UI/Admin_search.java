/*
 * Created by JFormDesigner on Sun Oct 09 19:22:03 CST 2022
 */

package UI;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.*;


import dao.Administrator_dao;
import subject.Database;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class Admin_search extends JFrame {
    Database db = new Database();

    public Admin_search() {
        initComponents();
    }

    private void button1(ActionEvent e)  {
        try {
            String text = textField1.getText();
            Administrator_dao admin = new Administrator_dao();
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            if (comboBox1.getSelectedIndex() == 0) {
                if (text.isEmpty()) {
                    dialog1.setVisible(true);
                    return;
                }
                try (Connection c = db.getCon()) {
                    ResultSet rs = admin.SelectAdmin_byid(c, text);
                    dtm.setRowCount(0);
                    Vector<String> v = new Vector<>();
                    while (rs.next()) {
                        System.out.println("yyy");

                        v.add(rs.getString("Administrator_id"));
                        System.out.println(rs.getString("Administrator_id"));
                        v.add(rs.getString("Administrator_password"));
                        System.out.println(rs.getString("Administrator_password"));
                        v.add(rs.getString("Administrator_name"));
                        dtm.addRow(v);
                    }
                    if (v.isEmpty()) {
                        dialog2.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (comboBox1.getSelectedIndex() == 1) {
                if (text.isEmpty()) {
                    dialog1.setVisible(true);
                    return;
                }
                if (checkBox1.isSelected()) {
                    try (Connection c = db.getCon()) {
                        ResultSet rs = admin.SelectAdmin_fuzzy(c, text);
                        dtm.setRowCount(0);
                        while (rs.next()) {
                            Vector<String> v = new Vector<>();
                            v.add(rs.getString("Administrator_id"));
                            v.add(rs.getString("Administrator_password"));
                            v.add(rs.getString("Administrator_name"));
                            dtm.addRow(v);
                        }
                        if (dtm.getRowCount() == 0) {
                            dialog2.setVisible(true);
                        }
                    }

                }
                if (!checkBox1.isSelected()) {
                    try (Connection c = db.getCon()) {
                        ResultSet rs = admin.SelectAdmin_byname(c, text);
                        dtm.setRowCount(0);
                        while (rs.next()) {
                            Vector<String> v = new Vector<>();
                            v.add(rs.getString("Administrator_id"));
                            v.add(rs.getString("Administrator_password"));
                            v.add(rs.getString("Administrator_name"));
                            dtm.addRow(v);

                        }
                        if (dtm.getRowCount() == 0) dialog2.setVisible(true);
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        comboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        checkBox1 = new JCheckBox();
        dialog1 = new JDialog();
        label5 = new JLabel();
        dialog2 = new JDialog();
        label6 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "ID",
            "Name"
        }));
        comboBox1.setSelectedIndex(0);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Administrator_id", "Administrator_password", "Administrator_name"
                }
            ));
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setPreferredWidth(105);
                cm.getColumn(1).setPreferredWidth(140);
                cm.getColumn(2).setPreferredWidth(120);
            }
            table1.setFocusable(false);
            table1.setForeground(Color.black);
            table1.setAutoCreateRowSorter(true);
            table1.setCellSelectionEnabled(true);
            table1.setFillsViewportHeight(true);
            table1.setSurrendersFocusOnKeystroke(true);
            table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("\u6a21\u7cca\u67e5\u8be2\u4ec5\u652f\u6301\u6309\u7ba1\u7406\u5458\u59d3\u540d\u7684\u67e5\u8be2\u65b9\u5f0f\u3002");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        button1.addActionListener(e -> button1(e));

        //---- checkBox1 ----
        checkBox1.setText("\u6a21\u7cca\u67e5\u8be2");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)))
                            .addGap(30, 30, 30))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(checkBox1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                    .addGap(19, 19, 19)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setName("dialog1");
            dialog1.setTitle("Warning!");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label5 ----
            label5.setText("\u67e5\u8be2\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            label5.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label5.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(label5)
                        .addContainerGap(27, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("Warning!");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label6 ----
            label6.setText("\u65e0\u5339\u914d\u4fe1\u606f\uff01");
            label6.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label6.setForeground(Color.red);

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void toggleButton1StateChanged(ChangeEvent e) {
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JCheckBox checkBox1;
    private JDialog dialog1;
    private JLabel label5;
    private JDialog dialog2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
