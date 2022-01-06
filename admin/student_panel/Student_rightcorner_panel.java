package admin.student_panel;
import prototype.rounded_panel;
import prototype.logo_panel;


import javax.swing.*;
import java.awt.*;

public class Student_rightcorner_panel extends rounded_panel {
    public JTextField fstudent_id;
    public JTextField fdepartment;
    public JTextField fmajor;
    public JTextField fschool_year;
    public JTextField fgpa;
    public JTextField fusername;
    public JTextField fpassword;

    public Student_rightcorner_panel(int radius, Color bgColor) {
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
        JLabel student_id = new JLabel();
        student_id.setText("  MSV: ");
        student_id.setFont(new Font(null, Font.BOLD, 18));

        fstudent_id = new JTextField();
        fstudent_id.setFont(new Font(null, Font.BOLD, 18));
        fstudent_id.setPreferredSize(new Dimension(150, 40));
        fstudent_id.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fstudent_id.setHorizontalAlignment(JTextField.LEFT);
        fstudent_id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fstudent_id.setEditable(false);
        fstudent_id.setOpaque(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(200, 50));
        p1.add(student_id);
        p1.add(fstudent_id);
        gbc.gridy = 1;
        add(p1, gbc);

        JLabel department = new JLabel();
        department.setText("  Khoa: ");
        department.setFont(new Font(null, Font.BOLD, 18));

        fdepartment = new JTextField();
        fdepartment.setFont(new Font(null, Font.BOLD, 18));
        fdepartment.setPreferredSize(new Dimension(150, 40));
        fdepartment.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fdepartment.setHorizontalAlignment(JTextField.LEFT);
        fdepartment.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fdepartment.setEditable(false);
        fdepartment.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(200, 50));
        p2.add(department);
        p2.add(fdepartment);
        gbc.gridy = 2;
        add(p2, gbc);

        JLabel major = new JLabel();
        major.setText("  Lớp: ");
        major.setFont(new Font(null, Font.BOLD, 18));

        fmajor = new JTextField();
        fmajor.setFont(new Font(null, Font.BOLD, 18));
        fmajor.setPreferredSize(new Dimension(150, 40));
        fmajor.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fmajor.setHorizontalAlignment(JTextField.LEFT);
        fmajor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fmajor.setEditable(false);
        fmajor.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(200, 50));
        p3.add(major);
        p3.add(fmajor);
        gbc.gridy = 3;
        add(p3, gbc);

        JLabel school_year = new JLabel();
        school_year.setText("  Khóa: ");
        school_year.setFont(new Font(null, Font.BOLD, 18));

        fschool_year = new JTextField();
        fschool_year.setFont(new Font(null, Font.BOLD, 18));
        fschool_year.setPreferredSize(new Dimension(150, 40));
        fschool_year.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fschool_year.setHorizontalAlignment(JTextField.LEFT);
        fschool_year.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fschool_year.setEditable(false);
        fschool_year.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(200, 50));
        p4.add(school_year);
        p4.add(fschool_year);
        gbc.gridy = 4;
        add(p4, gbc);

        JLabel gpa = new JLabel();
        gpa.setText("  GPA: ");
        gpa.setFont(new Font(null, Font.BOLD, 18));

        fgpa = new JTextField();
        fgpa.setFont(new Font(null, Font.BOLD, 18));
        fgpa.setPreferredSize(new Dimension(150, 40));
        fgpa.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fgpa.setHorizontalAlignment(JTextField.LEFT);
        fgpa.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fgpa.setEditable(false);
        fgpa.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(200, 50));
        p5.add(gpa);
        p5.add(fgpa);
        gbc.gridy = 5;
        add(p5, gbc);

        JLabel username = new JLabel();
        username.setText("  Username: ");
        username.setFont(new Font(null, Font.BOLD, 18));

        fusername = new JTextField();
        fusername.setFont(new Font(null, Font.BOLD, 18));
        fusername.setPreferredSize(new Dimension(150, 40));
        fusername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fusername.setHorizontalAlignment(JTextField.LEFT);
        fusername.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fusername.setEditable(false);
        fusername.setOpaque(false);

        JPanel p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(200, 50));
        p6.add(username);
        p6.add(fusername);
        gbc.gridy = 6;
        add(p6, gbc);

        JLabel password = new JLabel();
        password.setText("  Password: ");
        password.setFont(new Font(null, Font.BOLD, 18));

        fpassword = new JTextField();
        fpassword.setFont(new Font(null, Font.BOLD, 18));
        fpassword.setPreferredSize(new Dimension(150, 40));
        fpassword.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fpassword.setHorizontalAlignment(JTextField.LEFT);
        fpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        fpassword.setEditable(false);
        fpassword.setOpaque(false);

        JPanel p7 = new JPanel();
        p7.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(200, 50));
        p7.add(password);
        p7.add(fpassword);
        gbc.gridy = 7;
        add(p7, gbc);
    }
}
