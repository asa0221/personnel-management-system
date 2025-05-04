/*
 * Created by JFormDesigner on Thu Oct 13 10:57:16 CST 2022
 */

package UI;

import javax.swing.table.*;

import dao.Department_dao;
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

/**
 * @author unknown
 */
public class Admin_Modifybyname extends JFrame {
    Database db = new Database();
    Connection c=db.getCon();
    public static Staff staff1 = new Staff();

    public Admin_Modifybyname() throws Exception {
        initComponents();
        comboBox2();
    }

    private void button1(ActionEvent e) {
        try {
            String Name = textField3.getText();
            Connection c = db.getCon();
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
            }
            if (name.isEmpty()) {
                label13.setText("员工姓名不能为空！");
                label13.setForeground(Color.red);
            }
            if (age.isEmpty()) {
                label14.setText("员工年龄不能为空！");
                label14.setForeground(Color.red);
            }
            if (tele.isEmpty()) {
                label15.setText("员工电话不能为空！");
                label15.setForeground(Color.red);
            }
            if (email.isEmpty()) {
                label16.setText("员工邮箱不能为空！");
                label16.setForeground(Color.red);
            }
            if (address.isEmpty()) {
                label17.setText("员工地址不能为空！");
                label17.setForeground(Color.red);
            }
            if (password.isEmpty()) {
                label18.setText("员工密码不能为空！");
                label18.setForeground(Color.red);
            }
            Staff_dao staff_dao = new Staff_dao();
            ResultSet compareid = staff_dao.SelectStaff(c, s_id);
            //compareid是空 则要修改的id没有被占用
            if (compareid.next()) {
                //如果compareid非空 有两种可能（1）自己占用（2）他人占用 则要判断 是否他没有修改id
                if (compareid.getString(1).equals(staff1.getS_id())) {
                    staff_dao.MOdifyStaff(c, staff);
                    //如果是 要进行数据更改
                    this2.dispose();
                    System.out.println(staff1.getS_id());
                    System.out.println(compareid.getString(1));
                    new Admin_Control().setVisible(true);
                    dialog1.setVisible(true);
                } else {
                    //如果不是 要报错
                    System.out.println(staff1.getS_id());
                    System.out.println(compareid.getString(1));
                    label12.setText("员工id已存在！");
                    label12.setForeground(Color.red);
                }

            }
            //要把原来的信息删除，重新添加
            System.out.println(staff1.getS_id());
            staff_dao.AddStaff(c, staff);
            staff_dao.DeleteStaff(c, staff1.getS_id());
            this2.dispose();
            new Admin_Control().setVisible(true);
            dialog1.setVisible(true);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button2(ActionEvent e)  {
        try {
            String name = textField3.getText();
            Staff_dao staff_dao = new Staff_dao();
            ResultSet rs = staff_dao.SelectStaff_byname(db.getCon(), name);
            System.out.println(rs);
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
                label20.setText("员工不存在！");
                label20.setForeground(Color.red);
                System.out.println("ok");
                this2.setVisible(false);
                this.setVisible(true);
            } else {
                this.dispose();
                frame1.setVisible(true);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button3(ActionEvent e) {
        int row = table1.getSelectedRow();
        String ID = (String) table1.getValueAt(row, 0);
        Staff_dao staff_dao = new Staff_dao();
        staff1.setS_id(ID);
        System.out.println(ID);
        try (Connection c = db.getCon()) {
            ResultSet rs = staff_dao.SelectStaff(c, ID);
            if (rs.next()) {
                textField1.setText(rs.getString(1));
                textField2.setText(rs.getString(2));
                if (rs.getString(3).equals("M")) {
                    comboBox1.setSelectedIndex(0);
                }
                if (rs.getString(3).equals("F")) {
                    comboBox1.setSelectedIndex(1);
                }
                if (rs.getString(4).equals("01")) {
                    comboBox2.setSelectedIndex(0);
                }
                if (rs.getString(4).equals("02")) {
                    comboBox2.setSelectedIndex(1);
                }
                if (rs.getString(4).equals("03")) {
                    comboBox2.setSelectedIndex(2);
                }
                if (rs.getString(4).equals("04")) {
                    comboBox2.setSelectedIndex(3);
                }
                if (rs.getString(4).equals("05")) {
                    comboBox2.setSelectedIndex(4);
                }
                if (rs.getString(5).equals("employee")) {
                    comboBox3.setSelectedIndex(0);
                }
                if (rs.getString(5).equals("manager")) {
                    comboBox3.setSelectedIndex(1);
                }
                if (rs.getString(5).equals("HR")) {
                    comboBox3.setSelectedIndex(2);
                }
                if (rs.getString(11).equals("yes")) {
                    comboBox4.setSelectedIndex(0);
                }
                if (rs.getString(11).equals("no")) {
                    comboBox3.setSelectedIndex(1);
                }
                textField5.setText(rs.getString(6));
                textField6.setText(rs.getString(7));
                textField7.setText(rs.getString(8));
                textField8.setText(rs.getString(9));
                textField9.setText(rs.getString(10));
                frame1.dispose();
                this2.setVisible(true);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
            label22.setText(dname);
            label22.setForeground(Color.blue);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label19 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        label20 = new JLabel();
        this2 = new JFrame();
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
        label22 = new JLabel();
        dialog1 = new JDialog();
        label21 = new JLabel();
        frame1 = new JFrame();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button3 = new JButton();

        //======== this ========
        setTitle("\u6309\u5458\u59d3\u540d\u67e5\u627e");
        var contentPane = getContentPane();

        //---- label19 ----
        label19.setText("name");

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
                            .addGap(138, 138, 138)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(label19)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(label20, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(36, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label19)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label20)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(31, 31, 31))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== this2 ========
        {
            var this2ContentPane = this2.getContentPane();

            //---- label1 ----
            label1.setText("S_id");

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

            //---- comboBox2 ----
            comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

            //---- comboBox3 ----
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                "employee",
                "manager",
                "HR"
            }));

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});

            //---- label11 ----
            label11.setText("State");

            //---- comboBox4 ----
            comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
                "yes",
                "no"
            }));

            GroupLayout this2ContentPaneLayout = new GroupLayout(this2ContentPane);
            this2ContentPane.setLayout(this2ContentPaneLayout);
            this2ContentPaneLayout.setHorizontalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addComponent(label4)
                            .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                    .addGroup(this2ContentPaneLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label3))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, this2ContentPaneLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(comboBox2)
                                                .addComponent(comboBox1))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label22, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label13, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                                .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addGroup(this2ContentPaneLayout.createParallelGroup()
                                        .addComponent(label12, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                        .addComponent(textField1))))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGroup(this2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label5)
                                    .addComponent(label11, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox3)
                                    .addComponent(comboBox4))))
                        .addGap(22, 22, 22)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                                .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(this2ContentPaneLayout.createParallelGroup()
                                        .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textField6)))
                                .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label8)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(this2ContentPaneLayout.createParallelGroup()
                                        .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textField7))))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label17, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(label16, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(textField8, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label18, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(textField9, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                            .addComponent(button1))
                        .addContainerGap(19, Short.MAX_VALUE))
            );
            this2ContentPaneLayout.setVerticalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addGroup(this2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label6)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(label14))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(label15))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label8)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label16)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(label22, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label17)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(label10)
                            .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(this2ContentPaneLayout.createParallelGroup()
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(this2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label11)
                                    .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(this2ContentPaneLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(label18)
                                .addGap(13, 13, 13)
                                .addComponent(button1)))
                        .addContainerGap(91, Short.MAX_VALUE))
            );
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful!");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label21 ----
            label21.setText("\u5458\u5de5\u4fe1\u606f\u4fee\u6539\u6210\u529f\uff01");
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
                        .addGap(51, 51, 51)
                        .addComponent(label21, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== frame1 ========
        {
            frame1.setTitle("\u9009\u62e9\u5458\u5de5");
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

            //---- button3 ----
            button3.setText("\u4fee\u6539");
            button3.addActionListener(e -> button3(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(152, Short.MAX_VALUE)
                        .addComponent(button3)
                        .addGap(148, 148, 148))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addContainerGap())
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label19;
    private JTextField textField3;
    private JButton button2;
    private JLabel label20;
    private JFrame this2;
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
    private JLabel label22;
    private JDialog dialog1;
    private JLabel label21;
    private JFrame frame1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
