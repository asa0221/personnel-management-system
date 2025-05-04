/*
 * Created by JFormDesigner on Tue Oct 11 14:29:41 CST 2022
 */

package UI;


import dao.Department_dao;
import subject.Database;
import subject.Department;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
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
public class Manager_perfomance extends JFrame {
    public Manager_perfomance() {
        initComponents();
    }

    Department de = new Department();
    Database db = new Database();
    public static String S_id;
    public static String name;
    public static String year;
    public static String month;

    private void button1(ActionEvent e) {
        try (Connection c = db.getCon()) {
            label1.setText("");
            String year = comboBox3.getSelectedItem().toString();
            String month = comboBox4.getSelectedItem().toString();
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            Department_dao department_dao = new Department_dao();
            String S_id = UI.log.currents.getS_id();
            String D_id = department_dao.SelectDepartby_S_idToD_id(c, S_id);
            de.setD_id(D_id);
            String sql_1 = "SELECT * FROM Count_performance c INNER JOIN Staff s on c.S_id=s.S_id WHERE Year ='" + year + "' and month= '" + month + "' and D_id='" + de.getD_id() + "'";
            System.out.println(sql_1);
            PreparedStatement pstmt = c.prepareStatement(sql_1);
            ResultSet rs = pstmt.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("S_id"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Review"));
                v.add(rs.getString("Rate"));
                dtm.addRow(v);
            }
            if (dtm.getRowCount() == 0) {
                label1.setText("当月暂无绩效信息");
                label1.setForeground(Color.red);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void button2(ActionEvent e) {
        try {
            int row = table1.getSelectedRow();
            if (row == -1) {
                label1.setText("请选择要审核对象");
                label1.setForeground(Color.red);
            } else {
                S_id = (String) table1.getValueAt(row, 0);
                name = (String) table1.getValueAt(row, 1);
                year = (String) comboBox3.getSelectedItem();
                month = (String) comboBox4.getSelectedItem();
                String review = (String) table1.getValueAt(row, 2);
                if (review.equals("Pass")) {
                    label1.setText("此绩效已通过");
                    label1.setForeground(Color.red);
                } else {
                    new Manger_review_rate().setVisible(true);
                }
            }
        } catch (
                RuntimeException ex) {
            throw new RuntimeException(ex);
        }

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label3 = new JLabel();
        label4 = new JLabel();
        comboBox3 = new JComboBox<>();
        comboBox4 = new JComboBox<>();
        button1 = new JButton();
        label1 = new JLabel();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5458\u5de5\u7ee9\u6548");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "S_id", "\u540d\u5b57", "\u5ba1\u6838\u72b6\u6001", "\u8bc4\u7ea7"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.setSelectionForeground(Color.black);
            table1.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent e) {
                    table1AncestorAdded(e);
                }
                @Override
                public void ancestorMoved(AncestorEvent e) {}
                @Override
                public void ancestorRemoved(AncestorEvent e) {}
            });
            scrollPane1.setViewportView(table1);
        }

        //---- label3 ----
        label3.setText("\u5e74");

        //---- label4 ----
        label4.setText("\u6708");

        //---- comboBox3 ----
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
            "2020",
            "2021",
            "2022",
            "2023"
        }));

        //---- comboBox4 ----
        comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
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

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

        //---- button2 ----
        button2.setText("\u5ba1\u6838 \u8bc4\u7ea7");
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addGap(28, 28, 28)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(label1)
                            .addComponent(button1)
                            .addComponent(button2)))
                    .addGap(12, 12, 12)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void table1AncestorAdded(AncestorEvent e) {
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label3;
    private JLabel label4;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
