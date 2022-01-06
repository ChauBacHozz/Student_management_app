package student.info_panel;

import prototype.rounded_button;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;

public class Student_edit_top_panel extends JPanel {
    rounded_button save;

    public Student_edit_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        JLabel addId = new JLabel();
        addId.setText("Xem và chính sửa thông tin sinh viên   ");
        addId.setFont(new Font(null, Font.ITALIC, 30));

        save = new rounded_button("Save",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        save.setPreferredSize(new Dimension(120, 60));
        save.setFont(new Font(null, Font.BOLD, 20));

        add(addId);
        add(save);

    }

}