package lgScreen;

import admin.admin_panel;
import student.info_panel.student_panel;
import teacher.teacher_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    static JPanel constpanel;
    public static login_screen loginScreen;
    public admin_panel adminPanel;
    public static student_panel studentPanel;
    public static teacher_panel teacherPanel;
    public static CardLayout cl = new CardLayout();
    public Frame(){
        setTitle("Group-fine's manager app");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1350, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        constpanel = new JPanel();
        constpanel.setLayout(cl);

        loginScreen = new login_screen();
        constpanel.add(loginScreen, "login");

        adminPanel = new admin_panel();
        adminPanel.getToppanel().log_out.addActionListener(this);
        constpanel.add(adminPanel, "admin");

        studentPanel = new student_panel();
        studentPanel.getToppanel().log_out.addActionListener(this);
        constpanel.add(studentPanel, "student");

        teacherPanel = new teacher_panel();
        teacherPanel.getToppanel().log_out.addActionListener(this);
        constpanel.add(teacherPanel, "teacher");

        cl.show(constpanel, "login");
        add(constpanel);
        getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminPanel.getToppanel().log_out ||
                e.getSource() == studentPanel.getToppanel().log_out ||
                e.getSource() == teacherPanel.getToppanel().log_out){
            cl.show(constpanel, "login");
        }
    }
}
