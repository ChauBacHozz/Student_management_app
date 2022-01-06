package prototype;

import javax.swing.*;
import java.awt.*;

public class option_student_teacherpanel extends JPanel {
    public rounded_button student_button;
    public rounded_button teacher_button;

    Color c1 = new Color(234, 162, 133);
    Color c2 = new Color(240, 134, 84);
    public option_student_teacherpanel(){
        setOpaque(false);
        setPreferredSize(new Dimension(100, 70));
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        JPanel p2 = new JPanel();
        p2.setOpaque(false);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.weightx = 1;

        gbc.gridx = 0;
        add(p1, gbc);

        gbc.weighty = 0.8;
        gbc.gridx = 1;
        add(p2, gbc);

        GridBagLayout gbl1 = new GridBagLayout();
        GridBagConstraints gbc1 = new GridBagConstraints();
        p2.setLayout(gbl1);

        gbc1.weighty = 1;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;

        gbc1.gridy = 0;
        student_button = new rounded_button("Sinh viên", c1, c2, "view");
        student_button.setPreferredSize(new Dimension(100, 30));
        p2.add(student_button, gbc1);

        gbc1.gridy = 1;
        teacher_button = new rounded_button("Giảng viên", c1, c2, "edit");
        teacher_button.setPreferredSize(new Dimension(100, 30));
        p2.add(teacher_button, gbc1);
    }
}
