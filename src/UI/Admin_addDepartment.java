/*
 * Created by JFormDesigner on Mon Oct 24 16:29:48 CST 2022
 */

package UI;

import java.awt.event.*;

import dao.Department_dao;
import dao.Staff_dao;
import subject.Database;
import subject.Department;
import subject.Staff;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Objects;
import javax.naming.Name;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Admin_addDepartment extends JFrame {
    Database db = new Database();

    public Admin_addDepartment() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        try (Connection c = db.getCon()) {
            int flag = 1;
            String name = textField1.getText();
            String d_id = textField2.getText();
            String s_id = textField3.getText();
            Department_dao department_dao = new Department_dao();
            ResultSet rs = department_dao.SelectAllDepart(c);
            if (name.isEmpty()) {
                label4.setText("部门名称不能为空");
                label4.setForeground(Color.red);
                flag = 0;
            } else label4.setText("");
            if (d_id.isEmpty()) {
                label5.setText("部门ID不能为空");
                label5.setForeground(Color.red);
                flag = 0;
            } else label4.setText("");
            while (rs.next()) {
                String cdid = rs.getString("D_id");
                if (Objects.equals(cdid, d_id)) {
                    label5.setText("部门ID已被使用");
                    label5.setForeground(Color.red);
                    flag = 0;
                    break;
                }
            }
            Department department = new Department();
            department.setD_name(name);
            department.setD_id(d_id);
            if (flag == 1) {
                if (s_id.isEmpty()) {
                    department_dao.AddDepart(c, department);
                    this.dispose();
                    dialog1.setVisible(true);
                } else {
                    Staff_dao staff_dao = new Staff_dao();
                    ResultSet rs1 = staff_dao.SelectStaff(c, s_id);
                    String did = department_dao.SelectDepartby_S_idToD_id(c, s_id);
                    System.out.println(did);
                    if (rs1.next()) {
                        if (did == null) {
                            String sname = rs1.getString("Name");
                            department.setS_id(s_id);
                            department.setName(sname);
                            department_dao.AddDepart(c, department);
                            Staff staff = new Staff();
                            staff.setS_id(rs1.getString("S_id"));
                            staff.setName(rs1.getString("Name"));
                            staff.setSex(rs1.getString("Sex"));
                            staff.setD_id(d_id);
                            staff.setPosition("manager");
                            staff.setAge(rs1.getString("Age"));
                            staff.setTelephone(rs1.getString("Telephone"));
                            staff.setEmail(rs1.getString("Email"));
                            staff.setAddress(rs1.getString("Address"));
                            staff.setPassword(rs1.getString("Password"));
                            staff.setState(rs1.getString("State"));
                            staff_dao.MOdifyStaff(c, staff);
                            this.dispose();
                            dialog1.setVisible(true);
                        }else {
                            label6.setText("此员工已经为主管");
                            label6.setForeground(Color.red);
                        }
                    } else {
                        label6.setText("员工ID不存在");
                        label6.setForeground(Color.red);
                    }
                }
            }

        } catch (
                Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        button1 = new JButton();
        label7 = new JLabel();
        dialog1 = new JDialog();
        label21 = new JLabel();

        //======== this ========
        setTitle("\u589e\u52a0\u90e8\u95e8");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u90e8\u95e8\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u90e8\u95e8\u7f16\u53f7\uff1a");

        //---- label3 ----
        label3.setText("\u90e8\u95e8\u4e3b\u7ba1ID\uff1a");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1(e));

        //---- label7 ----
        label7.setText("\u6ce8\u610f\uff1a\u6b64\u4e3b\u7ba1\u6240\u5c5e\u90e8\u95e8\u4e5f\u5c06\u5f97\u5230\u8f6c\u53d8");
        label7.setForeground(new Color(0x0000cc));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button1)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label7)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label21 ----
            label21.setText("  \u90e8\u95e8\u589e\u52a0\u6210\u529f\uff01");
            label21.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label21.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label21)
                        .addContainerGap(27, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label21, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton button1;
    private JLabel label7;
    private JDialog dialog1;
    private JLabel label21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
