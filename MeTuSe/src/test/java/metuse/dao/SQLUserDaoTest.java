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
        db = new Database();
        dao = new SQLUserDao(db);
        Connection c = db.getConnection();
        PreparedStatement s = c.prepareStatement("INSERT INTO Users(name, username) VALUES (?, ?);");
        s.setString(1, "nameTest");
        s.setString(2, "usernameTest");
        s.executeUpdate();
    }
    
    @Test
    public void createReturnsTrueIfUserCreated() throws SQLException {
        User u = new User("test", "test");
        assertTrue(dao.create(u));
    }
    
    @Test
    public void createReturnsFalseIfUserNotCreated() throws SQLException {
        User u = new User("nameTest", "usernameTest");
        assertTrue(!dao.create(u));
    }
    
    @Test
    public void findByUsernameReturnsNullIfUserIsNotFound(){
        assertEquals(null, dao.findByUsername("notFound"));
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Users");
    }

}
