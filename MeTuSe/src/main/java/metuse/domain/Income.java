package metuse.domain;

/**
 * Tuloa kuvaava luokka 
 */

public class Income {
    
    private int userId;
    private String name;
    private double amount;
    
     /**
     *
     * @param name tulon nimi
     * @param amount tulon määrä desimaalilukuna
     * @param userId tulon käyttäjän id
     */
    public Income(String name, double amount, int userId) {
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
        return this.userId;
    }
    
}
