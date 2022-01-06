package database_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static final String hostName = "localhost";
    private static final String dbName = "dbgroup6";
    private static final String userName = "root";
    private static final String password = "";
    // jdbc:mysql://hostname:port/dbname
    private static final String connectionURL = "jdbc:mysql://" + hostName + ":3307/" + dbName;

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        // 1. Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. Open connection
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
