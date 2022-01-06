package admin.student_panel;
import admin.admin_panel;
import admin.schoolyear_panel.Schoolyear_mid_panel;
import lgScreen.main;
import prototype.rounded_panel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;

public class Student_view_panel extends rounded_panel implements ActionListener {
    public Student_view_toppanel ptop;
    public Student_view_middlepanel pmid;

    public Student_view_panel(int radius) {
        super(radius);
    }

    public Student_view_panel(int radius, Color bgColor) {
        super(radius, bgColor);
        setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.BOTH;
        ptop = new Student_view_toppanel();
        ptop.setOpaque(false);

        pmid = new Student_view_middlepanel();
        pmid.setOpaque(false);


        JPanel p3 = new JPanel();
        p3.setOpaque(false);

        gbc.weighty = 0.1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(ptop,gbc);

        gbc.weighty = 0.8;
        gbc.gridx =0;
        gbc.gridy =1;
        add(pmid,gbc);

        gbc.weighty = 0.01;
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(p3,gbc);

        ptop.find.addActionListener(this);
        ptop.delete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ptop.find){
            try {
                ResultSet rs = main.exe.searchStudent(main.conn,Integer.parseInt(ptop.getId.getText()) );
                while (rs.next()){

                    pmid.mini_middel_panel.leftcorner_panel.fname.setText(rs.getString("fname") + rs.getString("lname"));
                    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                    pmid.mini_middel_panel.leftcorner_panel.fdob.setText( formatter.format(rs.getDate("date_of_birth").getTime()));
                    pmid.mini_middel_panel.leftcorner_panel.fgender.setText(rs.getString("gender"));
                    pmid.mini_middel_panel.leftcorner_panel.fhometown.setText(rs.getString("home_town"));
                    pmid.mini_middel_panel.leftcorner_panel.faddress.setText(rs.getString("address"));
                    pmid.mini_middel_panel.leftcorner_panel.femail.setText(rs.getString("email"));
                    pmid.mini_middel_panel.leftcorner_panel.fphonenumber.setText(rs.getString("phone_number"));

                    pmid.mini_middel_panel.rightcorner_panel.fstudent_id.setText(rs.getString("msv"));
                    pmid.mini_middel_panel.rightcorner_panel.fdepartment.setText(rs.getString("department"));
                    pmid.mini_middel_panel.rightcorner_panel.fmajor.setText(rs.getString("major"));
                    pmid.mini_middel_panel.rightcorner_panel.fschool_year.setText(rs.getString("school year"));
                    pmid.mini_middel_panel.rightcorner_panel.fgpa.setText(rs.getString("GPA"));
                    pmid.mini_middel_panel.rightcorner_panel.fusername.setText(rs.getString("username"));
                    pmid.mini_middel_panel.rightcorner_panel.fpassword.setText(rs.getString("password"));

//                    System.out.println("Id: " + rs.getInt("msv"));
//                    System.out.println("Name: " + rs.getString("lname"));
//                    System.out.println("Address: " + rs.getString("address"));
//                    System.out.println("Year: " + rs.getInt("school year"));
//                    System.out.println("DOB: " + rs.getDate("date_of_birth"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == ptop.delete){
            String alpha = pmid.mini_middel_panel.leftcorner_panel.fname.getText();
            if (alpha.length() == 0 ){
                JOptionPane.showMessageDialog(null,
                        "Hãy chọn ra một sinh viên để xóa!",
                        "Kết quả",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("something");
                if (main.exe.deleteStudent(Integer.parseInt(pmid.mini_middel_panel.rightcorner_panel.fstudent_id.getText()), main.conn)){
                    JOptionPane.showMessageDialog(null,
                            "Đã xóa thành công!",
                            "Kết quả",
                            JOptionPane.INFORMATION_MESSAGE);
                    admin_panel.schoolyear_panel.pmid.update();
                    admin_panel.menu_panel.p2.lpanel.update();
                    admin_panel.menu_panel.p2.rpanel.update_gpa();
                    admin_panel.class_panel.pmid.update();

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
