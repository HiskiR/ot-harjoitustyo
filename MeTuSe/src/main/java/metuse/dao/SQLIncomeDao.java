package metuse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import metuse.domain.Income;

public class SQLIncomeDao implements IncomeDao {

    final private Database db;
    private List<Income> incomes;

    public SQLIncomeDao(Database db) throws SQLException {
        this.db = db;
    }

    @Override
    public boolean create(Income income) {
        try {
            Connection c = db.getConnection();
            PreparedStatement s = c.prepareStatement("INSERT INTO Expenses(name, amount, user_id, date) "
                    + "VALUES (?, ?, ?, date('now', 'localtime'));");
            s.setString(1, income.getName());
            s.setDouble(2, income.getAmount());
            s.setInt(3, income.getUserId());
            s.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
