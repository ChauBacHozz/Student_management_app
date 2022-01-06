package admin.info_panel;

import prototype.rounded_button;

import javax.swing.*;
import java.awt.*;

public class info_pleft extends JPanel {
    public info_left_minipanel pleft;
    public rounded_button save_button;
    public info_pleft(){
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        gbc.fill = GridBagConstraints.BOTH;
        pleft = new info_left_minipanel(40, Color.WHITE);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 0;
        add(pleft, gbc);

        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        gbc.weightx = 1;
        gbc.weighty = 0.02;
        gbc.gridy = 1;
        add(p1, gbc);

        save_button = new rounded_button("Lưu thông tin quản trị viên",
                new Color(255, 243, 149),
                new Color(245, 220, 100));
        save_button.setFont(new Font(null, Font.BOLD, 26));
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        gbc.gridy = 2;
        add(save_button, gbc);
    }
}
