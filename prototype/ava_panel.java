package prototype;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ava_panel extends JPanel {
    private BufferedImage avatar;

    {
        try {
            avatar = ImageIO.read(new File("resource/ava.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ava_panel(){
        setPreferredSize(new Dimension(200, 200));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(avatar, 0, 0, getWidth(), getHeight(), this);

    }
}
