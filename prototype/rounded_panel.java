package prototype;

import javax.swing.*;
import java.awt.*;

public class rounded_panel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public rounded_panel(int radius){
            super();
            cornerRadius = radius;
        }
        public rounded_panel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(backgroundColor);
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }

}
