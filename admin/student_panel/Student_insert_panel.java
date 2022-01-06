package admin.student_panel;
import admin.admin_panel;
import lgScreen.main;
import prototype.rounded_panel;
import student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Student_insert_panel extends rounded_panel implements ActionListener {
    Student_insert_top_panel ptop;
    Student_edit_middle_panel pmid;
    public Student_insert_panel(int radius) {
        super(radius);
    }

    public Student_insert_panel(int radius, Color bgColor) {
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

        ptop = new Student_insert_top_panel();
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

        ptop.insert.addActionListener(this);
        ptop.discard.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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


        }
        if (e.getSource() == ptop.insert){
            String a = pmid.lpanel.faddress.getText();
            String b = pmid.lpanel.fdob.getText();
            String c = pmid.lpanel.femail.getText();
            String d = pmid.lpanel.fethnic.getText();
            String v = pmid.lpanel.fgender.getText();
            String f = pmid.lpanel.fhometown.getText();
            String g = pmid.lpanel.fname.getText();
            String h = pmid.lpanel.fphonenumber.getText();
            String i = pmid.lpanel.freligion.getText();
            String k = pmid.rpanel.fiD_number.getText();
            String l = pmid.rpanel.fdepartment.getText();
            String m = pmid.rpanel.fgpa.getText();
            String n = pmid.rpanel.fmajor.getText();
            String o = pmid.rpanel.fpassword.getText();
            String p = pmid.rpanel.fschool_year.getText();
            String w = pmid.rpanel.fstatus.getText();
            String q = pmid.rpanel.fstudent_id.getText();
            if (
            a.length() == 0 ||
            b.length() == 0 ||
            c.length() == 0 ||
            d.length() == 0 ||
            v.length() == 0 ||
            f.length() == 0 ||
            g.length() == 0 ||
            h.length() == 0 ||
            i.length() == 0 ||
            k.length() == 0 ||
            l.length() == 0 ||
            m.length() == 0 ||
            n.length() == 0 ||
            o.length() == 0 ||
            p.length() == 0 ||
            w.length() == 0 ||
            q.length() == 0
                    ){
                JOptionPane.showMessageDialog(null,
                        "Hãy nhập đầy đủ thông tin sinh viên!",
                        "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE);


            } else {
                Student student = new Student();
                student.setAddress(pmid.lpanel.faddress.getText());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    student.setDate_of_birth(new Date(sdf.parse(pmid.lpanel.fdob.getText()).getTime()));
                } catch (Exception ex) {
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
                student.setUsername(pmid.rpanel.fstudent_id.getText());
                student.setStudent_id(Integer.parseInt(pmid.rpanel.fstudent_id.getText()));

                try {
                    if (main.exe.insertStudent(student, main.conn)){
                        JOptionPane.showMessageDialog(null,
                                "Đã thêm thành công",
                                "Kết quả",
                                JOptionPane.INFORMATION_MESSAGE);
                        admin_panel.schoolyear_panel.pmid.update();
                        admin_panel.menu_panel.p2.lpanel.update();
                        admin_panel.menu_panel.p2.rpanel.update_gpa();
                        admin_panel.class_panel.pmid.update();

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Đã thêm thất bại",
                                "Kết quả",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }
    }
}
