package teacher.info_panel;

import prototype.rounded_button;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;

public class Teacher_edit_top_panel extends JPanel {
    rounded_button save;
    rounded_button discard;
    rounded_button search;
    public Teacher_edit_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 90, 0));

        JLabel addname = new JLabel();
        addname.setText("Xem và chỉnh sửa thông tin giảng viên: ");
        addname.setFont(new Font(null, Font.ITALIC, 35));


        save = new rounded_button("Save",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        save.setPreferredSize(new Dimension(110, 50));
        save.setFont(new Font(null, Font.BOLD, 20));


        add(addname);
        add(save);

    }

}