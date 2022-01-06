package admin.teacher_panel;

import prototype.rounded_button;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;

public class Teacher_edit_top_panel extends JPanel {
    rounded_button save;
    rounded_button discard;
    rounded_button search;
    textfield_type getCMND;
    public Teacher_edit_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JLabel addname = new JLabel();
        addname.setText("Nhập CMND giảng viên: ");
        addname.setFont(new Font(null, Font.ITALIC, 25));

        getCMND = new textfield_type();
        getCMND.setFont(new Font(null, Font.ITALIC, 25));
        getCMND.setPreferredSize(new Dimension(300, 50));
        getCMND.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        getCMND.setHorizontalAlignment(JTextField.CENTER);

        search = new rounded_button("Search",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        search.setPreferredSize(new Dimension(110, 50));
        search.setFont(new Font(null, Font.BOLD, 20));

        save = new rounded_button("Save",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        save.setPreferredSize(new Dimension(110, 50));
        save.setFont(new Font(null, Font.BOLD, 20));

        discard = new rounded_button("Discard",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        discard.setPreferredSize(new Dimension(110, 50));
        discard.setFont(new Font(null, Font.BOLD, 20));


        add(addname);
        add(getCMND);
        add(search);
        add(save);
        add(discard);

    }

}