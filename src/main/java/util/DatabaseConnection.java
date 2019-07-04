package util;

import org.junit.Assert;

import java.sql.*;

/**
 * Created by Mayank Tiwari on 2019-07-04.
 */
public class DatabaseConnection {

    public static String dbUrl;
    public static String username;
    public static String password;
    public static String database_driver;
    Connection con;
    Statement stmt;
    String query;
    ResultSet rs;

    public DatabaseConnection() {
        super();
    }

    public DatabaseConnection createConnection() throws SQLException, ClassNotFoundException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_comparator", "root", "root");
        Class.forName("com.mysql.cj.jdbc.Driver");
        return new DatabaseConnection();
    }

    public DatabaseConnection createQuery() throws SQLException {
        query = "select * from test where no = 1;";
        stmt = con.createStatement();
        return new DatabaseConnection();
    }

    public DatabaseConnection executeQuery() throws SQLException {
        rs = stmt.executeQuery(query);
        return new DatabaseConnection();
    }

    public DatabaseConnection assertRecords(String name) throws SQLException {
        while (rs.next()) {
            String myName = rs.getString(2);
            Assert.assertEquals(myName, name);
        }
        return new DatabaseConnection();
    }

    public DatabaseConnection closeConnection() throws SQLException {
        con.close();
        return new DatabaseConnection();
    }
}