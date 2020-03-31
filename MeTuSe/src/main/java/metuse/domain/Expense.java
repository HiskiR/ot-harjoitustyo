package metuse.domain;

/**
 * Yksittäistä menoa kuvaava luokka 
 */

public class Expense {
    
    private int id;
    private String name;
    private double amount;
    final private User user;
    
    public Expense(String name, double amount, User user) {
        this.name = name;
        this.amount = amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }
    
}
