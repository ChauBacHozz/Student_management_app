package lgScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class login_screen extends JPanel {
    public login_zone lg;
    private BufferedImage background;

    {
        try {
            background = ImageIO.read(new File("resource/login.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public login_screen(){
        setMinimumSize(new Dimension(1000, 650));
        setLayout(new BorderLayout());

        lg = new login_zone();
        lg.setBackground(Color.RED); // for debug only
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(lg);
        box.add(Box.createVerticalGlue());

        add(box);

    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    }
}
