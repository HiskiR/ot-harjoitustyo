package metuse.domain;

/**
 * Yksittäistä menoa kuvaava luokka 
 */

public class Expense {
    
    private int userId;
    private String name;
    private double amount;
    
    public Expense(String name, double amount, int userId) {
        this.name = name;
        this.amount = amount;
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public int getUserId() {
        return userId;
    }
}
