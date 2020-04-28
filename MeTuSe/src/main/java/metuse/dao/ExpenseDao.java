
package metuse.dao;

import java.sql.SQLException;
import java.util.List;
import metuse.domain.Expense;

public interface ExpenseDao {
    
    boolean create(Expense expense) throws SQLException;
    List<Expense> getUserExpenses(int id) throws SQLException;
    double getUserExpensesSum(int id) throws SQLException;
}
