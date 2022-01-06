package admin.teacher_panel;

import admin.admin_panel;
import admin.student_panel.Student_edit_middle_panel;
import admin.student_panel.Student_edit_top_panel;
import lgScreen.main;
import prototype.rounded_panel;
import student.Student;
import teacher.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher_edit_panel extends rounded_panel implements ActionListener {
    public Teacher_edit_top_panel ptop;
    public Teacher_edit_middle_panel pmid;
    public Teacher_edit_panel(int radius) {
        super(radius);
    }

    public Teacher_edit_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx=0.3;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        JPanel p0 = new JPanel();
        p0.setOpaque(false);

        JPanel p01 = new JPanel();
        p01.setOpaque(false);

        ptop = new Teacher_edit_top_panel();
        pmid = new Teacher_edit_middle_panel();
        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        gbc.weighty = 0.001;
        gbc.gridy = 0;
        add(p0,gbc);



        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0.3;
        gbc.gridy = 1;
        add(ptop,gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
//        gbc.weighty = 0.00005;
//        gbc.gridy = 2;
//        add(p01,gbc);

        gbc.weighty = 0.3;
        gbc.gridy =3;
        add(pmid,gbc);

        gbc.weighty = 0.001;
        gbc.gridy = 4;
        add(p3,gbc);

        ptop.search.addActionListener(this);
        ptop.save.addActionListener(this);
        ptop.discard.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ptop.search){
            try {
                ResultSet rs = main.exe.searchTeacher(main.conn,ptop.getCMND.getText());
                while (rs.next()){
                    pmid.lpanel.faddress.setText(rs.getString("address"));

                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    pmid.lpanel.fdob.setText(formatter.format(rs.getDate("date_of_birth").getTime()));
                    pmid.lpanel.fethnic.setText(rs.getString("ethnic"));
                    pmid.lpanel.fgender.setText(rs.getString("gender"));
                    pmid.lpanel.fhometown.setText(rs.getString("hometown"));
                    pmid.lpanel.fname.setText(rs.getString("fname") + rs.getString("lname"));
                    pmid.lpanel.freligion.setText(rs.getString("religion"));
                    pmid.lpanel.fiD_number.setText(rs.getString("CMND"));

                    pmid.rpanel.fphonenumber.setText(rs.getString("phone_number"));
                    pmid.rpanel.femail.setText(rs.getString("email"));
                    pmid.rpanel.fdepartment.setText(rs.getString("department"));
                    pmid.rpanel.fpassword.setText(rs.getString("password"));
                    pmid.rpanel.fstatus.setText(rs.getString("status"));
                    pmid.rpanel.fqualification.setText(rs.getString("qualification"));
                    pmid.rpanel.fusername.setText(rs.getString("username"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        if (e.getSource() == ptop.save){

            Teacher teacher = new Teacher();
            teacher.setAddress(pmid.lpanel.faddress.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                teacher.setDate_of_birth(new Date(sdf.parse(pmid.lpanel.fdob.getText()).getTime()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            System.out.println(teacher.getDate_of_birth().toString());
            teacher.setEmail(pmid.rpanel.femail.getText());
            teacher.setEthnic_group(pmid.lpanel.fethnic.getText());
            teacher.setGender(pmid.lpanel.fgender.getText());
            teacher.setHometown(pmid.lpanel.fhometown.getText());
            String fname = pmid.lpanel.fname.getText().split(" ")[0];
            teacher.setFirstname(fname);
            teacher.setLastname(pmid.lpanel.fname.getText().replace(fname,""));
            teacher.setPhone_number(pmid.rpanel.fphonenumber.getText());
            teacher.setReligion(pmid.lpanel.freligion.getText());

            teacher.setId_number(pmid.lpanel.fiD_number.getText());
            teacher.setDepartment(pmid.rpanel.fdepartment.getText());
            teacher.setPassword(pmid.rpanel.fpassword.getText());
            teacher.setStatus(pmid.rpanel.fstatus.getText());
            teacher.setUsername(pmid.rpanel.fusername.getText());
            try {
                if (main.exe.updateTeacher(teacher, main.conn, ptop.getCMND.getText())){
                    JOptionPane.showMessageDialog(null,
                            "Đã chỉnh sửa thành công",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);
                    admin_panel.department_teacher_panel.pmid.update();
                    admin_panel.menu_panel.p2.lpanel.update();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Đã chỉnh sửa thất bại",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == ptop.discard){

            pmid.lpanel.faddress.setText("");
            pmid.lpanel.fdob.setText("");
            pmid.lpanel.fethnic.setText("");
            pmid.lpanel.fgender.setText("");
            pmid.lpanel.fhometown.setText("");
            pmid.lpanel.fname.setText("");
            pmid.lpanel.freligion.setText("");

            pmid.rpanel.femail.setText("");
            pmid.rpanel.fdepartment.setText("");
            pmid.rpanel.fphonenumber.setText("");
            pmid.rpanel.fpassword.setText("");
            pmid.rpanel.fstatus.setText("");
            pmid.rpanel.fusername.setText("");
            ptop.getCMND.setText("");
        }
    }
}
