/*
 * Created by JFormDesigner on Tue Oct 18 09:14:02 GMT+08:00 2022
 */

package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class Staff_mainpage extends JFrame {
    public Staff_mainpage() {
        initComponents();
    }
    private void menuItem3(ActionEvent e) {
        count_by_month count_by_month=new count_by_month();
        count_by_month.setVisible(true);

    }

    private void menuItem7(ActionEvent e) {
        salary_for_Staff salary_for_staff=new salary_for_Staff();
        salary_for_staff.setVisible(true);

    }

    private void menuItem4(ActionEvent e) {
        count_by_day count_by_day=new count_by_day();
        count_by_day.setVisible(true);

    }

    private void menuItem1(ActionEvent e) {
        Staff_performance_fiilin staff_performance_fiilin=new Staff_performance_fiilin();
        staff_performance_fiilin.setVisible(true);

    }

    private void menuItem5(ActionEvent e) {
        new Staff_selfinfo().setVisible(true);
    }

    private void menuItem6(ActionEvent e) {
        new Staff_password().setVisible(true);
    }

    private void menuItem2(ActionEvent e) {
        dialog1.setVisible(true);

    }

    private void button2(ActionEvent e) {
        dialog1.setVisible(false);
    }

    private void button1(ActionEvent e) {
        try {
            this.dispose();
            dialog1.setVisible(false);
            new log().setVisible(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu4 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu5 = new JMenu();
        menuItem7 = new JMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem2 = new JMenuItem();
        label1 = new JLabel();
        label1.setIcon(new ImageIcon("src/01.png"));
        dialog1 = new JDialog();
        label7 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5458\u5de5\u4e3b\u754c\u9762");
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u4fe1\u606f\u67e5\u8be2");
                menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getSize() + 1f));

                //======== menu4 ========
                {
                    menu4.setText("\u8003\u52e4\u4fe1\u606f\u67e5\u8be2");
                    menu4.setFont(menu4.getFont().deriveFont(menu4.getFont().getSize() + 1f));

                    //---- menuItem3 ----
                    menuItem3.setText("\u6309\u6708\u67e5\u8be2");
                    menuItem3.setFont(menuItem3.getFont().deriveFont(menuItem3.getFont().getSize() + 1f));
                    menuItem3.addActionListener(e -> menuItem3(e));
                    menu4.add(menuItem3);

                    //---- menuItem4 ----
                    menuItem4.setText("\u6309\u65e5\u67e5\u8be2");
                    menuItem4.setFont(menuItem4.getFont().deriveFont(menuItem4.getFont().getSize() + 1f));
                    menuItem4.addActionListener(e -> menuItem4(e));
                    menu4.add(menuItem4);
                }
                menu1.add(menu4);

                //======== menu5 ========
                {
                    menu5.setText("\u5de5\u8d44\u4fe1\u606f\u67e5\u8be2");
                    menu5.setFont(menu5.getFont().deriveFont(menu5.getFont().getSize() + 1f));

                    //---- menuItem7 ----
                    menuItem7.setText("\u5de5\u8d44\u67e5\u8be2");
                    menuItem7.setFont(menuItem7.getFont().deriveFont(menuItem7.getFont().getSize() + 1f));
                    menuItem7.addActionListener(e -> menuItem7(e));
                    menu5.add(menuItem7);
                }
                menu1.add(menu5);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u7ee9\u6548\u586b\u62a5");
                menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 1f));

                //---- menuItem1 ----
                menuItem1.setText("\u7ee9\u6548\u586b\u62a5");
                menuItem1.addActionListener(e -> menuItem1(e));
                menu2.add(menuItem1);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u8d26\u53f7\u7ba1\u7406");
                menu3.setFont(menu3.getFont().deriveFont(menu3.getFont().getSize() + 1f));

                //---- menuItem5 ----
                menuItem5.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
                menuItem5.setFont(menuItem5.getFont().deriveFont(menuItem5.getFont().getSize() + 1f));
                menuItem5.addActionListener(e -> menuItem5(e));
                menu3.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem6.setFont(menuItem6.getFont().deriveFont(menuItem6.getFont().getSize() + 1f));
                menuItem6.addActionListener(e -> menuItem6(e));
                menu3.add(menuItem6);

                //---- menuItem2 ----
                menuItem2.setText("\u9000\u51fa\u767b\u5f55");
                menuItem2.addActionListener(e -> menuItem2(e));
                menu3.add(menuItem2);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("\u63d0\u793a");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label7 ----
            label7.setText("\u786e\u8ba4\u9000\u51fa\u767b\u5f55");
            label7.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
            label7.setForeground(Color.red);

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(e -> button1(e));

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            button2.addActionListener(e -> button2(e));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(button2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(button1)))
                        .addContainerGap())
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button2))
                        .addContainerGap(32, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu4;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu5;
    private JMenuItem menuItem7;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenuItem menuItem2;
    private JLabel label1;
    private JDialog dialog1;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
