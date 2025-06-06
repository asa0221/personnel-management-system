/*
 * Created by JFormDesigner on Tue Oct 18 08:49:33 CST 2022
 */

package UI;

import dao.Staff_dao;
import subject.Database;
import subject.Staff;

import java.awt.*;
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
public class Admin_Deletebyid extends JFrame {
    Database db = new Database();
    public static Staff staff = new Staff();

    public Admin_Deletebyid() {
        initComponents();
    }

    private void button2(ActionEvent e) {
        String ID = textField1.getText();
        Staff_dao staff_dao = new Staff_dao();
        staff.setS_id(ID);

        try (Connection c = db.getCon()) {
            ResultSet rs = staff_dao.SelectStaff(c, ID);
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
                System.out.println("考虑");
                dtm.addRow(v);

            }
            if (dtm.getRowCount() == 0) {
                dialog2.setVisible(true);
            } else {
                //this.dispose();
                frame1.setVisible(true);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private void button1(ActionEvent e) {
        Staff_dao staff_dao=new Staff_dao();
        try (Connection c=db.getCon()){
            staff_dao.DeleteStaff(c,staff.getS_id());
            this.dispose();
            frame1.dispose();
            new Admin_Control().setVisible(true);
            dialog1.setVisible(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        frame1 = new JFrame();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        dialog1 = new JDialog();
        label21 = new JLabel();
        dialog2 = new JDialog();
        label22 = new JLabel();

        //======== this ========
        setTitle("\u8f93\u5165\u60f3\u8981\u5220\u9664\u5458\u5de5\u7684\u804c\u5de5\u53f7");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("ID\uff1a");

        //---- button2 ----
        button2.setText("\u67e5\u627e");
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(button2)))
                    .addContainerGap(26, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            frame1.setTitle("\u641c\u7d22\u7ed3\u679c");
            var frame1ContentPane = frame1.getContentPane();

            //======== scrollPane1 ========
            {

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

            //---- button1 ----
            button1.setText("\u786e\u8ba4\u5220\u9664");
            button1.addActionListener(e -> button1(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(button1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1)
                        .addGap(0, 9, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful\uff01");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label21 ----
            label21.setText("\u5458\u5de5\u4fe1\u606f\u5220\u9664\u6210\u529f\uff01");
            label21.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label21.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label21)
                        .addContainerGap(12, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(label21, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("Waring!");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label22 ----
            label22.setText("\u5458\u5de5\u4e0d\u5b58\u5728\uff01");
            label22.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label22.setForeground(Color.red);

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label22)
                        .addContainerGap(43, Short.MAX_VALUE))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(label22, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button2;
    private JFrame frame1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JDialog dialog1;
    private JLabel label21;
    private JDialog dialog2;
    private JLabel label22;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
