package admin.department_panel;


import lgScreen.main;
import prototype.rounded_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Department_student_middle_panel extends JPanel implements ActionListener {
    public ArrayList<String> student_departments = new ArrayList<String>();
    public ArrayList<rounded_button> studentdepartments_buttons = new ArrayList<rounded_button>();
    public Department_student_middle_panel(){
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));
        update();

    }
    public void update(){
        for (int i =0 ; i < studentdepartments_buttons.size(); i++){
            this.remove(studentdepartments_buttons.get(i));
        }
        student_departments.clear();
        studentdepartments_buttons.clear();

        try {
            ResultSet rs = main.exe.departmentdistinct_student(main.conn);
            while(rs.next()){
                student_departments.add(rs.getString("department"));
                student_departments.sort(Comparator.naturalOrder());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < student_departments.size(); i++){
            rounded_button button = new rounded_button(
                    student_departments.get(i),
                    new Color(144, 251, 161, 234),
                    new Color(156, 240, 215));
            button.setPreferredSize(new Dimension(170, 250));
            button.setFont(new Font(null, Font.BOLD, 30 ));
            studentdepartments_buttons.add(button);
            studentdepartments_buttons.get(i).addActionListener(this);
            add(studentdepartments_buttons.get(i));
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < studentdepartments_buttons.size(); i++){
            if (e.getSource() == studentdepartments_buttons.get(i)){
                Student_table table = new Student_table( student_departments.get(i));
            }

        }
    }
}
