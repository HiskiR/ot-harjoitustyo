package metuse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metuse.domain.Income;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SQLIncomeDaoTest {

    IncomeDao dao;
    Database db;

    @Before
    public void setUp() throws SQLException {
        db = new Database("jdbc:sqlite:test.db");
        dao = new SQLIncomeDao(db);
    }

    @Test
    public void createReturnsTrueIfIncomeCreated() throws SQLException {
        Income i = new Income("tulo", 10, 1);
        assertTrue(dao.create(i));
    }
    
    @Test
    public void getUserIncomesReturnsAnEmptyListIfNoIncomes() throws SQLException {
        List<Income> empty = new ArrayList<>();
        assertEquals(empty, dao.getUserIncomes(1));
    }
    
    @Test
    public void getUserIncomesReturnsCreatedIncomes() throws SQLException {
        dao.create(new Income("tulo", 10, 1));
        List<Income> incomes = dao.getUserIncomes(1);
        Income income = incomes.get(0);
        assertEquals("tulo", income.getName());
        assertEquals("10.0", String.valueOf(income.getAmount()));
        assertEquals("1", String.valueOf(income.getUserId()));
    }
    
    @Test
    public void getUserIncomesSumReturnsSum() throws SQLException {
        dao.create(new Income("tulo", 10, 1));
        dao.create(new Income("tulo2", 12, 1));
        double sum = dao.getUserIncomesSum(1);
        assertEquals("22.0", String.valueOf(sum));
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Incomes");
        s.close();
    }

}
