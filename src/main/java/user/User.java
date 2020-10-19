package user;

import exception.UserAlreadyRegisteredException;

public class User {

    private Boolean isRegistered;
    private String username;
    private String password;
    private Double balance;

    public User() {
        this.isRegistered = false;
        this.balance = 0.0;
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
}
