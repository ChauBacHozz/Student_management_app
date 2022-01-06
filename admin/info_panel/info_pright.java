package admin.info_panel;

import prototype.logo_longpanel;

import javax.swing.*;
import java.awt.*;

public class info_pright extends JPanel {
    public info_right_minipanel pright;
    public info_pright(){
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.BOTH;

        logo_longpanel p1 = new logo_longpanel();
        gbc.weightx = 1;
        gbc.weighty = 0.4;
        gbc.gridy = 0;
        add(p1, gbc);

        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        gbc.weightx = 1;
        gbc.weighty = 0.02;
        gbc.gridy = 1;
        add(p2, gbc);

        pright = new info_right_minipanel(40, Color.WHITE);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 2;
        add(pright, gbc);


    }
}
