
package metuse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metuse.domain.Expense;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SQLExpenseDaoTest {
    
    ExpenseDao dao;
    Database db;
    
    @Before
    public void setUp() throws SQLException {
        db = new Database("jdbc:sqlite:test.db");
        dao = new SQLExpenseDao(db);
    }
    
    @Test
    public void createReturnsTrueIfExpenseCreated() throws SQLException {
        Expense e = new Expense("meno", 10, 1);
        assertTrue(dao.create(e));
    }
    
    @Test
    public void getUserExpensesReturnsAnEmptyListIfNoExpenses() throws SQLException {
        List<Expense> empty = new ArrayList<>();
        assertEquals(empty, dao.getUserExpenses(1));
    }
    
    @Test
    public void getUserExpensesReturnsCreatedExpenses() throws SQLException {
        dao.create(new Expense("meno", 10, 1));
        List<Expense> expenses = dao.getUserExpenses(1);
        Expense expense = expenses.get(0);
        assertEquals("meno", expense.getName());
        assertEquals("10.0", String.valueOf(expense.getAmount()));
        assertEquals("1", String.valueOf(expense.getUserId()));
    }
    
    @Test
    public void getUserExpensesSumReturnsSum() throws SQLException {
        dao.create(new Expense("meno", 10, 1));
        dao.create(new Expense("meno2", 12, 1));
        double sum = dao.getUserExpensesSum(1);
        assertEquals("22.0", String.valueOf(sum));
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Expenses");
        s.close();
    }

}