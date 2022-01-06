package admin.student_panel;

import prototype.rounded_button;
import prototype.rounded_panel;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_edit_top_panel extends JPanel {
    rounded_button save;
    rounded_button discard;
    rounded_button search;
    textfield_type getId;
    public Student_edit_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JLabel addId = new JLabel();
        addId.setText("Nhập mã sinh viên: ");
        addId.setFont(new Font(null, Font.ITALIC, 25));

        getId = new textfield_type();
        getId.setFont(new Font(null, Font.ITALIC, 25));
        getId.setPreferredSize(new Dimension(400, 50));
        getId.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        getId.setHorizontalAlignment(JTextField.CENTER);

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


        add(addId);
        add(getId);
        add(search);
        add(save);
        add(discard);

    }

}