package student.menu_panel;

import prototype.logo_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_top_panel extends JPanel implements ActionListener {

    public Menu_top_panel() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        logo_panel logo = new logo_panel();
        logo.setPreferredSize(new Dimension(100, 130));
        add(logo);

        JLabel schoolname = new JLabel();
        schoolname.setText("TRANG THÔNG TIN TRƯỜNG ĐẠI HỌC KHOA HỌC TỰ NHIÊN");
        schoolname.setFont(new Font(null, Font.BOLD, 30));
        add(schoolname);


    }
        @Override
    public void actionPerformed(ActionEvent e) {


    }
}
