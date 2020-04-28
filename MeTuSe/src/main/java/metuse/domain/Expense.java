package metuse.domain;

/**
 * Menoa kuvaava luokka 
 */

public class Expense {
    
    final private int userId;
    private String name;
    private double amount;
    
     /**
     *
     * @param name menon nimi
     * @param amount menon määrä desimaalilukuna
     * @param userId menon käyttäjän id
     */
    public Expense(String name, double amount, int userId) {
        this.name = name;
        this.amount = amount;
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
    
    public int getUserId() {
        return userId;
    }
}
