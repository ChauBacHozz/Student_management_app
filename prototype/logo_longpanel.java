package prototype;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class logo_longpanel extends JPanel {
    private BufferedImage logo;

    {
        try {
            logo = ImageIO.read(new File("resource/hus_longlogo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public logo_longpanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(logo,  10, 0, getWidth() - 20, getHeight(), this);

    }
}
