package metuse.dao;

import java.sql.SQLException;
import metuse.domain.User;

public interface UserDao {
    
    boolean create(User user) throws SQLException;
    User findByUsername(String username);
    
}
