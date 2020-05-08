package metuse.domain;

import metuse.dao.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import metuse.dao.ExpenseDao;
import metuse.dao.IncomeDao;

/**
 * Sovelluslogiikasta vastaava luokka
 */
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
    
    /**
     * Uuden käyttäjän luominen
     * @param name käyttäjän nimi
     * @param username käyttäjänimi
     * 
     * @return true jos käyttäjä luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public boolean createUser(String name, String username) throws SQLException {
        User user = new User(name, username);
        return userDao.create(user);
    }
    
    /**
     * Uuden menon luominen
     * @param name menon nimi
     * @param amount menon määrä
     * 
     * @return true jos meno luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public boolean createExpense(String name, Double amount) throws SQLException {
        Expense expense = new Expense(name, amount, loggedIn.getId());
        return expenseDao.create(expense);
    }
    
    
    /**
     * Uuden tulon luominen
     * @param name tulon nimi
     * @param amount tulon määrä
     * 
     * @return true jos tulo luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public boolean createIncome(String name, Double amount) throws SQLException {
        Income income = new Income(name, amount, loggedIn.getId());
        return incomeDao.create(income);
    }

    
    /**
     * Kirjautuneen käyttäjän menot
     * 
     * @return Kirjautuneen käyttäjän menot
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public List<Expense> getExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        if (loggedIn != null) {
            expenses = expenseDao.getUserExpenses(loggedIn.getId());
        }
        return expenses;
    }
    
    /**
     * Kirjautuneen käyttäjän menojen summa
     * 
     * @return Kirjautuneen käyttäjän menojen summa
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public double getExpensesSum() throws SQLException {
        double sum = 0;
        if (loggedIn != null) {
            sum = expenseDao.getUserExpensesSum(loggedIn.getId());
        }
        return sum;
    }
    
     /**
     * Kirjautuneen käyttäjän tulot
     * 
     * @return Kirjautuneen käyttäjän tulot
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public List<Income> getIncomes() throws SQLException {
        List<Income> incomes = new ArrayList<>();
        if (loggedIn != null) {
            incomes = incomeDao.getUserIncomes(loggedIn.getId());
        }
        return incomes;
    }
    
    /**
     * Kirjautuneen käyttäjän tulojen summa
     * 
     * @return Kirjautuneen käyttäjän tulojen summa
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    public double getIncomesSum() throws SQLException {
        double sum = 0;
        if (loggedIn != null) {
            sum = incomeDao.getUserIncomesSum(loggedIn.getId());
        }
        return sum;
    }
    
    /**
     * Käyttäjän uloskirjaaminen
     */
    public void logout() {
        loggedIn = null;
    } 
    
    /**
     * Sisäänkirjautuminen
     * 
     * @param username käyttäjätunnus
     * 
     * @return true jos käyttäjätunnus löytyy, muuten false
     */
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
