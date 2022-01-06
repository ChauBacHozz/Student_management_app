package prototype;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class logo_panel extends JPanel {
    private BufferedImage logo;

    {
        try {
            logo = ImageIO.read(new File("resource/hus_logo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public logo_panel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(logo, 0, 0, getWidth(), getHeight(), this);

    }
}
