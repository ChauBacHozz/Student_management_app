package lgScreen;

import mainScreen.top_panel;
import prototype.rounded_panel;
import prototype.textfield_type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_panel extends rounded_panel implements ActionListener {
    public textfield_type name_field;
    public textfield_type pass_field;
    JLabel username_label;
    JLabel password_label;
    JLabel forgot_pass;


    Button_panel button_panel;
    public login_panel(int radius, Color bgColor) {
        super(radius, bgColor);


        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        username_label = new JLabel("User name: ");
        username_label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(320, 15));
        panel1.setLayout(new GridBagLayout());
        panel1.setOpaque(false);
        panel1.add(username_label, new GridBagConstraints(
                0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.WEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                        0, // inset left
                        0, // inset bottom
                        0), // inset right
                0, // ipadx
                0)); // ipady

        add(panel1);

        name_field = new textfield_type();
        name_field.setFont(new Font(null, Font.ITALIC, 16));
        name_field.setPreferredSize(new Dimension(340, 45));
        name_field.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        name_field.setHorizontalAlignment(JTextField.CENTER);
        add(name_field);


        password_label = new JLabel("Password: ");
        password_label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        forgot_pass = new JLabel("U forgot it????");
        forgot_pass.setFont(new Font(null, Font.ITALIC, 16));


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(320, 20));
        panel2.setLayout(new GridBagLayout());
        panel2.setOpaque(false);

        panel2.add(password_label, new GridBagConstraints(
                0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.WEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                        0, // inset left
                        0, // inset bottom
                        0), // inset right
                0, // ipadx
                0)); // ipady

        panel2.add(forgot_pass, new GridBagConstraints(
                0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.EAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                        0, // inset left
                        0, // inset bottom
                        0), // inset right
                0, // ipadx
                0)); // ipady

        add(panel2);
        pass_field = new textfield_type();
        pass_field.setPreferredSize(new Dimension(340, 45));
        pass_field.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pass_field.setFont(new Font(null, Font.ITALIC, 16));
        pass_field.setHorizontalAlignment(JTextField.CENTER);

        add(pass_field);

        button_panel = new Button_panel();
        button_panel.close.addActionListener(this);
        button_panel.signin.addActionListener(this);
        add(button_panel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_panel.close){
            System.exit(0);
        }
        if (e.getSource() == button_panel.signin){
            if (name_field.getText().equals("admin")){
                try {
                    ResultSet rs = main.exe.searchAdmin(main.conn);
                    while (rs.next()){
                        if ( pass_field.getText().equals(rs.getString("password"))){
                            Frame.cl.show(Frame.constpanel, "admin");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Bạn đã nhập sai mật khẩu, vui lòng nhập lại!",
                                    "Sai thông tin người dùng",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            else if (name_field.getText().chars().allMatch( Character::isDigit )){
                try {
                    ResultSet rs = main.exe.searchStudentlogin(main.conn, name_field.getText());
                    while (rs.next()) {
                        if (pass_field.getText().equals(rs.getString("password"))) {

                            main.rs_user = main.exe.searchStudent(main.conn, Integer.parseInt(name_field.getText()));
                            Frame.cl.show(Frame.constpanel, "student");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Bạn đã nhập sai mật khẩu, vui lòng nhập lại!",
                                    "Sai thông tin người dùng",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else {
                try {
                    ResultSet rs = main.exe.searchTeacherlogin(main.conn, name_field.getText());
                    while (rs.next()) {
                        if (pass_field.getText().equals(rs.getString("password"))) {
                            main.rs_user = main.exe.searchTeacher_byusername(main.conn, name_field.getText());
//                            top_panel.user_name = main.rs_user.getString("fname") + main.rs_user.getString("lname");
                            Frame.cl.show(Frame.constpanel, "teacher");
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Bạn đã nhập sai mật khẩu, vui lòng nhập lại!",
                                    "Sai thông tin người dùng",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
