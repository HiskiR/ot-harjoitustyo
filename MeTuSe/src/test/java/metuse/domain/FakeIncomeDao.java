package metuse.domain;

import java.util.ArrayList;
import java.util.List;
import metuse.dao.Database;
import metuse.dao.IncomeDao;

public class FakeIncomeDao implements IncomeDao {
    
    List<Income> incomes;
    
    public FakeIncomeDao() {
        incomes = new ArrayList<>();
        final Database db;
    }
    
    @Override
    public boolean create(Income income) {
        try {
            incomes.add(income);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public List<Income> getUserIncomes(int id) {
        for (Income i : incomes) {
            if (i.getUserId() == id) {
                incomes.add(i);
            }
        }
        return incomes;
    }
    
    @Override
    public double getUserIncomesSum(int id) {
        double sum = 0;
        for (Income i : incomes) {
            if (i.getUserId() == id) {
                sum += i.getAmount();
            }
        }
        return sum;
    }    
}

