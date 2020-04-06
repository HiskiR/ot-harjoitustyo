package metuse.dao;

import java.sql.*;

public class Database {

    public Database() throws SQLException {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement s = c.createStatement();
            s.execute("CREATE TABLE Users(id INTEGER PRIMARY KEY, name VARCHAR, username VARCHAR UNIQUE);");
            s.execute("CREATE TABLE Expenses(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
            s.execute("CREATE TABLE Incomes(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
        } catch (SQLException e) {
            System.out.println("ERROR: could not create database");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");
        return db;

    }
}
