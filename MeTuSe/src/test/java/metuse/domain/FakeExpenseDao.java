
package metuse.domain;

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
        expenses.add(expense);
        return true;
    }
    
    @Override
    public List<Expense> getUserExpenses(int id) {
        List<Expense> userExpenses = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getUserId() == id) {
                userExpenses.add(e);
            }
        }
        return userExpenses;
    }
    
    public double getUserExpensesSum(int id) {
        double sum = 0;
        for (Expense e : expenses) {
            if (e.getUserId() == id) {
                sum += e.getAmount();
            }
        }
        return sum;
    }    
}
