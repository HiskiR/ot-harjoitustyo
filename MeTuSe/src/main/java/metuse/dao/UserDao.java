package metuse.dao;

import java.sql.SQLException;
import metuse.domain.User;

public interface UserDao {
    
    /**
     * Luo uuden käyttäjän
     *
     * @param user käyttäjä joka halutaan luoda
     * @return Palauttaa true, jos käyttäjä luotiin, muuten false
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    boolean create(User user) throws SQLException;
    
    /**
     * Etsii annettua käyttäjätunnusta vastaavan käyttäjän
     *
     * @param username käyttäjätunnus
     * @return User löydetty käyttäjä
     */
    User findByUsername(String username);
    
    /**
     * Asettaa käyttäjä-oliolle sille tietokannasta löytyvän id:n
     * @param user käyttäjä
     * @throws java.sql.SQLException virhe tietokannan kanssa
     */
    void setId(User user) throws SQLException;
    
}
