package bank;

public interface Transactions {

    void save(int amount);

    Boolean contains(Transaction transaction);

    History generateHistory();

    
}
