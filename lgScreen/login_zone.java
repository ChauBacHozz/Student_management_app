package lgScreen;

import prototype.ava_panel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class login_zone extends JPanel {
    BufferedImage ava;

    public login_zone(){
        setBackground(Color.blue);
        Dimension expectedDimension = new Dimension(500, 550);

        setPreferredSize(expectedDimension);
        setMaximumSize(expectedDimension);
        setMinimumSize(expectedDimension);
        setOpaque(false);
        ava_panel ava = new ava_panel();
        ava.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(ava);

        JPanel trash_panel = new JPanel();
        trash_panel.setOpaque(false);
        trash_panel.setPreferredSize(new Dimension(400, 40));
        trash_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(trash_panel);

        login_panel lg_panel = new login_panel(50, new Color(165, 195, 127, 255));
        lg_panel.setOpaque(false);
        lg_panel.setPreferredSize(new Dimension(450, 270));
        lg_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lg_panel);
    }
}
