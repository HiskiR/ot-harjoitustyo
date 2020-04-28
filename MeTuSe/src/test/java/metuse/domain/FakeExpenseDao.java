package metuse.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metuse.dao.ExpenseDao;

public class FakeExpenseDao implements ExpenseDao {
    
    List<Expense> expenses;
    
    public FakeExpenseDao() {
        expenses = new ArrayList<>();
    }
    
    @Override
    public boolean create(Expense expense) {
        try {
            expenses.add(expense);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public List<Expense> getUserExpenses(int id) throws SQLException {
        for (Expense e : expenses) {
            if (e.getUserId() == id) {
                expenses.add(e);
            }
        }
        return expenses;
    }
    
    @Override
    public double getUserExpensesSum(int id) throws SQLException {
        double sum = 0;
        for (Expense e : expenses) {
            if (e.getUserId() == id) {
                sum += e.getAmount();
            }
        }
        return sum;
    }    
}
