package admin.schoolyear_panel;

import lgScreen.main;
import prototype.rounded_button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Schoolyear_mid_panel extends JPanel implements ActionListener {
    public ArrayList<String> student_year = new ArrayList<String>();
    public ArrayList<rounded_button> studentyear_buttons = new ArrayList<rounded_button>();
    public Schoolyear_mid_panel(){
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));
        update();

    }
    public void update(){
        for (int i =0 ; i < studentyear_buttons.size(); i++){
            this.remove(studentyear_buttons.get(i));
        }
        student_year.clear();
        studentyear_buttons.clear();

        try {
            ResultSet rs = main.exe.distinctSchoolyear(main.conn);
            while(rs.next()){
                student_year.add(rs.getString("school year"));
                student_year.sort(Comparator.naturalOrder());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < student_year.size(); i++){
            System.out.println(student_year.get(i));
            rounded_button button = new rounded_button(
                    student_year.get(i),
                    new Color(144, 251, 161, 234),
                    new Color(156, 240, 215));
            button.setPreferredSize(new Dimension(170, 250));
            button.setFont(new Font(null, Font.BOLD, 30 ));
            studentyear_buttons.add(button);
            studentyear_buttons.get(i).addActionListener(this);
            add(studentyear_buttons.get(i));
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < studentyear_buttons.size(); i++){
            if (e.getSource() == studentyear_buttons.get(i)){
                Student_table table = new Student_table( student_year.get(i));
            }

        }
    }
}
