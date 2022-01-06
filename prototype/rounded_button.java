package prototype;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class rounded_button extends JButton {
    Color color;
    Color second_color;
    private int arc = 40;
    private int clicked = 0;
    private String name;
    public  rounded_button(String label, Color color, Color second_color) {
        super(label);
        setFocusable(false);
        this.color = color;
        this.second_color = second_color;
// This call causes the JButton not to paint
        // the background.
// This allows us to paint a round background.
        setContentAreaFilled(false);
    }
    public rounded_button(String label, Color color, Color second_color, String name) {
        super(label);
        setFocusable(false);
        this.color = color;
        this.second_color = second_color;
        this.name = name;
// This call causes the JButton not to paint
        // the background.
// This allows us to paint a round background.
        setContentAreaFilled(false);
    }

    public void setArc(int arc) {
        this.arc = arc;
    }

    // Paint the round background and label.
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
// You might want to make the highlight color
            // a property of the RoundButton class.
            g.setColor(second_color);
        } else {
            g.setColor(color);
        }
        g.fillRoundRect(0, 0, getSize().width - 1,
                getSize().height - 1, arc, arc);

// This call will paint the label and the
        // focus rectangle.
        super.paintComponent(g);
    }

    // Paint the border of the button using a simple stroke.
    protected void paintBorder(Graphics g) {
        g.setColor(color);
        g.drawRoundRect(0, 0, getSize().width - 1,
                getSize().height - 1, arc, arc);
    }

    Shape shape;

    public boolean contains(int x, int y) {
// If the button has changed size,
        // make a new shape object.
        if (shape == null ||
                !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0,
                    getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    public int getClicked() {
        return clicked;
    }

    public void setClicked(int clicked) {
        this.clicked = clicked;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}