
package metuse.dao;

import java.sql.SQLException;
import metuse.domain.Income;

public interface IncomeDao {
    
    boolean create(Income income) throws SQLException;
    
}
