
package metuse.dao;

import java.sql.SQLException;
import metuse.domain.Expense;

public interface ExpenseDao {
    
    boolean create(Expense expense) throws SQLException;
}
