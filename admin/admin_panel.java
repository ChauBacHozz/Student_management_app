package admin;

import admin.class_panel.Class_panel;
import admin.department_panel.Department_teacher_panel;
import admin.info_panel.Info_panel;
import admin.menu_panel.Menu_panel;
import admin.department_panel.Department_student_panel;
import admin.schoolyear_panel.Schoolyear_panel;
import admin.student_panel.Student_edit_panel;
import admin.student_panel.Student_insert_panel;
import admin.student_panel.Student_view_panel;
import admin.teacher_panel.Teacher_edit_panel;
import admin.teacher_panel.Teacher_view_panel;
import admin.teacher_panel.Teacher_insert_panel;
import lgScreen.main;
import mainScreen.mainPanel;
import mainScreen.top_panel;
import prototype.rounded_button;
import prototype.option_panel;
import prototype.option_student_teacherpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class admin_panel extends mainPanel implements ActionListener, MouseListener {
    JPanel p1;

    Color c1 = new Color(234, 162, 133);
    Color c2 = new Color(240, 134, 84);

    private int button_posy = 0;
    private int index;
    static CardLayout cl;

    GridBagLayout gbl;
    GridBagConstraints gbc;

    public static Menu_panel menu_panel;
    Student_view_panel student_view_panel;
    Student_edit_panel student_edit_panel;
    Student_insert_panel student_insert_panel;
    Teacher_view_panel teacher_view_panel;
    Teacher_edit_panel teacher_edit_panel;
    Teacher_insert_panel teacher_insert_panel;
    public static Class_panel class_panel;
    public static Department_student_panel department_student_panel;
    public static Department_teacher_panel department_teacher_panel;
    public static Schoolyear_panel schoolyear_panel;
    Info_panel info_panel;

    rounded_button menu_button = new rounded_button("Trang chủ", c1, c2, "menu");
    rounded_button student_button = new rounded_button("Sinh viên", c1, c2, "student");
    rounded_button teacher_button = new rounded_button("Giảng viên", c1, c2, "teacher");
    rounded_button class_button = new rounded_button("Lớp học", c1, c2, "class");
    rounded_button department_button = new rounded_button("Khoa", c1, c2, "department");
    rounded_button schoolyear_button = new rounded_button("Khóa", c1, c2, "schoolyear");
    rounded_button info_button = new rounded_button("Thông tin", c1, c2, "info");

    rounded_button[] rbt = {menu_button, student_button, teacher_button
            , class_button, department_button, schoolyear_button, info_button};

    option_panel op = new option_panel();
    option_student_teacherpanel op_st = new option_student_teacherpanel();
    boolean optionpanel_opened = false;


    public admin_panel(){
        init();
    }
    public void init(){
        setMinimumSize(new Dimension(1000, 650));

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        mid_panel.buttoncenter_panel.setLayout(gbl);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0.1f;



        op.edit_button.addActionListener(this);
        op.view_button.addActionListener(this);
        op_st.teacher_button.addActionListener(this);
        op_st.student_button.addActionListener(this);

        for (rounded_button item:rbt ) {
            item.addActionListener(this);
            item.setPreferredSize(new Dimension(100, 60));
            item.setFont(new Font(null, Font.BOLD, 20));
            item.setArc(25);
            gbc.gridy = button_posy++;
            mid_panel.buttoncenter_panel.add(item, gbc);
        }

        gbc.fill = GridBagConstraints.HORIZONTAL;
        p1 = new JPanel();
        p1.setOpaque(false);
        gbc.weighty = 1;
        gbc.gridy = button_posy++;
        mid_panel.buttoncenter_panel.add(p1, gbc);

        cl = new CardLayout();
        mid_panel.view_panel.setLayout(cl);

        menu_panel = new Menu_panel(70, new Color(195, 175, 145));
        student_view_panel = new Student_view_panel(70, new Color(195, 175, 145));
        student_edit_panel = new Student_edit_panel(70, new Color(195, 175, 145));
        student_insert_panel = new Student_insert_panel(70, new Color(195, 175, 145));
        teacher_view_panel = new Teacher_view_panel(70, new Color(195, 175, 145));
        teacher_edit_panel = new Teacher_edit_panel(70, new Color(195, 175, 145));
        teacher_insert_panel = new Teacher_insert_panel(70, new Color(195, 175, 145));
        class_panel = new Class_panel(70, new Color(195, 175, 145));

        department_student_panel = new Department_student_panel(70, new Color(195, 175, 145));
        department_teacher_panel = new Department_teacher_panel(70, new Color(195, 175, 145));
        schoolyear_panel = new Schoolyear_panel(70, new Color(195, 175, 145));
        info_panel = new Info_panel(70, new Color(195, 175, 145));

        mid_panel.view_panel.add(menu_panel, menu_button.getName());

        mid_panel.view_panel.add(student_view_panel, student_button.getName() + "view");
        mid_panel.view_panel.add(student_edit_panel, student_button.getName() + "edit");
        mid_panel.view_panel.add(student_insert_panel, "insert_student");
        mid_panel.view_panel.add(teacher_view_panel, teacher_button.getName() + "view");
        mid_panel.view_panel.add(teacher_edit_panel, teacher_button.getName() + "edit");
        mid_panel.view_panel.add(teacher_insert_panel, "insert_teacher");
        mid_panel.view_panel.add(class_panel, class_button.getName());
        mid_panel.view_panel.add(department_student_panel, department_button.getName() + "student");
        mid_panel.view_panel.add(department_teacher_panel, department_button.getName() + "teacher");
        mid_panel.view_panel.add(schoolyear_panel, schoolyear_button.getName());
        mid_panel.view_panel.add(info_panel, info_button.getName());
        cl.show(mid_panel.view_panel,menu_button.getName());

        student_view_panel.pmid.mini_middel_panel.insert_button.addActionListener(this);
        teacher_view_panel.pmid.mini_middel_panel.insert_button.addActionListener(this);

    }
    @Override
    public top_panel getToppanel(){
        return super.toppanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu_button){
            cl.show(mid_panel.view_panel, menu_button.getName());

        }
        if (e.getSource() == student_button){
            removeTheother(mid_panel.buttoncenter_panel, e, op);
        }
        if (e.getSource() == student_view_panel.pmid.mini_middel_panel.insert_button){
            cl.show(mid_panel.view_panel, "insert_student");
        }
        if (e.getSource() == teacher_view_panel.pmid.mini_middel_panel.insert_button){
            cl.show(mid_panel.view_panel, "insert_teacher");

        }
        if (e.getSource() == teacher_button){
            removeTheother(mid_panel.buttoncenter_panel, e, op);
        }
        if (e.getSource() == class_button){
            cl.show(mid_panel.view_panel, class_button.getName());
        }
        if (e.getSource() == department_button){
            removeTheother(mid_panel.buttoncenter_panel,e, op_st);

        }
        if (e.getSource() == schoolyear_button){
            cl.show(mid_panel.view_panel, schoolyear_button.getName());

        }
        if (e.getSource() == info_button){
            cl.show(mid_panel.view_panel, info_button.getName());
            try {
                ResultSet rs = main.exe.searchAdmin(main.conn);
                while (rs.next()){
                    getToppanel().username_label.setText("Xin chào " + rs.getString("fname") +" "+ rs.getString("lname"));
                    info_panel.infoPleft.pleft.femail.setText(rs.getString("email"));
                    info_panel.infoPleft.pleft.fphone_number.setText(rs.getString("phone_number"));
                    info_panel.infoPleft.pleft.fstatus.setText(rs.getString("status"));
                    info_panel.infoPleft.pleft.fwork_address.setText(rs.getString("work_address"));

                    info_panel.infoPright.pright.ffname.setText(rs.getString("fname"));
                    info_panel.infoPright.pright.flname.setText(rs.getString("lname"));
                    info_panel.infoPright.pright.fusername.setText(rs.getString("username"));
                    info_panel.infoPright.pright.fpassword.setText(rs.getString("password"));
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == op.view_button){
            for (rounded_button item:rbt) {
                if(item.getClicked() == 1){
                    cl.show(mid_panel.view_panel, item.getName() + "view");
                }
            }
        }
        if (e.getSource() == op.edit_button){
            for (rounded_button item:rbt) {
                if(item.getClicked() == 1){
                    cl.show(mid_panel.view_panel, item.getName() + "edit");
                }
            }
        }
        if (e.getSource() == op_st.student_button){
            for (rounded_button item:rbt) {
                if(item.getClicked() == 1){
                    cl.show(mid_panel.view_panel, item.getName() + "student");
                }
            }
        }
        if (e.getSource() == op_st.teacher_button){
            for (rounded_button item:rbt) {
                if(item.getClicked() == 1){
                    cl.show(mid_panel.view_panel, item.getName() + "teacher");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void removeTheother(Container container, ActionEvent e, JPanel panel){
        if (optionpanel_opened){
            for (rounded_button item:rbt) {
                item.setClicked(0);
                if (e.getSource() == item){
                    item.setClicked(1);
                }
            }


            removeObject(container, (Component) op);
            removeObject(container, (Component) op_st);

            for (int i = index; i < 7; i++) {
                removeObject(container, (Component) rbt[i]);
            }
            for (int i = index; i < 7; i++){
                gbc.gridy = i + 1;
                container.add(rbt[i], gbc);
                container.revalidate();
                container.repaint();
            }
            index = checkin((rounded_button) e.getSource()) + 1;
            for (int i = index; i < 7; i++) {
                removeObject(container, (Component) rbt[i]);
            }
            gbc.gridy = index + 1;
            gbc.weighty = 0.1f;
            container.add(panel, gbc);
            for (int i = index; i < 7; i++){
                gbc.gridy = i + 2;
                container.add(rbt[i], gbc);
                container.revalidate();
                container.repaint();
            }
        } else {
            for (rounded_button item:rbt) {
                if (e.getSource() == item){
                    item.setClicked(1);
                }
            }
            menu_button.setClicked(1);
            removeObject(container, p1);
            index = checkin((rounded_button) e.getSource()) + 1;
            for (int i = index; i < 7; i++) {
                removeObject(container, (Component) rbt[i]);
            }
            gbc.gridy = index;
            gbc.weighty = 0.1f;
            container.add(panel, gbc);
            for (int i = index; i < 7; i++){
                gbc.gridy= i + 1;
                container.add(rbt[i], gbc);
                container.revalidate();
                container.repaint();
            }
            optionpanel_opened = true;
        }
    }
    public void removeObject(Container container, Component e){
            container.remove(e);
            container.revalidate();
            container.repaint();
    }
    public int checkin(rounded_button ex){
        int index = 0;
        for (int i = 0; i < 7; i++) {
            if(ex == rbt[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}
