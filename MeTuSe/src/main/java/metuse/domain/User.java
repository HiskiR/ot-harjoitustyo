package metuse.domain;

/**
 * Käyttäjää kuvaava luokka 
 */

public class User {
    final private String name;
    final private String username;
    private int id;

     /**
     *
     * @param name käyttäjän nimi
     * @param username käyttäjän käyttäjänimi
     */
    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
}