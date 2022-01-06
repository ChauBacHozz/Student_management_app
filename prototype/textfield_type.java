package prototype;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class textfield_type extends JTextField {
    private Shape shape;
    public textfield_type() {

        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 60, 60);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 60, 60);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 60, 60);
        }
        return shape.contains(x, y);
    }
}
