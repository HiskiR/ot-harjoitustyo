package metuse.domain;

import java.sql.SQLException;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MetuseServiceExpenseTest {
    
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
        expenseDao.create(new Expense("test", 2.5, 1));      
    }
     
    @Test
    public void expenseListIsEmptyBeforeLoggingIn() throws SQLException {
        service.logout();
        List<Expense> expenses = service.getExpenses(); 
        assertEquals(0, expenses.size());
    }    
    
    @Test
    public void getExpensesSumReturnsZeroIfNotLoggedIn() throws SQLException {
        service.logout();
        double sum = service.getExpensesSum();
        assertEquals("0.0", String.valueOf(sum));
    }
    
    @Test
    public void getExpensesSumReturnsCorrectSumIfLoggedIn() throws SQLException {
        expenseDao.create(new Expense("exp", 4.7, 1));
        double sum = service.getExpensesSum();
        assertEquals("7.2", String.valueOf(sum));
    }
    
    @After
    public void tearDown() {
    }
    
}
