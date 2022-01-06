package student.info_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Student_edit_leftcorner_panel extends rounded_panel {
    public JTextField fname;
    public JTextField fdob;
    public JTextField fgender;
    public JTextField fhometown;
    public JTextField faddress;
    public JTextField freligion;
    public JTextField fethnic;
    public JTextField femail;
    public JTextField fphonenumber;

    public Student_edit_leftcorner_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;


        JLabel name = new JLabel();
        name.setText("  Họ và tên:");
        name.setFont(new Font(null, Font.BOLD, 18));

        fname = new JTextField();
        fname.setFont(new Font(null, Font.BOLD, 18));
        fname.setPreferredSize(new Dimension(250, 40));
        fname.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fname.setHorizontalAlignment(JTextField.LEFT);
        fname.setBorder(BorderFactory.createEmptyBorder());
        fname.setOpaque(false);
        fname.setEditable(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(250, 50));
        p1.add(name);
        p1.add(fname);
        add(p1, gbc);

        JLabel dob = new JLabel();
        dob.setText("  Ngày sinh:");
        dob.setFont(new Font(null, Font.BOLD, 18));

        fdob = new JTextField();
        fdob.setFont(new Font(null, Font.BOLD, 18));
        fdob.setPreferredSize(new Dimension(250, 40));
        fdob.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fdob.setHorizontalAlignment(JTextField.LEFT);
        fdob.setBorder(BorderFactory.createEmptyBorder());
        fdob.setOpaque(false);
        fdob.setEditable(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(250, 50));
        p2.add(dob);
        p2.add(fdob);
        gbc.gridy = 1;
        add(p2, gbc);

        JLabel gender = new JLabel();
        gender.setText("  Giới tính: ");
        gender.setFont(new Font(null, Font.BOLD, 18));

        fgender = new JTextField();
        fgender.setFont(new Font(null, Font.BOLD, 18));
        fgender.setPreferredSize(new Dimension(250, 40));
        fgender.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fgender.setHorizontalAlignment(JTextField.LEFT);
        fgender.setBorder(BorderFactory.createEmptyBorder());
        fgender.setOpaque(false);
        fgender.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(250, 50));
        p3.add(gender);
        p3.add(fgender);
        gbc.gridy = 2;
        add(p3, gbc);

        JLabel hometown = new JLabel();
        hometown.setText("  Quê quán: ");
        hometown.setFont(new Font(null, Font.BOLD, 18));

        fhometown = new JTextField();
        fhometown.setFont(new Font(null, Font.BOLD, 18));
        fhometown.setPreferredSize(new Dimension(250, 40));
        fhometown.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fhometown.setHorizontalAlignment(JTextField.LEFT);
        fhometown.setBorder(BorderFactory.createEmptyBorder());
        fhometown.setOpaque(false);
        fhometown.setEditable(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(250, 50));
        p4.add(hometown);
        p4.add(fhometown);
        gbc.gridy = 3;
        add(p4, gbc);

        JLabel address = new JLabel();
        address.setText("  Địa chỉ: ");
        address.setFont(new Font(null, Font.BOLD, 18));

        faddress = new JTextField();
        faddress.setFont(new Font(null, Font.BOLD, 18));
        faddress.setPreferredSize(new Dimension(300, 40));
        faddress.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        faddress.setHorizontalAlignment(JTextField.LEFT);
        faddress.setBorder(BorderFactory.createEmptyBorder());
        faddress.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(200, 50));
        p5.add(address);
        p5.add(faddress);
        gbc.gridy = 4;
        add(p5, gbc);

        JLabel religion = new JLabel();
        religion.setText("  Quốc tịch: ");
        religion.setFont(new Font(null, Font.BOLD, 18));

        freligion = new JTextField();
        freligion.setFont(new Font(null, Font.BOLD, 18));
        freligion.setPreferredSize(new Dimension(250, 40));
        freligion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        freligion.setHorizontalAlignment(JTextField.LEFT);
        freligion.setBorder(BorderFactory.createEmptyBorder());
        freligion.setOpaque(false);
        freligion.setEditable(false);

        JPanel p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(200, 50));
        p6.add(religion);
        p6.add(freligion);
        gbc.gridy = 5;
        add(p6, gbc);

        JLabel ethnic = new JLabel();
        ethnic.setText("  Dân tộc: ");
        ethnic.setFont(new Font(null, Font.BOLD, 18));

        fethnic = new JTextField();
        fethnic.setFont(new Font(null, Font.BOLD, 18));
        fethnic.setPreferredSize(new Dimension(250, 40));
        fethnic.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fethnic.setHorizontalAlignment(JTextField.LEFT);
        fethnic.setBorder(BorderFactory.createEmptyBorder());
        fethnic.setOpaque(false);
        fethnic.setEditable(false);

        JPanel p7 = new JPanel();
        p7.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(250, 50));
        p7.add(ethnic);
        p7.add(fethnic);
        gbc.gridy = 6;
        add(p7, gbc);

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
