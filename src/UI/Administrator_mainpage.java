/*
 * Created by JFormDesigner on Wed Sep 28 20:15:33 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Administrator_mainpage extends JFrame {

    public Administrator_mainpage() {
        initComponents();
    }

    private void menuItem1(ActionEvent e)  {
        try {
            new A_information().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem2(ActionEvent e) {
        try {
            new AddAdmin().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem3(ActionEvent e) {
        try {
            new Admin_passwordC().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void menuItem5(ActionEvent e)  {
        try {
            new Admin_Control().setVisible(true);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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

    private void menuItem7(ActionEvent e) {
        dialog1.setVisible(true);
    }


    private void menuItem4(ActionEvent e) {
        new Admin_addDepartment().setVisible(true);
    }

    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu4 = new JMenu();
        menuItem5 = new JMenuItem();
        menu5 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        label1 = new JLabel();
        dialog1 = new JDialog();
        label7 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label1.setIcon(new ImageIcon("src/04.png"));

        //======== this ========
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u4fe1\u606f\u7ef4\u62a4");

                //======== menu4 ========
                {
                    menu4.setText("\u5458\u5de5\u4fe1\u606f\u7ef4\u62a4");

                    //---- menuItem5 ----
                    menuItem5.setText("\u4fe1\u606f\u7ef4\u62a4");
                    menuItem5.addActionListener(e -> menuItem5(e));
                    menu4.add(menuItem5);
                }
                menu1.add(menu4);
                menu1.addSeparator();

                //======== menu5 ========
                {
                    menu5.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u7ef4\u62a4");

                    //---- menuItem1 ----
                    menuItem1.setText("\u7ba1\u7406\u5458\u4fe1\u606f\u67e5\u770b");
                    menuItem1.addActionListener(e -> menuItem1(e));
                    menu5.add(menuItem1);

                    //---- menuItem2 ----
                    menuItem2.setText("\u589e\u52a0\u7ba1\u7406\u5458\u4fe1\u606f");
                    menuItem2.addActionListener(e -> menuItem2(e));
                    menu5.add(menuItem2);

                    //---- menuItem3 ----
                    menuItem3.setText("\u7ba1\u7406\u5458\u5bc6\u7801\u4fee\u6539");
                    menuItem3.addActionListener(e -> menuItem3(e));
                    menu5.add(menuItem3);
                }
                menu1.add(menu5);

                //======== menu2 ========
                {
                    menu2.setText("\u90e8\u95e8\u4fe1\u606f\u7ef4\u62a4");

                    //---- menuItem4 ----
                    menuItem4.setText("\u90e8\u95e8\u589e\u52a0");
                    menuItem4.addActionListener(e -> menuItem4(e));
                    menu2.add(menuItem4);
                }
                menu1.add(menu2);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("\u767b\u51fa");

                //---- menuItem7 ----
                menuItem7.setText("\u9000\u51fa\u767b\u5f55");
                menuItem7.addActionListener(e -> menuItem7(e));
                menu3.add(menuItem7);
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
            button2.addActionListener(e -> {
			button2(e);
			button2(e);
		});

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
    private JMenuItem menuItem5;
    private JMenu menu5;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JLabel label1;
    private JDialog dialog1;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
