
package metuse.dao;

import java.sql.SQLException;
import java.util.List;
import metuse.domain.Income;

public interface IncomeDao {
    
    boolean create(Income income) throws SQLException;
    List<Income> getUserIncomes(int id) throws SQLException;
    double getUserIncomesSum(int id) throws SQLException;
    
}
