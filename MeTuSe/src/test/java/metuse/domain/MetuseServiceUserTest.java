
package metuse.domain;

import java.sql.SQLException;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.UserDao;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MetuseServiceUserTest {
    
    UserDao userDao;
    ExpenseDao expenseDao;
    IncomeDao incomeDao;
    MetuseService service;
    
    @Before
    public void setUp() throws SQLException {
        userDao = new FakeUserDao();
        expenseDao = new FakeExpenseDao();
        incomeDao = new FakeIncomeDao();
        service = new MetuseService(userDao, expenseDao, incomeDao);
    }
    
     @Test
    public void cannotLoginIfUserDoesNotExist() {
        assertFalse(service.login("notUser"));   
        assertEquals(null, service.getLoggedIn());
    }    
    
    @Test
    public void userCanLogIn() {
        assertTrue(service.login("test"));       
        User loggedIn = service.getLoggedIn();
        assertEquals(1, loggedIn.getId() );
    }
    
    @Test
    public void loggedInUserCanLogout() {
        service.login("test");
        service.logout();    
        assertEquals(null, service.getLoggedIn());
    }    
    
    @Test
    public void createUserReturnsFalseIfUsernameNotUnique() throws Exception {
        assertFalse(service.createUser("test", "name"));
    }
}
