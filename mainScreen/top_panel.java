package mainScreen;

import lgScreen.main;
import prototype.ava_panel;
import prototype.rounded_button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class top_panel extends JPanel implements ActionListener {
    public JLabel username_label;
    public rounded_button exit;
    public rounded_button log_out;
    public top_panel(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weighty = 1;

        gbc.fill = GridBagConstraints.BOTH;
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        gbc.weightx = 0.04f;
        gbc.gridx = 0;
        add(p1, gbc);

        gbc.fill = GridBagConstraints.NONE;
        ava_panel p2 = new ava_panel();
        p2.setPreferredSize(new Dimension(70, 70));
        gbc.weightx = 0.01f;
        gbc.weighty = 0.2f;
        gbc.gridx = 1;
        add(p2, gbc);

//        JPanel p3 = new JPanel();
//        p3.setOpaque(false);
//        gbc.weightx = 0.01f;
//        gbc.gridx = 4;
//        add(p3, gbc);

        username_label = new JLabel("Xin chào");
        username_label.setFont(new Font(null, Font.ITALIC, 23));
        gbc.fill = GridBagConstraints.NONE;
        JPanel p4 = new JPanel();
        p4.setBackground(Color.YELLOW);
        p4.setOpaque(false);
        p4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        p4.add(username_label);
        gbc.weightx = 0.02f;
        gbc.weighty = 1;
        gbc.gridx = 2;
        add(p4, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        JPanel p3 = new JPanel();
        p3.setOpaque(false );
        gbc.weightx = 1;
        gbc.gridx = 3;
        add(p3, gbc);

        exit = new rounded_button("Exit",
                new Color(245, 220, 100), new Color(220, 159, 56), "signout");
        exit.setPreferredSize(new Dimension(130, 50));
        exit.setFont(new Font(null, Font.BOLD, 20));
        exit.addActionListener(this);
//        sign_out.setForeground(new Color(255,255,255));
        log_out = new rounded_button("Đăng xuất",
                new Color(164, 248, 203, 255), new Color(46, 135, 198, 220), "exit");
        log_out.setPreferredSize(new Dimension(130, 50));
        log_out.setFont(new Font(null, Font.BOLD, 20));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel p6 = new JPanel();
        p6.setBackground(Color.GREEN);
        p6.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 0));
        p6.setOpaque(false);
        p6.add(log_out);
        p6.add(exit);
        gbc.weightx = 0.03f;
        gbc.gridx = 4;
        add(p6, gbc);

        JPanel p7 = new JPanel();
        p7.setOpaque(false);
        gbc.weightx = 0.01f;
        gbc.gridx = 5;
        add(p7, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            System.exit(0);
        }
    }
}
