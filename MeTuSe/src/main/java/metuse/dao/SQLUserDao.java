package metuse.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import metuse.domain.User;

public class SQLUserDao implements UserDao {

    final private Database db;
    private List<User> users;
    
    /**
     * @param db tietokanta, johon käyttäjät tallennetaan
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public SQLUserDao(Database db) throws SQLException {
        this.db = db;
        users = new ArrayList<>();
        Connection c = db.getConnection();
        ResultSet r = c.createStatement().executeQuery("SELECT * FROM Users");
        while (r.next()) {
            User user = new User(r.getString("name"), r.getString("username"));
            user.setId(r.getInt("id"));
            users.add(user);
        }
        c.close();
    }

    @Override
    public boolean create(User user) throws SQLException {
        try {
            Connection c = db.getConnection();
            PreparedStatement s = c.prepareStatement("INSERT INTO Users(name, username) VALUES (?, ?);");
            s.setString(1, user.getName());
            s.setString(2, user.getUsername());
            s.executeUpdate();
            s.close();
            setId(user);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    /**
     * Asettaa käyttäjä-oliolle sille tietokannasta löytyvän id:n
     * @param user käyttäjä
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    @Override
    public void setId(User user) throws SQLException {
        Connection c = db.getConnection();
        PreparedStatement s = c.prepareStatement("SELECT id FROM Users WHERE username = ?");
        s.setString(1, user.getUsername());
        ResultSet r = s.executeQuery();
        if (r.next()) {
            user.setId(r.getInt("id"));
        }
        users.add(user);
        s.close();
        c.close();
    }

    @Override
    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
