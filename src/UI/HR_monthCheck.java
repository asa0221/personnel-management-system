/*
 * Created by JFormDesigner on Tue Oct 04 09:56:07 CST 2022
 */

package UI;

import java.awt.event.*;

import dao.Salary_dao;
import dao.Staff_dao;
import subject.Database;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author unknown
 */
public class HR_monthCheck extends JFrame {
    public static final Database db = new Database();

    public HR_monthCheck() {
        initComponents();
        comboBox3();
    }

    private void button1MouseClicked(MouseEvent e) {
        String S_id = comboBox3.getSelectedItem().toString();
        int a = 0;
        try (Connection c = db.getCon()) {
            Staff_dao staff_dao = new Staff_dao();
            Salary_dao salary_dao = new Salary_dao();
            ResultSet re = staff_dao.selectallStaff(c);
            while (re.next()) {
                if (S_id.equals(re.getString("S_id"))) {
                    a = 1;
                }
            }
            if (a == 0) {
                dialog2.setVisible(true);
            } else {
                try {
                    salary_dao.insert_salary(c, comboBox3.getSelectedItem().toString(), comboBox1.getSelectedItem().toString(), comboBox2.getSelectedItem().toString());
                } catch (Exception ex) {
                    dialog3.setVisible(true);
                    throw new RuntimeException(ex);
                }
                dialog1.setVisible(true);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void comboBox3() {
        try (Connection c = db.getCon()) {
            Staff_dao staff_dao = new Staff_dao();
            ResultSet rs = staff_dao.selectallStaff(c);
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox3.getModel();
            Vector<String> v = new Vector<>();
            while (rs.next()) {
                v.add(rs.getString("S_id"));
                System.out.println(v);
            }
            model.addAll(v);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }



    private void comboBox3ItemStateChanged(ItemEvent e) {
        if (comboBox3.getSelectedItem() != null) {
            try (Connection c = db.getCon()) {
                String sql = "select Name from Staff where S_id=?";
                PreparedStatement pstmt = c.prepareStatement(sql);
                pstmt.setString(1, comboBox3.getSelectedItem().toString());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    textField1.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        label4 = new JLabel();
        label7 = new JLabel();
        comboBox3 = new JComboBox();
        label6 = new JLabel();
        textField1 = new JTextField();
        dialog1 = new JDialog();
        label5 = new JLabel();
        dialog2 = new JDialog();
        label8 = new JLabel();
        dialog3 = new JDialog();
        label9 = new JLabel();

        //======== this ========
        setTitle("\u85aa\u8d44\u6838\u7b97");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "2020",
                    "2021",
                    "2022",
                    "2023"
                }));

                //---- comboBox2 ----
                comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12"
                }));

                //---- label1 ----
                label1.setText("\u5e74");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

                //---- label2 ----
                label2.setText("\u6708");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

                //---- label3 ----
                label3.setText("\u9009\u62e9\u6708\u4efd");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
                label3.setBackground(Color.black);
                label3.setForeground(Color.black);

                //---- button1 ----
                button1.setText("\u6838\u7b97\u5de5\u8d44");
                button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //---- label4 ----
                label4.setText("\u6ce8\uff1a\u67e5\u8be2\u524d\u8bf7\u786e\u4fdd\u5458\u5de5\u8003\u52e4\u53ca\u7ee9\u6548\u4fe1\u606f\u5b8c\u6574\uff0c\u5426\u5219\u5c06\u65e0\u6cd5\u6267\u884c\u6210\u529f");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() - 3f));
                label4.setForeground(new Color(0xff3333));

                //---- label7 ----
                label7.setText("\u804c\u5de5\u53f7\uff1a");
                label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));

                //---- comboBox3 ----
                comboBox3.addItemListener(e -> comboBox3ItemStateChanged(e));

                //---- label6 ----
                label6.setText("\u5458\u5de5\u59d3\u540d\uff1a");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addGap(53, 53, 53))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a\u9875");
            dialog1.setFont(new Font(Font.DIALOG, Font.ITALIC, 24));
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label5 ----
            label5.setText("\u6838\u7b97\u6210\u529f");
            label5.setForeground(Color.red);
            label5.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD | Font.ITALIC, 17));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("\u63d0\u793a\u9875");
            dialog2.setFont(new Font(Font.DIALOG, Font.ITALIC, 24));
            var dialog2ContentPane = dialog2.getContentPane();

            //---- label8 ----
            label8.setText("\u8be5\u5458\u5de5\u4e0d\u5b58\u5728");
            label8.setForeground(Color.red);
            label8.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD | Font.ITALIC, 17));

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(97, Short.MAX_VALUE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }

        //======== dialog3 ========
        {
            dialog3.setTitle("\u63d0\u793a\u9875");
            dialog3.setFont(new Font(Font.DIALOG, Font.ITALIC, 24));
            var dialog3ContentPane = dialog3.getContentPane();

            //---- label9 ----
            label9.setText("\u8bf7\u68c0\u67e5\u8be5\u5458\u5de5\u8be5\u6708\u8003\u52e4\u6216\u7ee9\u6548\u4fe1\u606f");
            label9.setForeground(Color.red);
            label9.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD | Font.ITALIC, 15));
            label9.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout dialog3ContentPaneLayout = new GroupLayout(dialog3ContentPane);
            dialog3ContentPane.setLayout(dialog3ContentPaneLayout);
            dialog3ContentPaneLayout.setHorizontalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog3ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            dialog3ContentPaneLayout.setVerticalGroup(
                dialog3ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog3ContentPaneLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
            );
            dialog3.pack();
            dialog3.setLocationRelativeTo(dialog3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JLabel label4;
    private JLabel label7;
    private JComboBox comboBox3;
    private JLabel label6;
    private JTextField textField1;
    private JDialog dialog1;
    private JLabel label5;
    private JDialog dialog2;
    private JLabel label8;
    private JDialog dialog3;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
