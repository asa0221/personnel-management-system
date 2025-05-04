/*
 * Created by JFormDesigner on Tue Sep 27 10:14:40 CST 2022
 */

package UI;

import subject.Administraor;
import subject.Staff;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static java.sql.DriverManager.getConnection;

/**
 * @author unknown
 */
public class log extends JFrame {
    public static Staff currents = new Staff();
    public static Administraor amdin = new Administraor();
    public static int clickNo = 5;
    Connection c=getConnection();


    public log() throws SQLException {

        initComponents();

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://124.71.135.160/mysql20110106", "ms20110106", "20110106");
    }


    private void button1(ActionEvent e) {
        try {
            dialog3.setVisible(false);
            dialog4.setVisible(false);
            dialog2.setVisible(false);
            dialog1.setVisible(false);
            clickNo--;
            label8.setText("您还可以输入" + clickNo + "次。");
            label8.setForeground(Color.red);
            if (clickNo == 0) {
                this.dispose();
                dialog3.setVisible(true);
            }
            String username = textField1.getText();
            String password = new String(passwordField1.getPassword());
            if (!radioButton1.isSelected() && !radioButton2.isSelected() && !radioButton3.isSelected() && !radioButton4.isSelected()) {
                dialog4.setVisible(true);

            }
            if (username.isEmpty()) {
                dialog1.setVisible(true);
            }
            if (password.isEmpty()) {
                dialog2.setVisible(true);
            } else {
                if (radioButton1.isSelected()) {
                    String sql = "select * from Staff where S_id='" + username + "' and Password='" + password + "'";
                    System.out.println(sql);
                    try ( PreparedStatement pstmt = c.prepareStatement(sql)) {
                        ResultSet rs = pstmt.executeQuery();

                        if (rs.next()) {
                            currents.setS_id(username);
                            this.dispose();
                            new Staff_mainpage().setVisible(true);
                        } else {
                            dialog3.setVisible(true);

                        }
                    }
                }
                if (radioButton2.isSelected()) {
                    String sql = "select * from Staff where S_id='" + username + "'and Password='" + password + "'and Position='manager'";
                    System.out.println(sql);
                    try ( PreparedStatement pstmt = c.prepareStatement(sql)) {
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            currents.setS_id(username);
                            System.out.println("read");
                            this.dispose();
                            new Manager_mainpage().setVisible(true);
                        } else {
                            dialog3.setVisible(true);
                        }
                    }
                }
                if (radioButton3.isSelected()) {
                    String sql = "select *from Staff where S_id='" + username + "' and Password='" + password + "' and position='HR'";
                    try ( PreparedStatement pstmt = c.prepareStatement(sql)) {
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            currents.setS_id(username);
                            this.dispose();
                            new HR_mainpage().setVisible(true);
                        } else {
                            dialog3.setVisible(true);
                        }
                    }
                }
                if (radioButton4.isSelected()) {
                    String sql = "select * from Administrator where Administrator_id='" + username + "' and Administrator_Password='" + password + "'";
                    try ( PreparedStatement pstmt = c.prepareStatement(sql)) {
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            amdin.setAdministraor_id(username);
                            this.dispose();
                            new Administrator_mainpage().setVisible(true);
                        } else {
                            dialog3.setVisible(true);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        passwordField1 = new JPasswordField();
        label8 = new JLabel();
        dialog1 = new JDialog();
        label4 = new JLabel();
        dialog2 = new JDialog();
        label5 = new JLabel();
        dialog3 = new JDialog();
        label6 = new JLabel();
        dialog4 = new JDialog();
        label7 = new JLabel();
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("   \u767b\u5f55\u8ba4\u8bc1");
                label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
                label1.setForeground(Color.black);

                //---- label2 ----
                label2.setText("\u7528\u6237\u540d\uff1a");

                //---- label3 ----
                label3.setText("\u5bc6\u7801\uff1a");

                //---- button1 ----
                button1.setText("\u767b\u5f55");
                button1.setForeground(new Color(0x333333));
                button1.addActionListener(e -> button1(e));

                //---- radioButton1 ----
                radioButton1.setText("\u5458\u5de5");

                //---- radioButton2 ----
                radioButton2.setText("\u4e3b\u7ba1");

                //---- radioButton3 ----
                radioButton3.setText("\u4eba\u4e8b");

                //---- radioButton4 ----
                radioButton4.setText("\u7ba1\u7406\u5458");

                //---- passwordField1 ----
                passwordField1.setEchoChar('*');

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label3))
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField1, GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField1, GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(radioButton1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(radioButton2)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(radioButton3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(radioButton4))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(7, 7, 7))))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(58, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2)
                                .addComponent(radioButton3)
                                .addComponent(radioButton4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(label8)
                            .addGap(9, 9, 9))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u9519\u8bef\ud83d\ude45");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label4 ----
            label4.setText("\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            label4.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 16));
            label4.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u9519\u8bef\ud83d\ude45");
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label5 ----
            label5.setText("     \u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            label5.setFont(label5.getFont().deriveFont(Font.BOLD, label5.getFont().getSize() + 3f));
            label5.setForeground(Color.red);

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //======== dialog3 ========
        {
            dialog3.setTitle("\u9519\u8bef\ud83d\ude45");
            var dialog3ContentPane = dialog3.getContentPane();

            //---- label6 ----
            label6.setText("\u5bc6\u7801\u9519\u8bef\uff01");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() & ~Font.ITALIC, label6.getFont().getSize() + 3f));
            label6.setForeground(Color.red);

            GroupLayout dialog3ContentPaneLayout = new GroupLayout(dialog3ContentPane);
            dialog3ContentPane.setLayout(dialog3ContentPaneLayout);
            dialog3ContentPaneLayout.setHorizontalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
            );
            dialog3ContentPaneLayout.setVerticalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog3.pack();
            dialog3.setLocationRelativeTo(dialog3.getOwner());
        }

        //======== dialog4 ========
        {
            dialog4.setTitle("\u9519\u8bef\ud83d\ude45\u200d");
            var dialog4ContentPane = dialog4.getContentPane();

            //---- label7 ----
            label7.setText("\u8bf7\u9009\u62e9\u4f60\u7684\u767b\u5f55\u7c7b\u578b\uff01");
            label7.setFont(label7.getFont().deriveFont(Font.BOLD, label7.getFont().getSize() + 3f));
            label7.setForeground(Color.red);

            GroupLayout dialog4ContentPaneLayout = new GroupLayout(dialog4ContentPane);
            dialog4ContentPane.setLayout(dialog4ContentPaneLayout);
            dialog4ContentPaneLayout.setHorizontalGroup(
                dialog4ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog4ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
            );
            dialog4ContentPaneLayout.setVerticalGroup(
                dialog4ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog4ContentPaneLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(85, Short.MAX_VALUE))
            );
            dialog4.pack();
            dialog4.setLocationRelativeTo(dialog4.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JButton button1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JPasswordField passwordField1;
    private JLabel label8;
    private JDialog dialog1;
    private JLabel label4;
    private JDialog dialog2;
    private JLabel label5;
    private JDialog dialog3;
    private JLabel label6;
    private JDialog dialog4;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
