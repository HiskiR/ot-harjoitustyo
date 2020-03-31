package metuse.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import metuse.domain.User;

public class SQLUserDao implements UserDao {

    final private Database db;
    private List<User> users;

    public SQLUserDao(Database db) throws SQLException {
        this.db = db;
        users = new ArrayList<>();
        ResultSet r = db.getConnection().createStatement().executeQuery("SELECT * FROM Users");
        while (r.next()) {
            users.add(new User(r.getString("name"), r.getString("username")));
        }
    }

    @Override
    public boolean create(User user) throws SQLException {
        try {
            Connection c = db.getConnection();
            PreparedStatement s = c.prepareStatement("INSERT INTO Users(name, username) VALUES (?, ?);");
            s.setString(1, user.getName());
            s.setString(2, user.getUsername());
            s.executeUpdate();
            users.add(user);
        } catch (SQLException e) {
            return false;
        } 
        return true;
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
