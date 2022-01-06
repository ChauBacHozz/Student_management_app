package lgScreen;

import database_connector.ConnectionUtils;
import database_connector.ExecuteSQL;
import student.Student;
import teacher.Teacher;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class main {
    public static Frame frame;
    public static Connection conn;
    public static ResultSet rs_user;
    public static ExecuteSQL exe = new ExecuteSQL();
    public static void main(String[] args) throws ParseException {
        try {
            conn = ConnectionUtils.openConnection();

        } catch (Exception e){
            e.printStackTrace();
        }

        frame = new Frame();
    }

}
