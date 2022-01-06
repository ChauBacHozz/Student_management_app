package admin.teacher_panel;

import prototype.rounded_button;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teacher_view_toppanel extends JPanel implements ActionListener {
    public rounded_button find;
    public rounded_button delete;
    public textfield_type getId;
    public Teacher_view_toppanel() {
        setOpaque(false);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JLabel addId = new JLabel();
        addId.setText("Nhập tên giảng viên:");
        addId.setFont(new Font(null, Font.ITALIC, 30));
        gbc.fill = GridBagConstraints.NONE;


        getId = new textfield_type();
        getId.setFont(new Font(null, Font.ITALIC, 30));
        getId.setPreferredSize(new Dimension(370, 60));
        getId.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        getId.setHorizontalAlignment(JTextField.CENTER);
        add(getId);
//        JPanel p3 = new JPanel();
//        p3.setBackground(Color.cyan);

        find = new rounded_button("Tìm kiếm",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        find.setPreferredSize(new Dimension(140, 60));
        find.setFont(new Font(null, Font.BOLD, 22));
        find.addActionListener(this);

        delete = new rounded_button("Xóa GV",
                new Color(245, 220, 100), new Color(220, 159, 56), "find");
        delete.setPreferredSize(new Dimension(140, 60));
        delete.setFont(new Font(null, Font.BOLD, 22));
        delete.addActionListener(this);
        add(addId);

        add(getId);
        add(find);
        add(delete);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

