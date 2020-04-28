package metuse.domain;

import metuse.dao.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;

public class MetuseService {

    private final UserDao userDao;
    private final ExpenseDao expenseDao;
    private final IncomeDao incomeDao;
    private User loggedIn;

    public MetuseService(UserDao uDao, ExpenseDao eDao, IncomeDao iDao) {
        this.userDao = uDao;
        this.expenseDao = eDao;
        this.incomeDao = iDao;
    }

    public boolean createUser(String name, String username) throws SQLException {
        User user = new User(name, username);
        return userDao.create(user);
    }

    public boolean createExpense(String name, Double amount) throws SQLException {
        Expense expense = new Expense(name, amount, loggedIn.getId());
        return expenseDao.create(expense);
    }

    public boolean createIncome(String name, Double amount) throws SQLException {
        Income income = new Income(name, amount, loggedIn.getId());
        return incomeDao.create(income);
    }

    public List<Expense> getExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        if (loggedIn != null) {
            expenses = expenseDao.getUserExpenses(loggedIn.getId());
        }
        return expenses;
    }
    
    public double getExpensesSum() throws SQLException {
        double sum = 0;
        if (loggedIn != null) {
            sum = expenseDao.getUserExpensesSum(loggedIn.getId());
        }
        return sum;
    }

    public List<Income> getIncomes() throws SQLException {
        List<Income> incomes = new ArrayList<>();
        if (loggedIn != null) {
            incomes = incomeDao.getUserIncomes(loggedIn.getId());
        }
        return incomes;
    }
    
    public double getIncomesSum() throws SQLException {
        double sum = 0;
        if (loggedIn != null) {
            sum = incomeDao.getUserIncomesSum(loggedIn.getId());
        }
        return sum;
    }

    public void logout() {
        loggedIn = null;
    }

    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        loggedIn = user;
        return true;
    }
    
    public User getLoggedIn() {
        return this.loggedIn;
    }
}
