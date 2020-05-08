package metuse.dao;

import java.sql.*;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import metuse.domain.User;

public class SQLUserDaoTest {
    
    UserDao dao;
    Database db;
    
    @Before
    public void setUp() throws SQLException {
        db = new Database("jdbc:sqlite:test.db");
        dao = new SQLUserDao(db);
        User user = new User("name", "username");
        Connection c = db.getConnection();
        PreparedStatement s = c.prepareStatement("INSERT INTO Users(name, username) VALUES (?, ?);");
        s.setString(1, user.getName());
        s.setString(2, user.getUsername());
        s.executeUpdate();
        dao.setId(user);
        c.close();
    }
    
    @Test
    public void createReturnsTrueIfUserCreated() throws SQLException {
        User u = new User("test", "test");
        assertTrue(dao.create(u));
    }
    
    @Test
    public void createReturnsFalseIfUserNotCreated() throws SQLException {
        User u = new User("name", "username");
        assertTrue(!dao.create(u));
    }
    
    @Test
    public void findByUsernameReturnsUserIfUserIsFound() {
        User user = dao.findByUsername("username");
        assertEquals("name", user.getName());
        assertEquals("username", user.getUsername()); 
    }
    
    @Test
    public void findByUsernameReturnsNullIfUserIsNotFound(){
        assertEquals(null, dao.findByUsername("notFound"));
    }
    
    @Test
    public void createdUserIsFound() throws SQLException {
        User newUser = new User("newN", "newU");
        dao.create(newUser);
        User user = dao.findByUsername("newU");
        assertEquals("newN", user.getName());
        assertEquals("newU", user.getUsername()); 
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Users");
        c.close();
    }

}
