package metuse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metuse.dao.Database;
import metuse.dao.IncomeDao;
import metuse.dao.SQLIncomeDao;
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
        List<Income> incomes = new ArrayList<>();
        assertEquals(incomes, dao.getUserIncomes(1));
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection c = db.getConnection();
        Statement s = c.createStatement();
        s.execute("DROP TABLE Incomes");
        s.close();
    }

}
