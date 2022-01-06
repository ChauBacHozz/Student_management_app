package admin.student_panel;

import admin.admin_panel;
import lgScreen.main;
import prototype.rounded_panel;
import student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student_edit_panel extends rounded_panel implements ActionListener {
    public Student_edit_top_panel ptop;
    public Student_edit_middle_panel pmid;
    public Student_edit_panel(int radius) {
        super(radius);
    }

    public Student_edit_panel(int radius, Color bgColor) {
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

        ptop = new Student_edit_top_panel();
        pmid = new Student_edit_middle_panel();
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
                ResultSet rs = main.exe.searchStudent(main.conn,Integer.parseInt(ptop.getId.getText()) );
                while (rs.next()){
                    pmid.lpanel.faddress.setText(rs.getString("address"));

                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    pmid.lpanel.fdob.setText(formatter.format(rs.getDate("date_of_birth").getTime()));
                    pmid.lpanel.femail.setText(rs.getString("email"));
                    pmid.lpanel.fethnic.setText(rs.getString("ethnic"));
                    pmid.lpanel.fgender.setText(rs.getString("gender"));
                    pmid.lpanel.fhometown.setText(rs.getString("home_town"));
                    pmid.lpanel.fname.setText(rs.getString("fname") + rs.getString("lname"));
                    pmid.lpanel.fphonenumber.setText(rs.getString("phone_number"));
                    pmid.lpanel.freligion.setText(rs.getString("religion"));

                    pmid.rpanel.fiD_number.setText(rs.getString("CMND"));
                    pmid.rpanel.fdepartment.setText(rs.getString("department"));
                    pmid.rpanel.fgpa.setText(Float.toString(rs.getFloat("GPA")));
                    pmid.rpanel.fmajor.setText(rs.getString("major"));
                    pmid.rpanel.fpassword.setText(rs.getString("password"));
                    pmid.rpanel.fschool_year.setText(rs.getString("school year"));
                    pmid.rpanel.fstatus.setText(rs.getString("status"));
                    pmid.rpanel.fusername.setText(rs.getString("username"));
                    pmid.rpanel.fstudent_id.setText(Integer.toString(rs.getInt("msv")));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        if (e.getSource() == ptop.save){

            Student student = new Student();
            student.setAddress(pmid.lpanel.faddress.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                student.setDate_of_birth(new Date(sdf.parse(pmid.lpanel.fdob.getText()).getTime()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            System.out.println(student.getDate_of_birth().toString());
            student.setEmail(pmid.lpanel.femail.getText());
            student.setEthnic_group(pmid.lpanel.fethnic.getText());
            student.setGender(pmid.lpanel.fgender.getText());
            student.setHometown(pmid.lpanel.fhometown.getText());
            String fname = pmid.lpanel.fname.getText().split(" ")[0];
            student.setFirstname(fname);
            student.setLastname(pmid.lpanel.fname.getText().replace(fname,""));
            student.setPhone_number(pmid.lpanel.fphonenumber.getText());
            student.setReligion(pmid.lpanel.freligion.getText());

            student.setId_number(pmid.rpanel.fiD_number.getText());
            student.setDepartment(pmid.rpanel.fdepartment.getText());
            student.setGpa(Float.parseFloat(pmid.rpanel.fgpa.getText()));
            student.setMajor(pmid.rpanel.fmajor.getText());
            student.setPassword(pmid.rpanel.fpassword.getText());
            student.setSchool_year(pmid.rpanel.fschool_year.getText());
            student.setStatus(pmid.rpanel.fstatus.getText());
            student.setUsername(pmid.rpanel.fusername.getText());
            student.setStudent_id(Integer.parseInt(pmid.rpanel.fstudent_id.getText()));
            try {
                if (main.exe.updateStudent(student, main.conn, Integer.parseInt(ptop.getId.getText()))){
                    JOptionPane.showMessageDialog(null,
                            "Đã chỉnh sửa thành công",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);
                    admin_panel.schoolyear_panel.pmid.update();
                    admin_panel.menu_panel.p2.lpanel.update();
                    admin_panel.menu_panel.p2.rpanel.update_gpa();
                    admin_panel.class_panel.pmid.update();
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
            pmid.lpanel.femail.setText("");
            pmid.lpanel.fethnic.setText("");
            pmid.lpanel.fgender.setText("");
            pmid.lpanel.fhometown.setText("");
            pmid.lpanel.fname.setText("");
            pmid.lpanel.fphonenumber.setText("");
            pmid.lpanel.freligion.setText("");

            pmid.rpanel.fiD_number.setText("");
            pmid.rpanel.fdepartment.setText("");
            pmid.rpanel.fgpa.setText("");
            pmid.rpanel.fmajor.setText("");
            pmid.rpanel.fpassword.setText("");
            pmid.rpanel.fschool_year.setText("");
            pmid.rpanel.fstatus.setText("");
            pmid.rpanel.fusername.setText("");
            pmid.rpanel.fstudent_id.setText("");
            ptop.getId.setText("");
        }
    }
}
