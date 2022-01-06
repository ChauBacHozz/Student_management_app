package database_connector;

import admin.Admin;
import student.Student;
import teacher.Teacher;

import java.sql.*;

public class ExecuteSQL {

    public ResultSet searchAdmin(Connection conn) throws SQLException {
        String sql = "SELECT `username`, `password`, `fname`, `lname`, `phone_number`, `email`, `status`, `work_address` FROM `admin`";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    public ResultSet searchStudentlogin(Connection conn, String username) throws SQLException {
        String sql = "SELECT `password` FROM `student` WHERE username = '" + username +"'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    public ResultSet searchTeacherlogin(Connection conn, String username) throws SQLException {
        String sql = "SELECT `password` FROM `teacher` WHERE username = '" + username +"'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public boolean insertStudent(Student student, Connection conn) {
        String sql = "INSERT INTO `student`( `fname`, `lname`, `gender`, `date_of_birth`, `email`, `school year`, " +
                "`major`, `msv`, `department`, `address`, `phone_number`, `username`, `password`, `GPA`, `ethnic`, `CMND`, " +
                "`home_town`, `status`, `religion`, `class_attending`, `class_completed`, `note`) VALUES " +
                "(?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getFirstname());
            pstm.setString(2, student.getLastname());
            pstm.setString(3, student.getGender());
            pstm.setDate(4, new Date(student.getDate_of_birth().getTime()));
            pstm.setString(5, student.getEmail());
            pstm.setString(6, student.getSchool_year());
            pstm.setString(7, student.getMajor());
            pstm.setInt(8, student.getStudent_id()  );
            pstm.setString(9, student.getDepartment());
            pstm.setString(10, student.getAddress());
            pstm.setString(11, student.getPhone_number());
            pstm.setString(12, student.getUsername());
            pstm.setString(13, student.getPassword());
            pstm.setFloat(14, student.getGpa());
            pstm.setString(15, student.getEthnic_group());
            pstm.setString(16, student.getId_number());
            pstm.setString(17, student.getHometown());
            pstm.setString(18, student.getStatus());
            pstm.setString(19, student.getReligion());
            pstm.setString(20, student.getRegistered_class());
            pstm.setString(21, student.getClass_completed());
            pstm.setString(22, student.getExtra_notes());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertTeacher(Teacher teacher, Connection conn){
        String sql = "INSERT INTO `teacher`( `fname`, `lname`, `gender`," +
                " `date_of_birth`, `email`, `address`, `phone_number`, `username`," +
                " `password`, `ethnic`, `CMND`, `hometown`, `department`, `status`," +
                " `religion`, `qualification`, `teaching_class`, `note`) VALUES" +
                " (?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?)";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacher.getFirstname());
            pstm.setString(2, teacher.getLastname());
            pstm.setString(3, teacher.getGender());
            pstm.setDate(4, new Date(teacher.getDate_of_birth().getTime()));
            pstm.setString(5, teacher.getEmail());
            pstm.setString(6, teacher.getAddress());
            pstm.setString(7, teacher.getPhone_number());
            pstm.setString(8, teacher.getUsername());
            pstm.setString(9, teacher.getPassword());
            pstm.setString(10, teacher.getEthnic_group());
            pstm.setString(11, teacher.getId_number());
            pstm.setString(12, teacher.getHometown());
            pstm.setString(13, teacher.getDepartment());
            pstm.setString(14, teacher.getStatus());
            pstm.setString(15, teacher.getReligion());
            pstm.setString(16, teacher.getQualification());
            pstm.setString(17, teacher.getTeaching_class());
            pstm.setString(18, teacher.getExtra_notes());
            pstm.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet searchStudent(Connection conn, int id) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`," +
                " `school year`, `major`, `msv`, `department`, `address`, `phone_number`," +
                " `username`, `password`, `GPA`, `ethnic`, `CMND`, `home_town`, `status`," +
                " `religion`, `class_attending`, `class_completed`, " +
                "`note` FROM `student` WHERE msv = " + id;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    public ResultSet searchTeacher(Connection conn, String CMND) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`, `address`," +
                " `phone_number`, `username`, `password`, `ethnic`, `CMND`, `hometown`, `department`," +
                " `status`, `religion`, `qualification`, `teaching_class`," +
                " `note` FROM `teacher` WHERE CMND = " + "'" + CMND + "'" ;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    public ResultSet searchTeacher_byusername(Connection conn, String username) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`, `address`," +
                " `phone_number`, `username`, `password`, `ethnic`, `CMND`, `hometown`, `department`," +
                " `status`, `religion`, `qualification`, `teaching_class`," +
                " `note` FROM `teacher` WHERE username = " + "'" + username + "'" ;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public ResultSet searchStudent_bySchoolyear(Connection conn, String schoolyear) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`," +
                " `school year`, `major`, `msv`, `department`, `address`, `phone_number`," +
                " `username`, `password`, `GPA`, `ethnic`, `CMND`, `home_town`, `status`," +
                " `religion`, `class_attending`, `class_completed`, " +
                "`note` FROM `student` WHERE `school year` = " + "'" + schoolyear + "'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public ResultSet searchStudent_byMajor(Connection conn, String major) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`," +
                " `school year`, `major`, `msv`, `department`, `address`, `phone_number`," +
                " `username`, `password`, `GPA`, `ethnic`, `CMND`, `home_town`, `status`," +
                " `religion`, `class_attending`, `class_completed`, " +
                "`note` FROM `student` WHERE `major` = " + "'" + major + "'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public ResultSet searchStudent_byMajorandSchoolYear(Connection conn, String major, String schoolyear) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`," +
                " `school year`, `major`, `msv`, `department`, `address`, `phone_number`," +
                " `username`, `password`, `GPA`, `ethnic`, `CMND`, `home_town`, `status`," +
                " `religion`, `class_attending`, `class_completed`, " +
                "`note` FROM `student` WHERE  `major` = " + "'" + major + "'" + " AND " +" `school year` = " + "'" + schoolyear + "'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public ResultSet searchStudent_byDepartment(Connection conn, String department) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`," +
                " `school year`, `major`, `msv`, `department`, `address`, `phone_number`," +
                " `username`, `password`, `GPA`, `ethnic`, `CMND`, `home_town`, `status`," +
                " `religion`, `class_attending`, `class_completed`, " +
                "`note` FROM `student` WHERE `department` = " + "'" + department + "'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public ResultSet searchTeacher_byDepartment(Connection conn, String department) throws SQLException {
        String sql = "SELECT `STT`, `fname`, `lname`, `gender`, `date_of_birth`, `email`, `address`," +
                " `phone_number`, `username`, `password`, `ethnic`, `CMND`, `hometown`, `department`," +
                " `status`, `religion`, `qualification`, `teaching_class`," +
                " `note` FROM `teacher` WHERE department = " + "'" + department + "'" ;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
    public boolean updateStudent(Student student, Connection conn, int msv) {
        String sql = "UPDATE `student` SET `fname`=?,`lname`=?," +
                "`gender`=?,`date_of_birth`=?,`email`=?," +
                "`school year`=?,`major`=?,`msv`=?,`department`=?," +
                "`address`=?,`phone_number`=?,`username`=?,`password`=?," +
                "`GPA`=?,`ethnic`=?,`CMND`=?,`home_town`=?," +
                "`status`=?,`religion`=?,`class_attending`=?," +
                "`class_completed`=?,`note`=? WHERE msv = " + msv;

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getFirstname());
            pstm.setString(2, student.getLastname());
            pstm.setString(3, student.getGender());
            java.sql.Date date = new java.sql.Date(student.getDate_of_birth().getTime());

            pstm.setDate(4, date);
            pstm.setString(5, student.getEmail());
            pstm.setString(6, student.getSchool_year());
            pstm.setString(7, student.getMajor());
            pstm.setInt(8, student.getStudent_id()  );
            pstm.setString(9, student.getDepartment());
            pstm.setString(10, student.getAddress());
            pstm.setString(11, student.getPhone_number());
            pstm.setString(12, student.getUsername());
            pstm.setString(13, student.getPassword());
            pstm.setFloat(14, student.getGpa());
            pstm.setString(15, student.getEthnic_group());
            pstm.setString(16, student.getId_number());
            pstm.setString(17, student.getHometown());
            pstm.setString(18, student.getStatus());
            pstm.setString(19, student.getReligion());
            pstm.setString(20, student.getRegistered_class());
            pstm.setString(21, student.getClass_completed());
            pstm.setString(22, student.getExtra_notes());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateTeacher(Teacher teacher, Connection conn, String CMND){
        String sql = "UPDATE `teacher` SET `fname`=?,`lname`=?,`gender`=?,`date_of_birth`=?,`email`=?," +
                "`address`=?,`phone_number`=?,`username`=?,`password`=?,`ethnic`=?,`CMND`=?,`hometown`=?," +
                "`department`=?,`status`=?,`religion`=?,`qualification`=?," +
                "`teaching_class`=?,`note`=? WHERE CMND = " + "'" + CMND + "'";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacher.getFirstname());
            pstm.setString(2, teacher.getLastname());
            pstm.setString(3, teacher.getGender());
            pstm.setDate(4, new Date(teacher.getDate_of_birth().getTime()));
            pstm.setString(5, teacher.getEmail());
            pstm.setString(6, teacher.getAddress());
            pstm.setString(7, teacher.getPhone_number());
            pstm.setString(8, teacher.getUsername());
            pstm.setString(9, teacher.getPassword());
            pstm.setString(10, teacher.getEthnic_group());
            pstm.setString(11, teacher.getId_number());
            pstm.setString(12, teacher.getHometown());
            pstm.setString(13, teacher.getDepartment());
            pstm.setString(14, teacher.getStatus());
            pstm.setString(15, teacher.getReligion());
            pstm.setString(16, teacher.getQualification());
            pstm.setString(17, teacher.getTeaching_class());
            pstm.setString(18, teacher.getExtra_notes());
            pstm.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateAdmin(Connection conn, Admin admin){

        String sql = "UPDATE `admin` SET `username`=?,`password`=?,`fname`=?," +
                "`lname`=?,`phone_number`=?,`email`=?,`status`=?," +
                "`work_address`=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getUsername());
            pstm.setString(2, admin.getPassword());
            pstm.setString(3, admin.getFirstname());
            pstm.setString(4, admin.getLastname());
            pstm.setString(5, admin.getPhone_number());
            pstm.setString(6, admin.getEmail());
            pstm.setString(7, admin.getStatus());
            pstm.setString(8, admin.getAddress());
            pstm.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    public boolean deleteStudent(int id, Connection conn){
        String sql = "DELETE FROM `student` WHERE msv = " + id;
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTeacher(String name, Connection conn){
        String sql = "DELETE FROM `teacher` WHERE username = " + "'" + name + "'";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public ResultSet filterStudent(Student student, Connection conn){
//
//    }
//
//    public ResultSet filterTeacher(Teacher teacher, Connection conn){
//
//    }
    public ResultSet distinctSchoolyear(Connection conn) throws SQLException {
        String sql = "SELECT DISTINCT `school year` FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;

    }

    public ResultSet departmentdistinct_student(Connection conn) throws SQLException {
        String sql = "SELECT DISTINCT `department` FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;

    }

    public ResultSet departmentdítinct_teacher(Connection conn) throws SQLException {
        String sql = "SELECT DISTINCT `department` FROM teacher";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;

    }
    public float getAveGPA(Connection conn) throws SQLException {
        String sql = "SELECT AVG(GPA)\n" +
                "FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        float ave_gpa = 0;
        while (rs.next()){
            ave_gpa = rs.getFloat("AVG(GPA)");
        }
        return ave_gpa;
    }
    public int student_count(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(fname) FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int total_student = 0;
        while (rs.next()){
            total_student = rs.getInt("COUNT(fname)");
        }
        return total_student;

    }
    public int teacher_count(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(fname) FROM teacher";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int total_teacher = 0;
        while (rs.next()){
            total_teacher = rs.getInt("COUNT(fname)");
        }
        return total_teacher;

    }
    public int major_count(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(DISTINCT major)\n" +
                " FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int total_major = 0;
        while (rs.next()){
            total_major = rs.getInt("COUNT(DISTINCT major)");
        }
        return total_major;

    }
    public int deppartment_count(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(DISTINCT department)\n" +
                " FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int total_department = 0;
        while (rs.next()){
            total_department = rs.getInt("COUNT(DISTINCT department)");
        }
        return total_department;

    }
    public ResultSet majordistinct_student(Connection conn) throws SQLException {
        String sql = "SELECT DISTINCT `major` FROM student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;

    }
}
