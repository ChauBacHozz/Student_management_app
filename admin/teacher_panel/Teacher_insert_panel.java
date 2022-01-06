package admin.teacher_panel;
import admin.admin_panel;
import admin.student_panel.Student_edit_middle_panel;
import admin.student_panel.Student_insert_top_panel;
import lgScreen.main;
import prototype.rounded_panel;
import student.Student;
import teacher.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Teacher_insert_panel extends rounded_panel implements ActionListener {
    Teacher_insert_top_panel ptop;
    Teacher_edit_middle_panel pmid;
    public Teacher_insert_panel(int radius) {
        super(radius);
    }

    public Teacher_insert_panel(int radius, Color bgColor) {
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

        ptop = new Teacher_insert_top_panel();
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

        ptop.insert.addActionListener(this);
        ptop.discard.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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


        }
        if (e.getSource() == ptop.insert){
            String a = pmid.lpanel.faddress.getText();
            String b = pmid.lpanel.fdob.getText();
            String c = pmid.lpanel.fethnic.getText();
            String d = pmid.lpanel.fgender.getText();
            String v = pmid.lpanel.fhometown.getText();
            String f = pmid.lpanel.fname.getText();
            String g = pmid.lpanel.freligion.getText();
            String h = pmid.rpanel.femail.getText();
            String i = pmid.rpanel.fdepartment.getText();
            String k = pmid.rpanel.fphonenumber.getText();
            String l = pmid.rpanel.fpassword.getText();
            String m = pmid.rpanel.fstatus.getText();
            String n = pmid.rpanel.fusername.getText();
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
            n.length() == 0
                    ){
                JOptionPane.showMessageDialog(null,
                        "Hãy nhập đầy đủ thông tin giảng viên!",
                        "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE);


            } else {
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
                    if (main.exe.insertTeacher(teacher, main.conn)){
                        JOptionPane.showMessageDialog(null,
                                "Đã thêm giảng viên thành công",
                                "Kết quả",
                                JOptionPane.INFORMATION_MESSAGE);
                        admin_panel.department_teacher_panel.pmid.update();
                        admin_panel.menu_panel.p2.lpanel.update();

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Đã thêm giảng viên thất bại",
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
