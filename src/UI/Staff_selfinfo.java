/*
 * Created by JFormDesigner on Thu Oct 20 21:59:38 CST 2022
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
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Staff_selfinfo extends JFrame {
    Database db = new Database();

    public Staff_selfinfo() {
        initComponents();
        infofillin();
    }

    public void infofillin() {
        try (Connection c = db.getCon()) {
            String S_id = UI.log.currents.getS_id();
            Staff_dao staff_dao = new Staff_dao();
            ResultSet rs = staff_dao.SelectStaff(c, S_id);
            if (rs.next()) {
                textField1.setText(rs.getString("S_id"));
                textField2.setText(rs.getString("Name"));
                String Sex = rs.getString("Sex");
                if (Sex == "F") {
                    comboBox1.setSelectedIndex(0);
                } else {
                    comboBox1.setSelectedIndex(1);
                }
                textField3.setText(rs.getString("D_id"));
                textField4.setText(rs.getString("Position"));
                textField5.setText(rs.getString("Age"));
                textField6.setText(rs.getString("Telephone"));
                textField7.setText(rs.getString("Email"));
                textField8.setText(rs.getString("Address"));
                textField9.setText(rs.getString("Password"));
                textField10.setText(rs.getString("State"));
                label1.setForeground(Color.blue);
                label4.setForeground(Color.blue);
                label5.setForeground(Color.blue);
                label10.setForeground(Color.blue);
                label11.setForeground(Color.blue);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void button1(ActionEvent e)   {
        try (Connection c = db.getCon()) {
            String name=textField2.getText();
            String sex="M";
            if (comboBox1.getSelectedIndex()==1){
                 sex="F";}
            String age=textField5.getText();
            String tele=textField6.getText();
            String email=textField7.getText();
            String address=textField8.getText();
            String s_id=textField1.getText();
            String d_id=textField3.getText();
            String position=textField4.getText();
            String password=textField9.getText();
            String state=textField10.getText();
            Staff staff=new Staff(s_id,name,sex,d_id,position,age,tele,email,address,password,state);
            Staff_dao staff_dao=new Staff_dao();
            int f=0;
            if (name.isEmpty()){
                label13.setText("姓名不能为空！");
                label13.setForeground(Color.red);
                f=1;
            }
            if(age.isEmpty()){
                label14.setText("年龄不能为空!");
                label14.setForeground(Color.red);
                f=1;
            }
            if (tele.isEmpty()){
                label15.setText("电话不能为空!");
                label15.setForeground(Color.red);
                f=1;
            }
            if (email.isEmpty()){
                label16.setText("邮箱不能为空！");
                label16.setForeground(Color.red);
                f=1;
            }
            if (address.isEmpty()){
                label17.setText("地址不能为空！");
                label17.setForeground(Color.red);
                f=1;
            }
            if (f == 0){
                staff_dao.MOdifyStaff(c,staff);
                this.dispose();
                dialog1.setVisible(true);
            }





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
        button1 = new JButton();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        label11 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField10 = new JTextField();
        dialog1 = new JDialog();
        label21 = new JLabel();

        //======== this ========
        setTitle("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("S_id");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- label2 ----
        label2.setText("Name");

        //---- label3 ----
        label3.setText("Sex");

        //---- label4 ----
        label4.setText("D_id");

        //---- label5 ----
        label5.setText("Position");

        //---- label6 ----
        label6.setText("Age");

        //---- label7 ----
        label7.setText("Tele");

        //---- label8 ----
        label8.setText("Email");

        //---- label9 ----
        label9.setText("Address");

        //---- label10 ----
        label10.setText("Password");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "M",
            "F"
        }));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

        //---- textField9 ----
        textField9.setEditable(false);

        //---- label11 ----
        label11.setText("State");

        //---- textField3 ----
        textField3.setEditable(false);

        //---- textField4 ----
        textField4.setEditable(false);

        //---- textField10 ----
        textField10.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(27, 27, 27)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(119, 119, 119))
                                            .addComponent(textField2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(textField1)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(label11, GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(textField10, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField6)))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField7))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label9)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label17, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(label16, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(textField8, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label10)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addGap(96, 96, 96)))))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label6)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label14)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(label7)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(2, 2, 2)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label13)
                        .addComponent(label15))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label8)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label16)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label17)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(label10)
                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label11)
                        .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addContainerGap(66, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful!");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label21 ----
            label21.setText("\u4fe1\u606f\u4fee\u6539\u6210\u529f\uff01");
            label21.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label21.setForeground(Color.red);

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(label21)
                        .addContainerGap(31, Short.MAX_VALUE))
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
    private JButton button1;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JLabel label11;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField10;
    private JDialog dialog1;
    private JLabel label21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
