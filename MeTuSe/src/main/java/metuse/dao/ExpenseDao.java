
package metuse.dao;

import java.sql.SQLException;
import java.util.List;
import metuse.domain.Expense;

public interface ExpenseDao {
    
    /**
     * Luo uuden menon
     *
     * @param expense meno joka halutaan luoda
     * @return Palauttaa true jos meno luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    boolean create(Expense expense) throws SQLException;
    
    /**
     * Hakee käyttäjän menot
     *
     * @param id käyttäjän id, jonka menot halutaan hakea
     * @return Palauttaa listan käyttäjän menoista
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    List<Expense> getUserExpenses(int id) throws SQLException;
    
     /**
     * Hakee käyttäjän menojen yhteissumman
     *
     * @param id käyttäjän id, jonka menojen summa halutaan hakea
     * @return Palauttaa menojen yhteisumman double arvona
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    double getUserExpensesSum(int id) throws SQLException;
}
