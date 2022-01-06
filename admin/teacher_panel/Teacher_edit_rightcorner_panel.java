package admin.teacher_panel;

import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Teacher_edit_rightcorner_panel extends rounded_panel {

    public JTextField fstatus;
    public JTextField fdepartment;
    public JTextField fqualification;
    public JTextField fusername;
    public JTextField fpassword;
    public JTextField femail;
    public JTextField fphonenumber;

    public Teacher_edit_rightcorner_panel(int radius, Color bgColor) {
        super(radius, bgColor);

//        gbc.fill = GridBagConstraints.NONE;
//        gbc.weightx =1;
//        gbc.weighty =1;
//        logo_panel logo = new logo_panel();
//        logo.setPreferredSize(new Dimension(120, 250));
//        add(logo, gbc);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;


        JLabel status = new JLabel();
        status.setText("  Trạng thái:");
        status.setFont(new Font(null, Font.BOLD, 18));

        fstatus = new JTextField();
        fstatus.setFont(new Font(null, Font.BOLD, 18));
        fstatus.setPreferredSize(new Dimension(200, 40));
        fstatus.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fstatus.setHorizontalAlignment(JTextField.LEFT);
        fstatus.setBorder(BorderFactory.createEmptyBorder());
        fstatus.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(250, 50));
        p2.add(status);
        p2.add(fstatus);
        gbc.gridy = 1;
        add(p2, gbc);

        JLabel department = new JLabel();
        department.setText("  Khoa:");
        department.setFont(new Font(null, Font.BOLD, 18));

        fdepartment = new JTextField();
        fdepartment.setFont(new Font(null, Font.BOLD, 18));
        fdepartment.setPreferredSize(new Dimension(200, 40));
        fdepartment.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fdepartment.setHorizontalAlignment(JTextField.LEFT);
        fdepartment.setBorder(BorderFactory.createEmptyBorder());
        fdepartment.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(250, 50));
        p3.add(department);
        p3.add(fdepartment);
        gbc.gridy = 2;
        add(p3, gbc);

        JLabel qualification = new JLabel();
        qualification.setText("  Trình độ nghề nghiệp:");
        qualification.setFont(new Font(null, Font.BOLD, 18));

        fqualification = new JTextField();
        fqualification.setFont(new Font(null, Font.BOLD, 18));
        fqualification.setPreferredSize(new Dimension(250, 40));
        fqualification.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fqualification.setHorizontalAlignment(JTextField.LEFT);
        fqualification.setBorder(BorderFactory.createEmptyBorder());
        fqualification.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(250, 50));
        p4.add(qualification);
        p4.add(fqualification);
        gbc.gridy = 3;
        add(p4, gbc);

        JLabel username = new JLabel();
        username.setText("  Username:");
        username.setFont(new Font(null, Font.BOLD, 18));

        fusername = new JTextField();
        fusername.setFont(new Font(null, Font.BOLD, 18));
        fusername.setPreferredSize(new Dimension(250, 40));
        fusername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fusername.setHorizontalAlignment(JTextField.LEFT);
        fusername.setBorder(BorderFactory.createEmptyBorder());
        fusername.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(250, 50));
        p5.add(username);
        p5.add(fusername);
        gbc.gridy = 4;
        add(p5, gbc);

        JLabel password = new JLabel();
        password.setText("  Password:");
        password.setFont(new Font(null, Font.BOLD, 18));

        fpassword = new JTextField();
        fpassword.setFont(new Font(null, Font.BOLD, 18));
        fpassword.setPreferredSize(new Dimension(250, 40));
        fpassword.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fpassword.setHorizontalAlignment(JTextField.LEFT);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.setOpaque(false);

        JPanel p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(250, 50));
        p6.add(password);
        p6.add(fpassword);
        gbc.gridy = 5;
        add(p6, gbc);

        JLabel email = new JLabel();
        email.setText("  Email: ");
        email.setFont(new Font(null, Font.BOLD, 18));

        femail = new JTextField();
        femail.setFont(new Font(null, Font.BOLD, 18));
        femail.setPreferredSize(new Dimension(350, 40));
        femail.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        femail.setHorizontalAlignment(JTextField.LEFT);
        femail.setBorder(BorderFactory.createEmptyBorder());
//        femail.setOpaque(true);

        JPanel p8 = new JPanel();
        p8.setLayout(new FlowLayout(FlowLayout.LEFT));
        p8.setOpaque(false);
        p8.setPreferredSize(new Dimension(350, 50));
        p8.add(email);
        p8.add(femail);
        gbc.gridy = 7;
        add(p8, gbc);

        JLabel phonenumber = new JLabel();
        phonenumber.setText("  Số điện thoại: ");
        phonenumber.setFont(new Font(null, Font.BOLD, 18));

        fphonenumber = new JTextField();
        fphonenumber.setFont(new Font(null, Font.BOLD, 18));
        fphonenumber.setPreferredSize(new Dimension(250, 40));
        fphonenumber.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fphonenumber.setHorizontalAlignment(JTextField.LEFT);
        fphonenumber.setBorder(BorderFactory.createEmptyBorder());
        fphonenumber.setOpaque(false);

        JPanel p9 = new JPanel();
        p9.setLayout(new FlowLayout(FlowLayout.LEFT));
        p9.setOpaque(false);
        p9.setPreferredSize(new Dimension(250, 50));
        p9.add(phonenumber);
        p9.add(fphonenumber);
        gbc.gridy = 8;
        add(p9, gbc);
    }
}
