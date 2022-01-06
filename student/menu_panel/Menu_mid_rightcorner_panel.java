package student.menu_panel;

import lgScreen.main;
import prototype.CircularProgressBar;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;

public class Menu_mid_rightcorner_panel extends rounded_panel {

    public CircularProgressBar gpa;
    public Menu_mid_rightcorner_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        float ave_gpa = 0;
        try {
            ave_gpa = main.exe.getAveGPA(main.conn);

        } catch (Exception e){
            e.printStackTrace();
        }
        gpa = new CircularProgressBar(ave_gpa, 80);
        gpa.setOpaque(false);
        gpa.setPreferredSize(new Dimension(200, 160));
        JLabel gpa_label = new JLabel("<html>GPA TRUNG BÌNH <br>TOÀN TRƯỜNG");
        gpa_label.setFont(new Font(null, Font.BOLD, 30));
        JPanel p0 = new JPanel();
        p0.setOpaque(false);
        p0.setLayout(new FlowLayout(FlowLayout.CENTER));
        p0.setBackground(Color.BLUE);
        p0.add(gpa_label);
        gbc.weighty = 0.2;
        p0.add(gpa);

        gbc.gridy = 0;
        gbc.weighty = 0.9;
        add(p0, gbc);

        JLabel infomation = new JLabel();
        infomation.setText("THÔNG TIN LIÊN LẠC");
        infomation.setFont(new Font(null, Font.BOLD, 30));

        JPanel p1 = new rounded_panel(20, new Color(177, 168, 233));;
        p1.setPreferredSize(new Dimension(370, 90));
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.weightx = 1;
        gbc2.weighty = 1;
        gbc2.fill = GridBagConstraints.NONE;
        p1.setOpaque(false);
        p1.add(infomation, gbc2);
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.NONE;
        add(p1, gbc);


//        jLabel.setText("<html>dong 1<br>dong 2<br>dong 3");

        JLabel address = new JLabel();
        address.setOpaque(false);
//        address.setLineWrap(true);
//        address.setPreferredSize(new Dimension(610, 125));
        address.setText("<html> Địa chỉ: số 334 đường Nguyễn Trãi,<br> phường Thanh Xuân Trung, <br> quận Thanh Xuân, thành phố Hà Nội <br> " +
                "Số điện thoại: (84) 0243-8584615/8581419 <br> Địa chỉ email: hus@vnu.edu.vn hoặc <br>admin@hus.edu.vn <br> FAX: 0243-85843016 ");
        address.setFont(new Font(null, Font.PLAIN, 19));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        p2.setOpaque(false);
        p2.add(address);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(p2, gbc);


    }
    public void update_gpa(){
        try {
            gpa.setGpa(main.exe.getAveGPA(main.conn));
            gpa.repaint();
            gpa.revalidate();
        } catch (Exception e){

        }
    }
}
