
package metuse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Expenses");
        s.close();
    }

}