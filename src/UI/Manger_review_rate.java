/*
 * Created by JFormDesigner on Mon Oct 24 21:35:00 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;

import dao.Department_dao;
import dao.Performance_dao;
import subject.Database;
import subject.Performance;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Manger_review_rate extends JFrame {
    Database db = new Database();

    public Manger_review_rate() {
        initComponents();
        fillIn();

    }

    public void fillIn() {
        String S_id = Manager_perfomance.S_id;
        String Name = Manager_perfomance.name;
        String year = Manager_perfomance.year;
        String month = Manager_perfomance.month;
        String date = year + "-" + month;
        textField1.setText(S_id);
        textField2.setText(Name);
        textField3.setText(date);
        Performance_dao performance_dao = new Performance_dao();
        Performance performance = performance_dao.SelectReview(year, month, S_id);
        String report = performance.getReport();
        textArea1.setText(report);
    }

    private void button1(ActionEvent e) {
        String S_id = Manager_perfomance.S_id;
        String year = Manager_perfomance.year;
        String month = Manager_perfomance.month;

        try (Connection c = db.getCon()) {
            String review = "Unreviewed";
            String rate = "Null";
            if (comboBox1.getSelectedIndex() == 0 || comboBox1.getSelectedIndex() == 2) {
                review = "Not Pass";
            } else {
                review = "Pass";
                if (comboBox2.getSelectedIndex() == 0) {
                    label8.setText("评级不能为空！");
                    label8.setForeground(Color.red);
                    System.out.println(review);
                } else if (comboBox2.getSelectedIndex() == 1) {
                    rate = "A+";

                } else if (comboBox2.getSelectedIndex() == 2) {
                    rate = "A";

                } else if (comboBox2.getSelectedIndex() == 3) {
                    rate = "B";

                } else if (comboBox2.getSelectedIndex() == 4) {
                    rate = "C";
                }
            }


            boolean b = !(comboBox1.getSelectedIndex() == 1) && !(comboBox2.getSelectedIndex() == 0);
            boolean b1 = comboBox1.getSelectedIndex() == 1 && (comboBox2.getSelectedIndex() == 0);
            if (b) {
                label8.setText("审核未通过不能评级");
                label8.setForeground(Color.red);
            } else if (b1) {
                label8.setText("评级不能为空！");
                label8.setForeground(Color.red);
            } else {
                Performance_dao performance_dao = new Performance_dao();
                Performance performance = performance_dao.SelectReview(year, month, S_id);
                performance.setReview(review);
                performance.setRate(rate);
                if (rate == "Null") {
                    performance_dao.updatenull(performance);
                } else {
                    performance_dao.update(performance);
                }
                this.dispose();
                new Manager_perfomance().setVisible(true);
                dialog1.setVisible(true);
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
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label5 = new JLabel();
        label6 = new JLabel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        button1 = new JButton();
        label7 = new JLabel();
        label8 = new JLabel();
        dialog1 = new JDialog();
        label21 = new JLabel();

        //======== this ========
        setTitle("\u7ee9\u6548\u5ba1\u6838 \u8bc4\u7ea7");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("S_id:");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- label2 ----
        label2.setText("Name:");

        //---- textField2 ----
        textField2.setEditable(false);

        //---- label3 ----
        label3.setText("Date:");

        //---- textField3 ----
        textField3.setEditable(false);

        //---- label4 ----
        label4.setText("\u6708\u5ea6\u5de5\u4f5c\u62a5\u544a");

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }

        //---- label5 ----
        label5.setText("\u5ba1\u6838\u72b6\u6001\uff1a");

        //---- label6 ----
        label6.setText("\u8bc4\u7ea7\uff1a");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Unreviewed",
            "Pass",
            "Not Pass"
        }));

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "Null",
            "A+",
            "A",
            "B",
            "C"
        }));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1(e));

        //---- label7 ----
        label7.setText("\u672a\u6539\u53d8\u5ba1\u6838\u72b6\u6001\u70b9\u51fb\u786e\u5b9a\u9ed8\u8ba4  \u4e0d\u901a\u8fc7");
        label7.setForeground(Color.blue);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(button1))
                                        .addComponent(label6)
                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(6, 6, 6))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addGap(190, 190, 190)
                            .addComponent(label7)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button1)))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Successful!");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label21 ----
            label21.setText("\u7ee9\u6548\u5ba1\u6838\u5b8c\u6210\uff01");
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
                        .addGap(53, 53, 53)
                        .addComponent(label21, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
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
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label5;
    private JLabel label6;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JButton button1;
    private JLabel label7;
    private JLabel label8;
    private JDialog dialog1;
    private JLabel label21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
