package mainScreen;

import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {
    protected middle_panel mid_panel;
    public top_panel toppanel;
    public mainPanel(){
//        setPreferredSize(new Dimension(800, 600));
//        setBackground(new Color(255, 255, 217));
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.03f;
        toppanel = new top_panel();
        toppanel.setBackground(Color.RED);
        toppanel.setOpaque(false);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(toppanel, gbc);

        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        gbc.weighty = 0.005f;
        gbc.gridy = 1;
        add(p2, gbc);

        mid_panel = new middle_panel();
        mid_panel.setBackground(Color.YELLOW);
        gbc.weighty = 0.9f;
        gbc.gridy = 2;
        add(mid_panel, gbc);

        JPanel p4 = new JPanel();
        p4.setBackground(Color.BLUE);
        p4.setOpaque(false);
        gbc.weighty = 0.02f;
        gbc.gridy = 3;
        add(p4, gbc);


    }
    public top_panel getToppanel(){
        return toppanel;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(249, 246, 210);
        Color color2 = new Color(242, 226, 103);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
