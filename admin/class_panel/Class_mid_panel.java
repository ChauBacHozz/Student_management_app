package admin.class_panel;

import lgScreen.main;
import prototype.rounded_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Class_mid_panel extends JPanel implements ActionListener {
//    int grx = 0;
//    int gry = 0;
    public ArrayList<String> student_major = new ArrayList<String>();
    public ArrayList<rounded_button> studentmajor_buttons = new ArrayList<rounded_button>();
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    public Class_mid_panel(){
        setOpaque(false);
        setLayout(gbl);
//        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));
        update();

    }
    public void update(){
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int i =0 ; i < studentmajor_buttons.size(); i++){
            this.remove(studentmajor_buttons.get(i));
        }
        student_major.clear();
        studentmajor_buttons.clear();

        try {
            ResultSet rs = main.exe.majordistinct_student(main.conn);
            while(rs.next()){
                student_major.add(rs.getString("major"));
                student_major.sort(Comparator.naturalOrder());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < student_major.size(); i++){
            System.out.println(student_major.get(i));
            rounded_button button = new rounded_button(
                    student_major.get(i),
                    new Color(144, 251, 161, 234),
                    new Color(156, 240, 215));
            button.setPreferredSize(new Dimension(310, 50));
            button.setFont(new Font(null, Font.BOLD, 22 ));
            button.setMargin(new Insets(0,0,0,0));
            studentmajor_buttons.add(button);
            studentmajor_buttons.get(i).addActionListener(this);


            if (i > 2){
                gbc.gridx = 0;
            }
            gbc.gridy = i / 3;
            add(studentmajor_buttons.get(i), gbc);
            gbc.gridx++;
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < studentmajor_buttons.size(); i++){
            if (e.getSource() == studentmajor_buttons.get(i)){
                Student_table table = new Student_table( student_major.get(i));
            }
        }
    }
}
