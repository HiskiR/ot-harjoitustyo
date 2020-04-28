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
    public void getIncomesSumReturnsZeroIfNotLoggedIn() throws SQLException {
        service.logout();
        double sum = service.getIncomesSum();
        assertEquals("0.0", String.valueOf(sum));
    }
    
    @Test
    public void getIncomesSumReturnsCorrectSumIfLoggedIn() throws SQLException {
        incomeDao.create(new Income("inc", 4.7, 1));
        double sum = service.getIncomesSum();
        assertEquals("7.2", String.valueOf(sum));
    }
    
    @After
    public void tearDown() {
    }

}
