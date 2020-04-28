package metuse.domain;

/**
 * Yksittäistä tuloa kuvaava luokka 
 */

public class Income {
    
    private int userId;
    private String name;
    private double amount;
    
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
