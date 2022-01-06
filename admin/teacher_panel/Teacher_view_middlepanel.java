package admin.teacher_panel;

import admin.student_panel.Student_view_mini_middel_panel;
import teacher.Teacher;

import javax.swing.*;
import java.awt.*;

public class Teacher_view_middlepanel extends JPanel {
    public Teacher_view_mini_middel_panel mini_middel_panel;
    public Teacher_view_middlepanel() {

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel p1 = new JPanel();
        p1.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        mini_middel_panel = new Teacher_view_mini_middel_panel();
        mini_middel_panel.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setOpaque(false);


        gbc.gridheight = 3;
        gbc.weightx = 0.01;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(p1,gbc);


        gbc.gridheight =1;
        gbc.weightx = 1;
        gbc.weighty = 0.01;

        gbc.gridx =1;
        gbc.gridy =0;
        add(p2,gbc);

        gbc.gridheight = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 1;
        gbc.gridy = 0;
        gbc.gridx = 2;
        add(p3,gbc);

        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx= 1;
        gbc.gridy = 1;
        add(mini_middel_panel,gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.01;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(p5,gbc);
    }
}

