package student.info_panel;
import lgScreen.main;
import mainScreen.mainPanel;

import mainScreen.top_panel;
import prototype.rounded_button;
import student.class_panel.Class_panel;
import student.class_panel.Student_table;
import student.menu_panel.Menu_panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;

public class student_panel extends mainPanel implements ActionListener {

    rounded_button menu_button;
    rounded_button class_button;
    rounded_button info_button;

    Color c1 = new Color(234, 162, 133);
    Color c2 = new Color(240, 134, 84);

    CardLayout cl = new CardLayout();
    Student_edit_panel student_view_panel;
    Menu_panel menu_panel;
    Class_panel class_panel;
    public student_panel(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mid_panel.buttoncenter_panel.setLayout(gbl);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0.1f;

        menu_button = new rounded_button("Trang chủ", c1, c2);
        menu_button.addActionListener(this);
        menu_button.setPreferredSize(new Dimension(100, 60));
        menu_button.setFont(new Font(null, Font.BOLD, 20));
        menu_button.setArc(25);
        gbc.gridy = 0;
        mid_panel.buttoncenter_panel.add(menu_button, gbc);


        class_button = new rounded_button("Lớp học", c1, c2);
        class_button.addActionListener(this);
        class_button.setPreferredSize(new Dimension(100, 60));
        class_button.setFont(new Font(null, Font.BOLD, 20));
        class_button.setArc(25);
        gbc.gridy = 1;
        mid_panel.buttoncenter_panel.add(class_button, gbc);

        info_button = new rounded_button("Thông tin", c1, c2);
        info_button.addActionListener(this);
        info_button.setPreferredSize(new Dimension(100, 60));
        info_button.setFont(new Font(null, Font.BOLD, 20));
        info_button.setArc(25);
        gbc.gridy = 2;
        mid_panel.buttoncenter_panel.add(info_button, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        gbc.weighty = 1;
        gbc.gridy = 7;
        mid_panel.buttoncenter_panel.add(p1, gbc);

        mid_panel.view_panel.setLayout(cl);
        menu_panel = new Menu_panel(70, new Color(195, 175, 145));
        class_panel = new Class_panel(70, new Color(195, 175, 145));
        student_view_panel = new Student_edit_panel(70, new Color(195, 175, 145));
        mid_panel.view_panel.add(menu_panel, "menu_panel");
        mid_panel.view_panel.add(class_panel, "class_panel");
        mid_panel.view_panel.add(student_view_panel, "info_panel");

        cl.show(mid_panel.view_panel, "view_panel");

    }
    @Override
    public top_panel getToppanel(){
        return toppanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu_button){
            cl.show(mid_panel.view_panel, "menu_panel");
        }
        if (e.getSource() == class_button){
            try {
                cl.show(mid_panel.view_panel, "class_panel");
                while(main.rs_user.next()){
                    class_panel.ptop.removeAll();
                    class_panel.pmid.removeAll();

                    Student_table st = new Student_table(main.rs_user.getString("major"),
                            main.rs_user.getString("school year"));
                    st.setBorder(new LineBorder(new Color(159, 99, 62), 10, true));
                    class_panel.pmid.add(st);
                    JLabel label = new JLabel("Danh sách sinh viên lớp "
                            + main.rs_user.getString("school year")
                            + " " + main.rs_user.getString("major")
                            , JLabel.CENTER);
                    label.setFont(new Font(null, Font.ITALIC, 30));
                    class_panel.ptop.add(label, BorderLayout.CENTER);
                    student_view_panel.pmid.lpanel.faddress.setText(main.rs_user.getString("address"));
                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    student_view_panel.pmid.lpanel.fdob.setText(formatter.format(main.rs_user.getDate("date_of_birth").getTime()));
                    student_view_panel.pmid.lpanel.femail.setText(main.rs_user.getString("email"));
                    student_view_panel.pmid.lpanel.fethnic.setText(main.rs_user.getString("ethnic"));
                    student_view_panel.pmid.lpanel.fgender.setText(main.rs_user.getString("gender"));
                    student_view_panel.pmid.lpanel.fhometown.setText(main.rs_user.getString("home_town"));
                    student_view_panel.pmid.lpanel.fname.setText(main.rs_user.getString("fname") + main.rs_user.getString("lname"));
                    student_view_panel.pmid.lpanel.fphonenumber.setText(main.rs_user.getString("phone_number"));
                    student_view_panel.pmid.lpanel.freligion.setText(main.rs_user.getString("religion"));

                    student_view_panel.pmid.rpanel.fiD_number.setText(main.rs_user.getString("CMND"));
                    student_view_panel.pmid.rpanel.fdepartment.setText(main.rs_user.getString("department"));
                    student_view_panel.pmid.rpanel.fgpa.setText(Float.toString(main.rs_user.getFloat("GPA")));
                    student_view_panel.pmid.rpanel.fmajor.setText(main.rs_user.getString("major"));
                    student_view_panel.pmid.rpanel.fpassword.setText(main.rs_user.getString("password"));
                    student_view_panel.pmid.rpanel.fschool_year.setText(main.rs_user.getString("school year"));
                    student_view_panel.pmid.rpanel.fstatus.setText(main.rs_user.getString("status"));
                    student_view_panel.pmid.rpanel.fusername.setText(main.rs_user.getString("username"));
                    student_view_panel.pmid.rpanel.fstudent_id.setText(Integer.toString(main.rs_user.getInt("msv")));
                    getToppanel().username_label.setText("Xin chào " + main.rs_user.getString("fname") + main.rs_user.getString("lname"));


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource() == info_button){
            cl.show(mid_panel.view_panel, "info_panel");
            try {
                while (main.rs_user.next()){
                    class_panel.ptop.removeAll();
                    class_panel.pmid.removeAll();

                    Student_table st = new Student_table(main.rs_user.getString("major"),
                            main.rs_user.getString("school year"));
                    st.setBorder(new LineBorder(new Color(159, 99, 62), 10, true));
                    class_panel.pmid.add(st);
                    JLabel label = new JLabel("Danh sách sinh viên lớp "
                            + main.rs_user.getString("school year")
                            + " " + main.rs_user.getString("major")
                            , JLabel.CENTER);
                    label.setFont(new Font(null, Font.ITALIC, 30));
                    class_panel.ptop.add(label, BorderLayout.CENTER);
                    student_view_panel.pmid.lpanel.faddress.setText(main.rs_user.getString("address"));
                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    student_view_panel.pmid.lpanel.fdob.setText(formatter.format(main.rs_user.getDate("date_of_birth").getTime()));
                    student_view_panel.pmid.lpanel.femail.setText(main.rs_user.getString("email"));
                    student_view_panel.pmid.lpanel.fethnic.setText(main.rs_user.getString("ethnic"));
                    student_view_panel.pmid.lpanel.fgender.setText(main.rs_user.getString("gender"));
                    student_view_panel.pmid.lpanel.fhometown.setText(main.rs_user.getString("home_town"));
                    student_view_panel.pmid.lpanel.fname.setText(main.rs_user.getString("fname") + main.rs_user.getString("lname"));
                    student_view_panel.pmid.lpanel.fphonenumber.setText(main.rs_user.getString("phone_number"));
                    student_view_panel.pmid.lpanel.freligion.setText(main.rs_user.getString("religion"));

                    student_view_panel.pmid.rpanel.fiD_number.setText(main.rs_user.getString("CMND"));
                    student_view_panel.pmid.rpanel.fdepartment.setText(main.rs_user.getString("department"));
                    student_view_panel.pmid.rpanel.fgpa.setText(Float.toString(main.rs_user.getFloat("GPA")));
                    student_view_panel.pmid.rpanel.fmajor.setText(main.rs_user.getString("major"));
                    student_view_panel.pmid.rpanel.fpassword.setText(main.rs_user.getString("password"));
                    student_view_panel.pmid.rpanel.fschool_year.setText(main.rs_user.getString("school year"));
                    student_view_panel.pmid.rpanel.fstatus.setText(main.rs_user.getString("status"));
                    student_view_panel.pmid.rpanel.fusername.setText(main.rs_user.getString("username"));
                    student_view_panel.pmid.rpanel.fstudent_id.setText(Integer.toString(main.rs_user.getInt("msv")));
                    getToppanel().username_label.setText("Xin chào " + main.rs_user.getString("fname") + main.rs_user.getString("lname"));

                }

            } catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
