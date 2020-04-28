
package metuse.dao;

import java.sql.SQLException;
import java.util.List;
import metuse.domain.Income;

public interface IncomeDao {
    
    
     /**
     * Luo uuden tulon
     *
     * @param income tulo joka halutaan luoda
     * @return Palauttaa true jos tulo luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    boolean create(Income income) throws SQLException;
    
    /**
     * Hakee käyttäjän tulot
     *
     * @param id käyttäjän id, jonka tulot halutaan hakea
     * @return Palauttaa listan käyttäjän tuloista
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    List<Income> getUserIncomes(int id) throws SQLException;
    
     /**
     * Hakee käyttäjän tulojen yhteissumman
     *
     * @param id käyttäjän id, jonka tulojen summa halutaan hakea
     * @return Palauttaa tulojen yhteisumman double arvona
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    double getUserIncomesSum(int id) throws SQLException;
    
}
