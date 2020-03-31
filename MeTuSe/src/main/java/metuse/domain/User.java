package metuse.domain;

/**
 * Sovelluksen käyttäjää kuvaava luokka 
 */

public class User {
    final private String name;
    final private String username;

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
    
}