package admin.student_panel;

import prototype.rounded_button;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;

public class Student_insert_top_panel extends JPanel {
    rounded_button save;
    rounded_button discard;
    rounded_button insert;

    public Student_insert_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JLabel addId = new JLabel();
        addId.setText("Tạo sinh viên mới: ");
        addId.setFont(new Font(null, Font.ITALIC, 25));

        insert = new rounded_button("Insert",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        insert.setPreferredSize(new Dimension(110, 50));
        insert.setFont(new Font(null, Font.BOLD, 20));


        discard = new rounded_button("Discard",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        discard.setPreferredSize(new Dimension(110, 50));
        discard.setFont(new Font(null, Font.BOLD, 20));


        add(addId);
        add(insert);
        add(discard);

    }

}