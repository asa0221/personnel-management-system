/*
 * Created by JFormDesigner on Thu Oct 20 22:00:36 CST 2022
 */

package UI;

import dao.Administrator_dao;
import dao.Staff_dao;
import subject.Database;
import subject.Staff;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Staff_password extends JFrame {
    Database db = new Database();

    public Staff_password() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        try (Connection c = db.getCon()) {
            String S_id = UI.log.currents.getS_id();
            System.out.println(S_id);
            String old_password = textField1.getText();
            String new_password = new String(passwordField1.getPassword());
            String re_password = new String(passwordField2.getPassword());
            Staff_dao staff_dao = new Staff_dao();
            ResultSet resultSet = staff_dao.SelectStaff(c, S_id);
            String told_password = null;
            if (resultSet.next()) {
                told_password = resultSet.getString("Password");
                System.out.println(told_password);
            }
            int flag=0;
            if (!old_password.equals(told_password)){
                flag=3;
            }
            if (old_password.isEmpty()){
                flag=1;
            }
            if (old_password.equals(told_password)){
                flag=2;
            }
            if (flag==1){
                label4.setText("密码不能为空！");
                label4.setForeground(Color.red);
            }
            if (flag==3){
                label4.setText("原密码输入错误！");
                label4.setForeground(Color.red);
            }
            if (flag==2){
                label4.setText("");
            }
            int flag1=0;
            int flag2=0;
            if (new_password.equals(re_password)){
                flag1=2;
            }else {
                flag1=3;
            }
            if (new_password.isEmpty()){
                flag1=1;
            }
            if (re_password.isEmpty()){
                flag2=1;
            }
            if (flag1==3){
                label5.setText("");
                label6.setText("两次输入密码不一致！");
                label6.setForeground(Color.red);
            }
            if (flag1==1){
                label5.setText("新密码不能为空！");
                label5.setForeground(Color.red);
            }
            if (flag2==1){
                label6.setText("重复密码不能为空！");
                label6.setForeground(Color.red);
            }
            if (flag1==2){
                label5.setText("");
                label6.setText("");
                if (flag==2){
                    staff_dao.Change_staffP(c, new_password, S_id);
                    this.dispose();
                    dialog1.setVisible(true);

                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        dialog1 = new JDialog();
        label7 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u539f\u5bc6\u7801\uff1a");

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801\uff1a");

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label6, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                    .addGap(24, 24, 24))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(157, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label6)
                    .addGap(31, 31, 31)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label7 ----
            label7.setText("\u5bc6\u7801\u66f4\u6539\u6210\u529f\uff01");
            label7.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label7.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addContainerGap())
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(87, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JDialog dialog1;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
