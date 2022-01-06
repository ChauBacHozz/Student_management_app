package student.menu_panel;

import javax.swing.*;
import java.awt.*;

public class Menu_mid_panel extends JPanel {

    public Menu_mid_leftcorner_panel lpanel = new Menu_mid_leftcorner_panel(40,Color.WHITE);
    public Menu_mid_rightcorner_panel rpanel = new Menu_mid_rightcorner_panel(40,Color.WHITE);
    public Menu_mid_panel() {
        setOpaque(false);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel p1 = new JPanel();
        p1.setOpaque(false);

        lpanel.setOpaque(false);

        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        rpanel.setOpaque(false);

        JPanel p5 = new JPanel();
        p5.setOpaque(false);

        gbc.weightx=0.15;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(p1,gbc);

        gbc.weightx=0.3;
        gbc.gridy = 0;
        gbc.gridx = 1;
        add(lpanel,gbc);

        gbc.weightx=0.1;
        gbc.gridx= 2;
        gbc.gridy = 0;
        add(p3,gbc);

        gbc.weightx=0.15;
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(rpanel,gbc);

        gbc.weightx=0.15;
        gbc.gridx = 4;
        gbc.gridy = 0;
        add(p5,gbc);


    }
}
