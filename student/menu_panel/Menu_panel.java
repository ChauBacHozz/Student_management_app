package student.menu_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Menu_panel extends rounded_panel{
    static GridBagLayout gbl = new GridBagLayout();
    public Menu_mid_panel p2;
    public Menu_panel(int radius, Color color){
        super(radius, color);
        setOpaque(false);
        setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        JPanel p1 = new Menu_top_panel();

        p2 = new Menu_mid_panel();
        p2.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        gbc.weighty = 0.01;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(p1,gbc);

        gbc.weighty = 0.5;
        gbc.gridx =0;
        gbc.gridy =1;
        add(p2,gbc);

        gbc.weighty = 0.001;
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(p3,gbc);

    }
}
