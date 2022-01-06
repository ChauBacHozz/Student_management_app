package admin.class_panel;
import prototype.logo_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Class_panel extends rounded_panel{
    public Class_mid_panel pmid;
    public Class_panel(int radius, Color color){
        super(radius, color);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        JPanel p1 = new JPanel();
        p1.setOpaque(false);

        JPanel ptop = new JPanel();
        ptop.setOpaque(false);
        ptop.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        logo_panel logo = new logo_panel();
        logo.setPreferredSize(new Dimension(100, 130));
        ptop.add(logo);

        pmid = new Class_mid_panel();
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.001;
        gbc.gridy = 0;
        add(p1, gbc);
        gbc.weighty = 0.03;
        gbc.gridy = 1;
        add(ptop, gbc);
        gbc.weighty = 1;
        gbc.gridy = 2;
        add(pmid, gbc);
        gbc.weighty = 0.001;
        gbc.gridy = 3;
        add(p2, gbc);


    }
}

