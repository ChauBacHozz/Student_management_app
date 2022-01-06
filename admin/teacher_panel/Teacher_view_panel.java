package admin.teacher_panel;

import admin.admin_panel;
import admin.student_panel.Student_view_middlepanel;
import admin.student_panel.Student_view_toppanel;
import lgScreen.main;
import prototype.rounded_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher_view_panel extends rounded_panel implements ActionListener {
    public Teacher_view_toppanel ptop;
    public Teacher_view_middlepanel pmid;

    public Teacher_view_panel(int radius) {
        super(radius);
    }

    public Teacher_view_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        ptop = new Teacher_view_toppanel();
        ptop.setOpaque(false);

        pmid = new Teacher_view_middlepanel();
        pmid.setOpaque(false);


        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        gbc.weighty = 0.1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(ptop, gbc);

        gbc.weighty = 0.8;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(pmid, gbc);

        gbc.weighty = 0.01;
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(p3, gbc);

        ptop.find.addActionListener(this);
        ptop.delete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ptop.find) {
            try {
                ResultSet rs = main.exe.searchTeacher(main.conn, (ptop.getId.getText()));
                while (rs.next()) {
                    pmid.mini_middel_panel.leftcorner_panel.fname.setText(rs.getString("fname") + " " + rs.getString("lname"));
                    pmid.mini_middel_panel.leftcorner_panel.fdob.setText(rs.getDate("date_of_birth").toString());
                    pmid.mini_middel_panel.leftcorner_panel.fgender.setText(rs.getString("gender"));
                    pmid.mini_middel_panel.leftcorner_panel.fhometown.setText(rs.getString("hometown"));
                    pmid.mini_middel_panel.leftcorner_panel.faddress.setText(rs.getString("address"));
                    pmid.mini_middel_panel.leftcorner_panel.fphone_number.setText(rs.getString("phone_number"));
                    pmid.mini_middel_panel.leftcorner_panel.femail.setText(rs.getString("email"));

                    pmid.mini_middel_panel.rightcorner_panel.fdepartment.setText(rs.getString("department"));
//                    pmid.mini_middel_panel.rightcorner_panel.fmajor.setText(rs.getString("major"));
//                    pmid.mini_middel_panel.rightcorner_panel.fschool_year.setText(rs.getString("school year"));
//                    pmid.mini_middel_panel.rightcorner_panel.fgpa.setText(rs.getString("GPA"));
                    pmid.mini_middel_panel.rightcorner_panel.fusername.setText(rs.getString("username"));
                    pmid.mini_middel_panel.rightcorner_panel.fpassword.setText(rs.getString("password"));
                    pmid.mini_middel_panel.rightcorner_panel.fethnic.setText(rs.getString("ethnic"));
                    pmid.mini_middel_panel.rightcorner_panel.freligion.setText(rs.getString("religion"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == ptop.delete) {
            String alpha = pmid.mini_middel_panel.leftcorner_panel.fname.getText();
            if (alpha.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Hãy chọn ra một giảng viên để xóa!",
                        "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("something");
                if (main.exe.deleteTeacher(pmid.mini_middel_panel.rightcorner_panel.fusername.getText(), main.conn)) {
                    JOptionPane.showMessageDialog(null,
                            "Đã xóa thành công!",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);
                    admin_panel.department_teacher_panel.pmid.update();
                    admin_panel.menu_panel.p2.lpanel.update();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Đã xóa thất bại!",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }
}


