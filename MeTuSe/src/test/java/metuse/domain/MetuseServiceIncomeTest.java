package metuse.domain;

import java.sql.SQLException;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.UserDao;
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
        User test2 = new User("test2", "test2");
        userDao.create(test2);
        service.login("test");
        incomeDao.create(new Income("test", 2.5, 1));
    }

    @Test
    public void incomeListContainsUsersIncomesAfterLoggingIn() throws SQLException {
        List<Income> incomes = service.getIncomes();
        Income income = incomes.get(0);
        assertEquals("test", income.getName());
        assertEquals("2.5", String.valueOf(income.getAmount()));
        assertEquals(1, income.getUserId());
        assertEquals(1, incomes.size());
    }

    @Test
    public void incomeListIsEmptyBeforeLoggingIn() throws SQLException {
        service.logout();
        List<Income> incomes = service.getIncomes();
        assertEquals(0, incomes.size());
    }

    @Test
    public void incomeListContainsAddedIncome() throws SQLException {
        service.createIncome("test1income", 10.0);;
        List<Income> incomes = service.getIncomes();
        Income income = incomes.get(1);
        assertEquals("test1income", income.getName());
        assertEquals("10.0", String.valueOf(income.getAmount()));
        assertEquals(1, income.getUserId());
        assertEquals(2, incomes.size());
    }

    @Test
    public void incomeListOnlyContainsIncomesOfLoggedInUser() throws SQLException {
        service.createIncome("test1income", 10.0);
        service.logout();
        service.login("test2");
        service.createIncome("test2income", 20.0);
        List<Income> incomes = service.getIncomes();
        assertEquals(1, incomes.size());
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
}
