
package metuse.domain;

import java.util.ArrayList;
import java.util.List;
import metuse.dao.IncomeDao;


public class FakeIncomeDao implements IncomeDao{
    
    List<Income> incomes;
    
    public FakeIncomeDao() {
        incomes = new ArrayList<>();
    }
    
    @Override
    public boolean create(Income income) {
        incomes.add(income);
        return true;
    }
    
    @Override
    public List<Income> getUserIncomes(int id) {
        List<Income> userIncomes = new ArrayList<>();
        for (Income i : incomes) {
            if (i.getUserId() == id) {
                userIncomes.add(i);
            }
        }
        return userIncomes;
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

