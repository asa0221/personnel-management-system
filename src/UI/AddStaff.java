/*
 * Created by JFormDesigner on Tue Oct 11 10:36:29 CST 2022
 */

package UI;

import com.mysql.cj.exceptions.ConnectionIsClosedException;
import dao.Department_dao;
import dao.Staff_dao;
import subject.Database;
import subject.Staff;

import java.awt.*;
import java.awt.event.*;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AddStaff extends JFrame {
    Database db = new Database();
    Connection c=db.getCon();

    public AddStaff() throws Exception {
        initComponents();
        comboBox2();
    }

    private void button1(ActionEvent e)  {
        try {
            Connection c = db.getCon();
            int flag = 1;
            String s_id = textField1.getText();
            String name = textField2.getText();
            String age = textField5.getText();
            String tele = textField6.getText();
            String email = textField7.getText();
            String address = textField8.getText();
            String password = textField9.getText();
            String sex = "M";
            String d_id = "01";
            String position = "employee";
            String state = "yes";
            if (comboBox1.getSelectedIndex() == 1) {
                sex = "F";
            }
            if (comboBox2.getSelectedIndex() == 0) {
                d_id = "01";
            }
            if (comboBox2.getSelectedIndex() == 1) {
                d_id = "02";
            }
            if (comboBox2.getSelectedIndex() == 2) {
                d_id = "03";
            }
            if (comboBox2.getSelectedIndex() == 3) {
                d_id = "04";
            }
            if (comboBox2.getSelectedIndex() == 5) {
                d_id = "05";
            }
            if (comboBox3.getSelectedIndex() == 1) {
                position = "manager";
            }
            if (comboBox3.getSelectedIndex() == 2) {
                position = "HR";
            }
            if (comboBox4.getSelectedIndex() == 1) {
                state = "no";
            }
            Staff staff = new Staff();
            staff.setS_id(s_id);
            staff.setName(name);
            staff.setSex(sex);
            staff.setD_id(d_id);
            staff.setPosition(position);
            staff.setAge(age);
            staff.setTelephone(tele);
            staff.setEmail(email);
            staff.setAddress(address);
            staff.setPassword(password);
            staff.setState(state);
            if (s_id.isEmpty()) {
                label12.setText("员工id不能为空！");
                label12.setForeground(Color.red);
                flag = 0;
            }
            if (name.isEmpty()) {
                label13.setText("员工姓名不能为空！");
                label13.setForeground(Color.red);
                flag = 0;
            }
            if (age.isEmpty()) {
                label14.setText("员工年龄不能为空！");
                label14.setForeground(Color.red);
                flag = 0;
            }
            if (tele.isEmpty()) {
                label15.setText("员工电话不能为空！");
                label15.setForeground(Color.red);
                flag = 0;
            }
            if (email.isEmpty()) {
                label16.setText("员工邮箱不能为空！");
                label16.setForeground(Color.red);
                flag = 0;
            }
            if (address.isEmpty()) {
                label17.setText("员工地址不能为空！");
                label17.setForeground(Color.red);
                flag = 0;
            }
            if (password.isEmpty()) {
                label18.setText("员工密码不能为空！");
                label18.setForeground(Color.red);
                flag = 0;
            }
            Staff_dao staff_dao = new Staff_dao();
            ResultSet compareid = staff_dao.SelectStaff(c, s_id);
            if (compareid.next()) {
                label12.setText("员工id已存在！");
                label12.setForeground(Color.red);
                flag = 0;
            }
            if (flag == 1) {
                staff_dao.AddStaff(c, staff);
                this.dispose();
                new Admin_Control().setVisible(true);
                dialog1.setVisible(true);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void comboBox2() {
        try(Connection c= db.getCon()) {
            Department_dao department_dao=new Department_dao();
            ResultSet resultSet=department_dao.SelectAllDepart(c);
            Vector<String>v=new Vector<>();
            while (resultSet.next()){
                v.add(resultSet.getString("D_id"));
            }
            comboBox2.setModel(new DefaultComboBoxModel(v));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        try {String did= (String) comboBox2.getSelectedItem();
            Department_dao department_dao=new Department_dao();
            String dname=department_dao.didTansdname(c,did);
            label20.setText(dname);
            label20.setForeground(Color.blue);
        } catch (Exception ex) {
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
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox();
        comboBox3 = new JComboBox<>();
        button1 = new JButton();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        label11 = new JLabel();
        comboBox4 = new JComboBox<>();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label20 = new JLabel();
        dialog1 = new JDialog();
        label19 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("S_id");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 1f));

        //---- label2 ----
        label2.setText("Name");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 1f));

        //---- label3 ----
        label3.setText("Sex");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 1f));

        //---- label4 ----
        label4.setText("D_id");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 1f));

        //---- label5 ----
        label5.setText("Position");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 1f));

        //---- label6 ----
        label6.setText("Age");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 1f));

        //---- label7 ----
        label7.setText("Tele");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 1f));

        //---- label8 ----
        label8.setText("Email");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 1f));

        //---- label9 ----
        label9.setText("Address");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 1f));

        //---- label10 ----
        label10.setText("Password");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 1f));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "M",
            "F"
        }));

        //---- comboBox2 ----
        comboBox2.addItemListener(e -> {
			comboBox2ItemStateChanged(e);
			comboBox2ItemStateChanged(e);
		});

        //---- comboBox3 ----
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
            "employee",
            "manager",
            "HR"
        }));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1(e));

        //---- label11 ----
        label11.setText("State");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 1f));

        //---- comboBox4 ----
        comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
            "yes",
            "no"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label4)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 186, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label13, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                            .addGap(84, 84, 84))
                        .addComponent(label12, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addGap(47, 47, 47)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label20, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))))
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField6)))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label8)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textField7)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label9, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label17, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(label16, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(textField8, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label10)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label18, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(textField9, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(51, 51, 51)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label12)
                                .addComponent(label14))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(2, 2, 2)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label13)
                                .addComponent(label15))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label8)
                                    .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label3)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label16)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label17)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label10)
                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(label18)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label11)))
                            .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 73, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful!");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label19 ----
            label19.setText("\u5458\u5de5\u4fe1\u606f\u6dfb\u52a0\u6210\u529f\uff01");
            label19.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label19.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label19)
                        .addContainerGap(12, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label19, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
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
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JComboBox<String> comboBox1;
    private JComboBox comboBox2;
    private JComboBox<String> comboBox3;
    private JButton button1;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JLabel label11;
    private JComboBox<String> comboBox4;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label20;
    private JDialog dialog1;
    private JLabel label19;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
