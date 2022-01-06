package admin.info_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class info_right_minipanel extends rounded_panel{
    public JTextField ffname;
    public JTextField flname;
    public JTextField fusername;
    public JTextField fpassword;
    public info_right_minipanel(int radius, Color bgColor) {
        super(radius, bgColor);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;


        JLabel fname = new JLabel();
        fname.setText("  Họ: ");
        fname.setFont(new Font(null, Font.BOLD, 18));

        ffname = new JTextField();
        ffname.setFont(new Font(null, Font.BOLD, 18));
        ffname.setPreferredSize(new Dimension(150, 40));
        ffname.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        ffname.setHorizontalAlignment(JTextField.LEFT);
        ffname.setBorder(BorderFactory.createEmptyBorder());
        ffname.setOpaque(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(150, 50));
        p1.add(fname);
        p1.add(ffname);
        add(p1, gbc);

        JLabel lname = new JLabel();
        lname.setText("  Tên: ");
        lname.setFont(new Font(null, Font.BOLD, 18));

        flname = new JTextField();
        flname.setFont(new Font(null, Font.BOLD, 18));
        flname.setPreferredSize(new Dimension(150, 40));
        flname.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        flname.setHorizontalAlignment(JTextField.LEFT);
        flname.setBorder(BorderFactory.createEmptyBorder());
        flname.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(150, 50));
        p2.add(lname);
        p2.add(flname);
        gbc.gridy = 1;
        add(p2, gbc);

        JLabel username = new JLabel();
        username.setText("  Username: ");
        username.setFont(new Font(null, Font.BOLD, 18));

        fusername = new JTextField();
        fusername.setFont(new Font(null, Font.BOLD, 18));
        fusername.setPreferredSize(new Dimension(150, 40));
        fusername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fusername.setHorizontalAlignment(JTextField.LEFT);
        fusername.setBorder(BorderFactory.createEmptyBorder());
        fusername.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(150, 50));
        p3.add(username);
        p3.add(fusername);
        gbc.gridy = 2;
        add(p3, gbc);

        JLabel password = new JLabel();
        password.setText("  Password: ");
        password.setFont(new Font(null, Font.BOLD, 18));

        fpassword = new JTextField();
        fpassword.setFont(new Font(null, Font.BOLD, 18));
        fpassword.setPreferredSize(new Dimension(150, 40));
        fpassword.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fpassword.setHorizontalAlignment(JTextField.LEFT);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(150, 50));
        p4.add(password);
        p4.add(fpassword);
        gbc.gridy = 3;
        add(p4, gbc);

    }
}
