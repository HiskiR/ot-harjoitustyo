
package metuse.domain;

import java.sql.SQLException;
import metuse.dao.Database;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;
import metuse.dao.SQLExpenseDao;
import metuse.dao.SQLIncomeDao;
import metuse.dao.SQLUserDao;
import metuse.dao.UserDao;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MetuseServiceUserTest {
    
    Database db;
    UserDao userDao;
    ExpenseDao expenseDao;
    IncomeDao incomeDao;
    MetuseService service;
    
    @Before
    public void setUp() throws SQLException {
        db = new Database("jdbc:sqlite:test.db");
        userDao = new SQLUserDao(db);
        expenseDao = new SQLExpenseDao(db);
        incomeDao = new SQLIncomeDao(db);
        service = new MetuseService(userDao, expenseDao, incomeDao);
    }
    
    @After
    public void tearDown() {
    }

}
