package metuse.domain;

import java.sql.SQLException;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.UserDao;
import metuse.domain.Income;
import metuse.domain.MetuseService;
import metuse.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MetuseServiceIncomeTest {

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
        service.login("test");
        incomeDao.create(new Income("test", 2.5, 1));
    }
    
    @Test
    public void incomeListIsEmptyBeforeLoggingIn() throws SQLException {
        service.logout();
        List<Income> incomes = service.getIncomes(); 
        assertEquals(0, incomes.size());
    }    
    
    @Test
    public void incomeListContainsUsersIncomesAfterLogin() throws SQLException {
        List<Income> incomes = service.getIncomes(); 
        assertEquals(1, incomes.size());
        Income i = incomes.get(0);
        assertEquals("test", i.getName());
        assertEquals("2.5", String.valueOf(i.getAmount()));
        assertEquals(1, i.getUserId());
    }    
    
    @Test
    public void incomeListContainsAddedIncome() throws SQLException {      
        incomeDao.create(new Income("inc", 4.7, 1));
        List<Income> incomes = service.getIncomes();               
        assertEquals(2, incomes.size());
        Income i = incomes.get(1);
        assertEquals("inc", i.getName());
        assertEquals("4.7", String.valueOf(i.getAmount()));
        assertEquals(1, i.getUserId());
    } 
    
    @Test
    public void incomeListContainsOnlyLoggedInUsersIncomes() throws SQLException {
        userDao.create(new User("test2", "test2"));
        service.logout();
        service.login("test2");
        List<Income> incomes = service.getIncomes();               
        assertEquals(0, incomes.size());
    } 
    
    @After
    public void tearDown() {
    }

}
