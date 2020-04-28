package metuse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metuse.domain.Income;

public class SQLIncomeDao implements IncomeDao {

    final private Database db;
    private List<Income> incomes;

    public SQLIncomeDao(Database db) throws SQLException {
        incomes = new ArrayList<>();
        this.db = db;
    }

    @Override
    public boolean create(Income income) {
        try {
            Connection c = db.getConnection();
            PreparedStatement s = c.prepareStatement("INSERT INTO Incomes(name, amount, user_id, date) "
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

    @Override
    public List<Income> getUserIncomes(int id) throws SQLException {
        Connection c = db.getConnection();
        PreparedStatement s = c.prepareStatement("SELECT * FROM Incomes WHERE user_id = ?");
        s.setInt(1, id);
        ResultSet r = s.executeQuery();

        while (r.next()) {
            Income i = new Income(r.getString("name"), r.getDouble("amount"), id);
            incomes.add(i);
        }

        return incomes;
    }
    
    @Override
    public double getUserIncomesSum(int id) throws SQLException {
        double sum = 0;
        Connection c = db.getConnection();
        PreparedStatement s = c.prepareStatement("SELECT SUM(Incomes.amount) AS sum FROM Incomes WHERE user_id = ?");
        s.setInt(1, id);
        ResultSet r = s.executeQuery();
        if (r.next()) {
            sum = r.getDouble("sum");
        }
        c.close();
        return sum;
    }
}
