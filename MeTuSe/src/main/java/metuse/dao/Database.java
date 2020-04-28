package metuse.dao;

import java.sql.*;

/**
 * Tietokanta
 */
public class Database {

    private String dbAddress;
    
    /**
     * Luo tietokantataulut
     *
     * @param dbAddress tietokannan osoite
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public Database(String dbAddress) throws SQLException {
        this.dbAddress = dbAddress;
        Connection c = DriverManager.getConnection(dbAddress);
        Statement s = c.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY, name VARCHAR, username VARCHAR UNIQUE);");
        s.execute("CREATE TABLE IF NOT EXISTS Expenses(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
        s.execute("CREATE TABLE IF NOT EXISTS Incomes(id INTEGER PRIMARY KEY, name VARCHAR, amount DOUBLE, date DATE, user_id INTEGER REFERENCES Users);");
        c.close();
    }
    
    /**
     * Mahdollistaa tietokannan käytön ottamalla siihen yhteyden
     *
     * @return yhteys tietokantaan
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(dbAddress);
        return c;
    }
}
