package admin.info_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class info_left_minipanel extends rounded_panel{
    public JTextField femail;
    public JTextField fphone_number;
    public JTextField fstatus;
    public JTextField fwork_address;
    public info_left_minipanel(int radius, Color bgColor) {
        super(radius, bgColor);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;


        JLabel email = new JLabel();
        email.setText("  Email:");
        email.setFont(new Font(null, Font.BOLD, 18));

        femail = new JTextField();
        femail.setFont(new Font(null, Font.BOLD, 18));
        femail.setPreferredSize(new Dimension(300, 40));
        femail.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        femail.setHorizontalAlignment(JTextField.LEFT);
        femail.setBorder(BorderFactory.createEmptyBorder());
        femail.setOpaque(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(150, 50));
        p1.add(email);
        p1.add(femail);
        add(p1, gbc);

        JLabel phone_number = new JLabel();
        phone_number.setText("  Số điện thoại:");
        phone_number.setFont(new Font(null, Font.BOLD, 18));

        fphone_number = new JTextField();
        fphone_number.setFont(new Font(null, Font.BOLD, 18));
        fphone_number.setPreferredSize(new Dimension(150, 40));
        fphone_number.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fphone_number.setHorizontalAlignment(JTextField.LEFT);
        fphone_number.setBorder(BorderFactory.createEmptyBorder());
        fphone_number.setOpaque(false);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(150, 50));
        p2.add(phone_number);
        p2.add(fphone_number);
        gbc.gridy = 1;
        add(p2, gbc);

        JLabel status = new JLabel();
        status.setText("  Trạng thái: ");
        status.setFont(new Font(null, Font.BOLD, 18));

        fstatus = new JTextField();
        fstatus.setFont(new Font(null, Font.BOLD, 18));
        fstatus.setPreferredSize(new Dimension(150, 40));
        fstatus.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fstatus.setHorizontalAlignment(JTextField.LEFT);
        fstatus.setBorder(BorderFactory.createEmptyBorder());
        fstatus.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(150, 50));
        p3.add(status);
        p3.add(fstatus);
        gbc.gridy = 2;
        add(p3, gbc);

        JLabel work_address = new JLabel();
        work_address.setText("  Nơi làm việc: ");
        work_address.setFont(new Font(null, Font.BOLD, 18));

        fwork_address = new JTextField();
        fwork_address.setFont(new Font(null, Font.BOLD, 18));
        fwork_address.setPreferredSize(new Dimension(330, 40));
        fwork_address.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        fwork_address.setHorizontalAlignment(JTextField.LEFT);
        fwork_address.setBorder(BorderFactory.createEmptyBorder());
        fwork_address.setOpaque(false);

        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(250, 50));
        p4.add(work_address);
        p4.add(fwork_address);
        gbc.gridy = 3;
        add(p4, gbc);

    }
}
