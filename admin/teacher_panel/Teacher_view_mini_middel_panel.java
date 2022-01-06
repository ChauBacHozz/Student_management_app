package admin.teacher_panel;

import admin.student_panel.Student_leftcorner_panel;
import admin.student_panel.Student_rightcorner_panel;
import prototype.rounded_button;

import javax.swing.*;
import java.awt.*;

public class Teacher_view_mini_middel_panel extends JPanel {
    public Teacher_leftcorner_panel leftcorner_panel;
    public Teacher_rightcorner_panel rightcorner_panel;
    public rounded_button insert_button;
    public Teacher_view_mini_middel_panel() {
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=1;

        gbc.fill = GridBagConstraints.BOTH;

        leftcorner_panel = new Teacher_leftcorner_panel(50,Color.WHITE);
        leftcorner_panel.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setOpaque(false);

        rightcorner_panel = new Teacher_rightcorner_panel(50,Color.WHITE);
        rightcorner_panel.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setOpaque(false);


        insert_button = new rounded_button("Tạo thêm giảng viên",
                new Color(218, 150, 237),
                new Color(190, 146, 248));
        insert_button.setFont(new Font(null, Font.BOLD, 25));
        insert_button.setPreferredSize(new Dimension(270, 150));
        insert_button.setOpaque(false);



        gbc.weighty = 0.01;
        gbc.weightx = 0.1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(leftcorner_panel,gbc);

        gbc.weightx = 0.01;
        gbc.gridheight = 3;
        gbc.gridx =1;
        gbc.gridy =0;
        add(p2,gbc);

//        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0.5;
        gbc.gridy = 0;
        gbc.gridx = 2;
        add(rightcorner_panel,gbc);

        gbc.gridheight = 1;
        gbc.weighty=0.01;
        gbc.gridx= 0;
        gbc.gridy = 1;
        add(p4,gbc);

        gbc.weightx = 1;
        gbc.weighty=0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(insert_button,gbc);





    }
}
