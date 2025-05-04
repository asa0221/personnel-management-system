/*
 * Created by JFormDesigner on Mon Oct 03 21:09:19 CST 2022
 */

package UI;


import java.awt.event.*;
import javax.swing.table.*;

import UI.Admin_search;
import UI.Administrator_mainpage;
import dao.Administrator_dao;
import dao.ControlObject;
import subject.Database;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.concurrent.locks.Condition;

public class A_information extends JFrame {
    Database db = new Database();


    public A_information() throws Exception {
        initComponents();
        fillTable();
    }

    private void fillTable() throws Exception {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        Connection con = db.getCon();
        Administrator_dao admin = new Administrator_dao();
        ResultSet rs = admin.selectallAdmin(con);
        while (rs.next()) {
            Vector<String> v = new Vector<>();
            v.add(rs.getString("Administrator_id"));
            v.add(rs.getString("Administrator_password"));
            v.add(rs.getString("Administrator_name"));
            dtm.addRow(v);
        }



    }

    private void button1(ActionEvent e) {
        this.dispose();
        new Administrator_mainpage().setVisible(true);
    }

    private void button2(ActionEvent e) {
        this.dispose();
        new Admin_search().setVisible(true);
    }


    private void initComponents() throws Exception {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u4fe1\u606f\u8868");
        var contentPane = getContentPane();

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
            table1.setEnabled(false);
            table1.setFocusable(false);
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("\u4fe1\u606f\u67e5\u627e");
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(button2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(51, 51, 51))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

