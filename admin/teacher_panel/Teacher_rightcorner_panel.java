package admin.teacher_panel;

import prototype.logo_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Teacher_rightcorner_panel extends rounded_panel {
    public JTextField fethnic;
    public JTextField freligion;


    public JTextField fdepartment;
    public JTextField fqualification;
    public JTextField fusername;
    public JTextField fpassword;

    public Teacher_rightcorner_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        setPreferredSize(new Dimension(200, 500));
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx =1;
        gbc.weighty =1;
        logo_panel logo = new logo_panel();
        logo.setPreferredSize(new Dimension(120, 150));
        add(logo, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0.1;

        JLabel ethnic = new JLabel();
        ethnic.setText("  Dân tộc: ");
        ethnic.setFont(new Font(null, Font.BOLD, 18));

        fethnic = new JTextField();
        fethnic.setFont(new Font(null, Font.BOLD, 18));
        fethnic.setPreferredSize(new Dimension(200, 40));
        fethnic.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fethnic.setHorizontalAlignment(JTextField.LEFT);
        fethnic.setBorder(BorderFactory.createEmptyBorder());
        fethnic.setEditable(false);
        fethnic.setOpaque(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(250, 50));
        p1.add(ethnic);
        p1.add(fethnic);
        gbc.gridy = 1;
        add(p1, gbc);

        JLabel religion = new JLabel();
        religion.setText("  Quốc tịch: ");
        religion.setFont(new Font(null, Font.BOLD, 18));

        freligion = new JTextField();
        freligion.setFont(new Font(null, Font.BOLD, 18));
        freligion.setPreferredSize(new Dimension(200, 40));
        freligion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        freligion.setHorizontalAlignment(JTextField.LEFT);
        freligion.setBorder(BorderFactory.createEmptyBorder());
        freligion.setEditable(false);
        freligion.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(200, 50));
        p2.add(religion);
        p2.add(freligion);
        gbc.gridy = 2;
        add(p2, gbc);
        setPreferredSize(new Dimension(200, 400));

        JLabel department = new JLabel();
        department.setText("  Khoa: ");
        department.setFont(new Font(null, Font.BOLD, 18));

        fdepartment = new JTextField();
        fdepartment.setFont(new Font(null, Font.BOLD, 18));
        fdepartment.setPreferredSize(new Dimension(150, 40));
        fdepartment.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fdepartment.setHorizontalAlignment(JTextField.LEFT);
        fdepartment.setBorder(BorderFactory.createEmptyBorder());
        fdepartment.setEditable(false);
        fdepartment.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(200, 50));
        p3.add(department);
        p3.add(fdepartment);
        gbc.gridy = 3;
        add(p3, gbc);

        JLabel qualification = new JLabel();
        qualification.setText("  Trình độ chuyên môn: ");
        qualification.setFont(new Font(null, Font.BOLD, 18));

        fqualification = new JTextField();
        fqualification.setFont(new Font(null, Font.BOLD, 18));
        fqualification.setPreferredSize(new Dimension(150, 40));
        fqualification.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fqualification.setHorizontalAlignment(JTextField.LEFT);
        fqualification.setBorder(BorderFactory.createEmptyBorder());
        fqualification.setEditable(false);
        fqualification.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(200, 50));
        p4.add(qualification);
        p4.add(fqualification);
        gbc.gridy = 4;
        add(p4, gbc);

        JLabel username = new JLabel();
        username.setText("  Username: ");
        username.setFont(new Font(null, Font.BOLD, 18));

        fusername = new JTextField();
        fusername.setFont(new Font(null, Font.BOLD, 18));
        fusername.setPreferredSize(new Dimension(150, 40));
        fusername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fusername.setHorizontalAlignment(JTextField.LEFT);
        fusername.setBorder(BorderFactory.createEmptyBorder());
        fusername.setEditable(false);
        fusername.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(200, 50));
        p5.add(username);
        p5.add(fusername);
        gbc.gridy = 5;
        add(p5, gbc);

        JLabel password = new JLabel();
        password.setText("  Password: ");
        password.setFont(new Font(null, Font.BOLD, 18));

        fpassword = new JTextField();
        fpassword.setFont(new Font(null, Font.BOLD, 18));
        fpassword.setPreferredSize(new Dimension(150, 40));
        fpassword.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fpassword.setHorizontalAlignment(JTextField.LEFT);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.setEditable(false);
        fpassword.setOpaque(false);

        JPanel p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(200, 50));
        p6.add(password);
        p6.add(fpassword);
        gbc.gridy = 6;
        add(p6, gbc);
    }
}
