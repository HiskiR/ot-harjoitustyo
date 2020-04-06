package metuse.dao;

import java.sql.*;

public class Database {

    private String dbAddress;
    
    public Database(String dbAddress) throws SQLException {
        this.dbAddress = dbAddress;
        try {
            Connection c = DriverManager.getConnection(dbAddress);
            Statement s = c.createStatement();
            s.execute("CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY, name VARCHAR, username VARCHAR UNIQUE);");
            s.execute("CREATE TABLE IF NOT EXISTS Expenses(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
            s.execute("CREATE TABLE IF NOT EXISTS Incomes(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
            c.close();
        } catch (SQLException e) {
            System.out.println("ERROR: could not create database");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(dbAddress);
        return c;
    }
}
