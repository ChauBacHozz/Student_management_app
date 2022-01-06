package lgScreen;

import prototype.rounded_button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_panel extends JPanel {
    rounded_button signin;
    rounded_button close;
    private int clicked = 0;

    public Button_panel(){
        setPreferredSize(new Dimension(400, 100));
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        setOpaque(false);

        signin = new rounded_button("Sign in",
                new Color(234, 162, 115, 255),
                new Color(238, 104, 72));
        signin.setPreferredSize(new Dimension(160, 60));
        signin.setFont(new Font(null, Font.BOLD, 20));
        add(signin);

        close = new rounded_button("Close",
                new Color(234, 162, 115, 255),
                new Color(238, 104, 72));
        close.setPreferredSize(new Dimension(160, 60));
        close.setFont(new Font(null, Font.BOLD, 20));
        add(close);
    }

    public int getClicked() {
        return clicked;
    }

    public void setClicked(int clicked) {
        this.clicked = clicked;
    }


}
