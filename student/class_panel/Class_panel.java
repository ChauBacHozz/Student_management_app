package student.class_panel;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Class_panel extends rounded_panel{
    public JPanel ptop;
    public JPanel pmid;
    public Class_panel(int radius, Color color){
        super(radius, color);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        ptop = new JPanel();
        ptop.setOpaque(false);
        ptop.setLayout(new BorderLayout());

        pmid = new JPanel();
        pmid.setOpaque(false);
        pmid.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.4;
        gbc.gridy = 0;
        add(ptop, gbc);

        gbc.weighty = 0.6;
        gbc.gridy = 1;
        add(pmid, gbc);

    }
}
