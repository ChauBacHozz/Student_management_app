package admin.info_panel;
import admin.Admin;
import lgScreen.main;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Info_panel extends rounded_panel implements ActionListener {
    public info_pleft infoPleft;
    public info_pright infoPright;
    public Info_panel(int radius, Color color){
        super(radius, color);
        setOpaque(false);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        gbc.fill = GridBagConstraints.BOTH;


        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        gbc.weightx = 1;
        gbc.weighty = 0.07;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        add(p1, gbc);

        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(p2, gbc);

        infoPleft = new info_pleft();
        gbc.weightx = 0.5;
        gbc.weighty = 0.9;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        add(infoPleft, gbc);

        JPanel p4 = new JPanel();
        p4.setOpaque(false);
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(p4, gbc);

        infoPright = new info_pright();
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        add(infoPright, gbc);

        JPanel p6 = new JPanel();
        p6.setOpaque(false);
        gbc.weightx = 0.15;
        gbc.weighty = 1;
        gbc.gridx = 4;
        gbc.gridy = 1;
        add(p6, gbc);

        JPanel p7 = new JPanel();
        p7.setOpaque(false);
        gbc.weightx = 1;
        gbc.weighty = 0.07;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        add(p7, gbc);

        infoPleft.save_button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == infoPleft.save_button){
            Admin admin = new Admin();
            admin.setPhone_number(infoPleft.pleft.fphone_number.getText());
            admin.setAddress(infoPleft.pleft.fwork_address.getText());
            admin.setEmail(infoPleft.pleft.femail.getText());
            admin.setStatus(infoPleft.pleft.fstatus.getText());

            admin.setFirstname(infoPright.pright.ffname.getText());
            admin.setLastname(infoPright.pright.flname.getText());
            admin.setUsername(infoPright.pright.fusername.getText());
            admin.setPassword(infoPright.pright.fpassword.getText());

            if (main.exe.updateAdmin(main.conn, admin)){
                    JOptionPane.showMessageDialog(null,
                            "Đã chỉnh sửa thành công",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);

            } else {
                    JOptionPane.showMessageDialog(null,
                            "Đã chỉnh sửa thất bại",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }
}
