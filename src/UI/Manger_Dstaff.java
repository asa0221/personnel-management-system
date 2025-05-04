/*
 * Created by JFormDesigner on Sun Oct 23 23:04:12 CST 2022
 */

package UI;

import dao.Department_dao;
import subject.Database;

import java.awt.*;
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
public class Manger_Dstaff extends JFrame {
    Database db = new Database();

    public Manger_Dstaff() {
        initComponents();
        fillIn();
    }

    public void fillIn() {
        try (Connection c = db.getCon()) {
            String S_id = UI.log.currents.getS_id();
            Department_dao department_dao = new Department_dao();
            String D_id = department_dao.SelectDepartby_S_idToD_id(c, S_id);
            System.out.println(D_id);
            ResultSet rs=department_dao.SelectDepartby_D_id(c,D_id);
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
                System.out.println("kk");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("\u90e8\u95e8\u6210\u5458\u4fe1\u606f");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "S_id", "Name", "Sex", "D_id", "Position", "Age", "Telephone", "Email", "Address", "State"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, true, true, true, true, true, true
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.setAutoCreateRowSorter(true);
            table1.setFillsViewportHeight(true);
            table1.setDoubleBuffered(true);
            table1.setDragEnabled(true);
            table1.setPreferredScrollableViewportSize(new Dimension(491, 400));
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table1.setAlignmentX(5.0F);
            table1.setSurrendersFocusOnKeystroke(true);
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
