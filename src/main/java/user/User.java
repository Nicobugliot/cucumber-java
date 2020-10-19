package user;

import exception.InsufficientFundsException;
import exception.UserAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Boolean isRegistered;
    private String username;
    private String password;
    private Double balance;
    private List<Item> itemList;

    public User() {
        this.isRegistered = false;
        this.balance = 0.0;
        this.itemList = new ArrayList<>();
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    public Boolean isRegistered() {
        return this.isRegistered;
    }

    public void signIn(String username, String password) {
        if (isRegistered) {
            throw new UserAlreadyRegisteredException("User is already registered");
        }

        this.username = username;
        this.password = password;
        this.isRegistered = true;
    }

    public void addBalance(Double amount) {
        this.balance += amount;
    }

    public Double getBalance() {
        return this.balance;
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public void buyItem(Item item) {
        if (this.balance - item.getValue() < 0) {
            throw new InsufficientFundsException("Insufficient founds to buy the item");
        }
        this.itemList.add(item);
        this.balance -= item.getValue();
    }
}
