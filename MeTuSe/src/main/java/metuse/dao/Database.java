package metuse.dao;

import java.sql.*;

public class Database {

    public Database() throws SQLException {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement s = c.createStatement();
            s.execute("CREATE TABLE Users(id INTEGER PRIMARY KEY, name VARCHAR, username VARCHAR UNIQUE);");

        } catch (SQLException e) {
            System.out.println("ERROR: could not create database");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");
        return db;

    }
}
