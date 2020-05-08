package metuse.domain;

import java.sql.SQLException;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.UserDao;
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
        User test2 = new User("test2", "test2");
        userDao.create(test2);
        service.login("test");
        expenseDao.create(new Expense("test", 2.5, 1));
    }

    @Test
    public void expenseListContainsUsersExpensesAfterLoggingIn() throws SQLException {
        List<Expense> expenses = service.getExpenses();
        Expense expense = expenses.get(0);
        assertEquals("test", expense.getName());
        assertEquals("2.5", String.valueOf(expense.getAmount()));
        assertEquals(1, expense.getUserId());
        assertEquals(1, expenses.size());
    }

    @Test
    public void expenseListIsEmptyBeforeLoggingIn() throws SQLException {
        service.logout();
        List<Expense> expenses = service.getExpenses();
        assertEquals(0, expenses.size());
    }

    @Test
    public void expenseListContainsAddedExpense() throws SQLException {
        service.createExpense("test1expense", 10.0);
        List<Expense> expenses = service.getExpenses();
        Expense expense = expenses.get(1);
        assertEquals("test1expense", expense.getName());
        assertEquals("10.0", String.valueOf(expense.getAmount()));
        assertEquals(1, expense.getUserId());
        assertEquals(2, expenses.size());
    }
    
    @Test
    public void expenseListOnlyContainsExpensesOfLoggedInUser() throws SQLException {
        service.createExpense("test1expense", 10.0);
        service.logout();
        service.login("test2");
        service.createExpense("test2income", 20.0);
        List<Expense> expenses = service.getExpenses();
        assertEquals(1, expenses.size());
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
}
