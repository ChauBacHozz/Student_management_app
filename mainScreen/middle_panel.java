package mainScreen;

import prototype.rounded_panel;
import javax.swing.*;
import java.awt.*;

public class middle_panel extends JPanel {
    public JPanel buttoncenter_panel;
    public rounded_panel view_panel;
    public middle_panel(){
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 0.02f;
        gbc.gridx = 0;
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        add(p1, gbc);

        gbc.weightx = 0.4f;
        gbc.gridx = 1;
        buttoncenter_panel = new JPanel();
        buttoncenter_panel.setOpaque(false);
        add(buttoncenter_panel, gbc);

        gbc.weightx = 0.02f;
        gbc.gridx = 2;
        JPanel p3 = new JPanel();
        p3.setOpaque(false);
        add(p3, gbc);

//        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0.5;
        gbc.gridx = 3;
        view_panel = new rounded_panel(70, Color.GRAY);
        view_panel.setOpaque(false);
        add(view_panel, gbc);

        gbc.weightx = 0.01f;
        gbc.gridx = 4;
        JPanel p5 = new JPanel();
        p5.setOpaque(false);
        add(p5, gbc);

    }
}
