/*
 * Created by JFormDesigner on Tue Oct 11 08:46:14 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;

import dao.Administrator_dao;
import dao.Department_dao;
import dao.Staff_dao;
import subject.Database;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author unknown
 */
public class Admin_Control extends JFrame {
    Database db = new Database();
    Staff_dao staff_dao = new Staff_dao();

    public Admin_Control() throws Exception {
        initComponents();
        fillTable();
    }

    private void menuItem1(ActionEvent e)  {
        try {
            dialog1.setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button1(ActionEvent e)  {
        try {
            String id = textField1.getText();
            ResultSet rs = staff_dao.SelectStaff(db.getCon(), id);
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            if (rs.next()) {
                dtm.setRowCount(0);
                Vector<String> v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dtm.addRow(v);
                dialog1.setVisible(false);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void menuItem2(ActionEvent e) {
        try {
            dialog2.setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button2(ActionEvent e)  {
        try {
            String name = textField2.getText();
            ResultSet rs = staff_dao.SelectStaff_byname(db.getCon(), name);
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            if (rs.next()) {
                dtm.setRowCount(0);
                Vector<String> v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dtm.addRow(v);
                dialog2.setVisible(false);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem3(ActionEvent e) {
        try {
            this.dispose();
            new AddStaff().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void menuItem4(ActionEvent e) {
        try {
            this.dispose();
            new Admin_Modifybyid().setVisible(true);
        } catch (Exception ex) {
        }
    }

    private void menuItem5(ActionEvent e) {
        try {
            this.dispose();
            new Admin_Modifybyname().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem6(ActionEvent e) {
        try {
            this.setVisible(false);
            new Admin_Deletebyid().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem7(ActionEvent e) {
        try {
            this.setVisible(false);
            new Admin_Deletebyname().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem8(ActionEvent e) {
        try {dialog3.setVisible(true);
    
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button3(ActionEvent e) {
        try (Connection c=db.getCon()){
            String D_id = textField3.getText();
            Department_dao department_dao=new Department_dao();
            ResultSet rs = department_dao.SelectDepartby_D_id(c,D_id);
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dtm.addRow(v);
                dialog3.setVisible(false);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        dialog1 = new JDialog();
        textField1 = new JTextField();
        button1 = new JButton();
        dialog2 = new JDialog();
        textField2 = new JTextField();
        button2 = new JButton();
        dialog3 = new JDialog();
        textField3 = new JTextField();
        button3 = new JButton();

        //======== this ========
        setTitle("\u5458\u5de5\u4fe1\u606f\u8868");
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u67e5\u627e");

                //---- menuItem1 ----
                menuItem1.setText("\u901a\u8fc7\u804c\u5de5\u53f7\u67e5\u627e");
                menuItem1.addActionListener(e -> {
                    try {
                        menuItem1(e);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u901a\u8fc7\u4eba\u540d\u67e5\u627e");
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem8 ----
                menuItem8.setText("\u901a\u8fc7\u90e8\u95e8\u67e5\u627e");
                menuItem8.addActionListener(e -> menuItem8(e));
                menu1.add(menuItem8);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u589e\u52a0");

                //---- menuItem3 ----
                menuItem3.setText("\u589e\u52a0\u5458\u5de5\u4fe1\u606f");
                menuItem3.addActionListener(e -> menuItem3(e));
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u4fee\u6539");

                //---- menuItem4 ----
                menuItem4.setText("\u901a\u8fc7\u804c\u5de5\u53f7\u4fee\u6539");
                menuItem4.addActionListener(e -> menuItem4(e));
                menu3.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u901a\u8fc7\u4eba\u540d\u4fee\u6539");
                menuItem5.addActionListener(e -> menuItem5(e));
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u5220\u9664");

                //---- menuItem6 ----
                menuItem6.setText("\u901a\u8fc7\u804c\u5de5\u53f7\u5220\u9664");
                menuItem6.addActionListener(e -> menuItem6(e));
                menu4.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u901a\u8fc7\u4eba\u540d\u5220\u9664");
                menuItem7.addActionListener(e -> menuItem7(e));
                menu4.add(menuItem7);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setAutoscrolls(true);
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "S_id", "Name", "Sex", "D_id", "Position", "Age", "Telephone", "Email", "Address", "Password", "State"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.setFillsViewportHeight(true);
            table1.setRowSelectionAllowed(false);
            table1.setShowHorizontalLines(false);
            table1.setShowVerticalLines(false);
            table1.setPreferredScrollableViewportSize(new Dimension(474, 400));
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table1.setAutoCreateRowSorter(true);
            table1.setDoubleBuffered(true);
            table1.setDragEnabled(true);
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGap(21, 21, 21))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u8f93\u5165\u804c\u5de5\u53f7");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(e -> button1(e));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(button1)
                        .addContainerGap(76, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(10, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u8f93\u5165\u4eba\u540d");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- button2 ----
            button2.setText("\u786e\u5b9a");
            button2.addActionListener(e -> {
                try {
                    button2(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(button2)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button2)
                        .addContainerGap(10, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //======== dialog3 ========
        {
            dialog3.setTitle("\u8f93\u5165\u90e8\u95e8\u53f7");
            var dialog3ContentPane = dialog3.getContentPane();

            //---- button3 ----
            button3.setText("\u786e\u5b9a");
            button3.addActionListener(e -> {
			button3(e);
		});

            GroupLayout dialog3ContentPaneLayout = new GroupLayout(dialog3ContentPane);
            dialog3ContentPane.setLayout(dialog3ContentPaneLayout);
            dialog3ContentPaneLayout.setHorizontalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(button3)
                        .addContainerGap(76, Short.MAX_VALUE))
            );
            dialog3ContentPaneLayout.setVerticalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button3)
                        .addContainerGap(10, Short.MAX_VALUE))
            );
            dialog3.pack();
            dialog3.setLocationRelativeTo(dialog3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void fillTable() throws Exception {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        Connection con = db.getCon();
        Staff_dao staff_dao = new Staff_dao();
        ResultSet rs = staff_dao.selectallStaff(con);
        while (rs.next()) {
            Vector<String> v = new Vector<>();
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getString(5));
            v.add(rs.getString(6));
            v.add(rs.getString(7));
            v.add(rs.getString(8));
            v.add(rs.getString(9));
            v.add(rs.getString(10));
            v.add(rs.getString(11));
            dtm.addRow(v);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem8;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JDialog dialog1;
    private JTextField textField1;
    private JButton button1;
    private JDialog dialog2;
    private JTextField textField2;
    private JButton button2;
    private JDialog dialog3;
    private JTextField textField3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
