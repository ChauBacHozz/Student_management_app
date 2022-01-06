package admin.department_panel;

import admin.schoolyear_panel.Student_table;
import lgScreen.main;
import prototype.rounded_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Department_teacher_middle_panel extends JPanel implements ActionListener {
    public ArrayList<String> teacher_departments = new ArrayList<String>();
    public ArrayList<rounded_button> teacherdepartments_buttons = new ArrayList<rounded_button>();
    public Department_teacher_middle_panel(){
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));
        update();

    }
    public void update(){
        for (int i =0 ; i < teacherdepartments_buttons.size(); i++){
            this.remove(teacherdepartments_buttons.get(i));
        }
        teacher_departments.clear();
        teacherdepartments_buttons.clear();

        try {
            ResultSet rs = main.exe.departmentdítinct_teacher(main.conn);
            while(rs.next()){
                teacher_departments.add(rs.getString("department"));
                teacher_departments.sort(Comparator.naturalOrder());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < teacher_departments.size(); i++){
            System.out.println(teacher_departments.get(i));
            rounded_button button = new rounded_button(
                    teacher_departments.get(i),
                    new Color(144, 251, 161, 234),
                    new Color(156, 240, 215));
            button.setPreferredSize(new Dimension(170, 250));
            button.setFont(new Font(null, Font.BOLD, 30 ));
            teacherdepartments_buttons.add(button);
            teacherdepartments_buttons.get(i).addActionListener(this);
            add(teacherdepartments_buttons.get(i));
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < teacherdepartments_buttons.size(); i++){
            if (e.getSource() == teacherdepartments_buttons.get(i)){
                Teacher_table table = new Teacher_table( teacher_departments.get(i));
            }

        }
    }
}
