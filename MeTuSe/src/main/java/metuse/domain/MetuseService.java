package metuse.domain;

import metuse.dao.UserDao;
import java.sql.*;

public class MetuseService {
    
    private final UserDao userDao;
    private User loggedIn;
    
    public MetuseService(UserDao uDao) {
        this.userDao = uDao;
    }
    
    public boolean createUser(String name, String username) throws SQLException {
        User user = new User(name, username);
        return userDao.create(user);
    }
    
    public void logout() {
        loggedIn = null;
    }
    
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        loggedIn = user;
        return true;
    }
}
