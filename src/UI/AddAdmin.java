/*
 * Created by JFormDesigner on Tue Oct 04 16:01:31 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.net.IDN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import subject.Database;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AddAdmin extends JFrame {
    Database db = new Database();

    public AddAdmin() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        try {
            int flag = 0;
            label6.setText("");
            label5.setText("");
            label7.setText("");
            label8.setText("");
            String id = textField1.getText();
            String password = new String(passwordField1.getPassword());
            String repassword = new String(passwordField2.getPassword());
            String name = textField2.getText();
            if (id.isEmpty()) {
                label5.setText("请输入id信息");
                label5.setForeground(Color.red);
                flag = 1;
            }
            if (password.isEmpty()) {
                label6.setText("请输入密码信息");
                label6.setForeground(Color.red);
                flag = 1;

            }
            if (repassword.isEmpty()) {
                label7.setText("请输入确认密码");
                label7.setForeground(Color.red);
                flag = 1;
            }
            if (!password.equals(repassword)) {
                label7.setText("两次输入密码不一致");
                label7.setForeground(Color.red);
                flag = 1;
            }
            if (name.isEmpty()) {
                label8.setText("请输入姓名信息");
                label8.setForeground(Color.red);
                flag = 1;
            }

            String sql = "insert into Administrator values('" + id + "','" + password + "','" + name + "');";
            String sql1 = "select Administrator_id from Administrator where Administrator_id='" + id + "';";
            System.out.println(sql);
            System.out.println(sql1);
            try (Connection c = new Database().getCon(); PreparedStatement pstmt = c.prepareStatement(sql); PreparedStatement pstmt2 = c.prepareStatement(sql1)) {
                ResultSet rs = pstmt2.executeQuery();
                if (rs.next()) {
                    label5.setText("id信息已存在");
                    label5.setForeground(Color.red);
                    flag = 1;
                }
                if (flag == 0) {
                    pstmt.executeUpdate();
                    this.dispose();
                    dialog6.setVisible(true);
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button2(ActionEvent e) {
        try {
            this.dispose();
            new A_information().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        textField2 = new JTextField();
        label4 = new JLabel();
        button1 = new JButton();
        passwordField2 = new JPasswordField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        dialog6 = new JDialog();
        label10 = new JLabel();
        button2 = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u7ba1\u7406\u5458\u4fe1\u606f");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("ID\uff1a");

        //---- label2 ----
        label2.setText("Password\uff1a");

        //---- label3 ----
        label3.setText("Name\uff1a");

        //---- label4 ----
        label4.setText("Re-password:");

        //---- button1 ----
        button1.setText("Regist");
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                                        .addGap(60, 60, 60)
                                                                        .addComponent(label1)
                                                                        .addGap(36, 36, 36))
                                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label2)
                                                                        .addGap(32, 32, 32)))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(label3)
                                                                        .addComponent(label4))
                                                                .addGap(38, 38, 38)))
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label7)
                                                        .addComponent(label6)
                                                        .addComponent(label5)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                                .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label8)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(159, 159, 159)
                                                .addComponent(button1)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(label8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1)
                                .addGap(17, 17, 17))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog6 ========
        {
            dialog6.setTitle("succes\uff01");
            var dialog6ContentPane = dialog6.getContentPane();

            //---- label10 ----
            label10.setText("\u7ba1\u7406\u5458\u6dfb\u52a0\u6210\u529f\uff01");
            label10.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label10.setForeground(Color.red);

            //---- button2 ----
            button2.setText("OK");
            button2.addActionListener(e -> button2(e));

            GroupLayout dialog6ContentPaneLayout = new GroupLayout(dialog6ContentPane);
            dialog6ContentPane.setLayout(dialog6ContentPaneLayout);
            dialog6ContentPaneLayout.setHorizontalGroup(
                    dialog6ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog6ContentPaneLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(21, 21, 21))
                            .addGroup(dialog6ContentPaneLayout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(button2)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            dialog6ContentPaneLayout.setVerticalGroup(
                    dialog6ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog6ContentPaneLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(button2)
                                    .addContainerGap(32, Short.MAX_VALUE))
            );
            dialog6.pack();
            dialog6.setLocationRelativeTo(dialog6.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void radioButton1(ActionEvent e) {
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JLabel label4;
    private JButton button1;
    private JPasswordField passwordField2;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JDialog dialog6;
    private JLabel label10;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
