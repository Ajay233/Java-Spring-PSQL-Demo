package bankaccount.demo;

import javax.validation.constraints.NotNull;

public class BankAccount {

    @NotNull
    private String name;
    private int accountNumber;
    private double balance;

//  @Size(min=4, max=4)
//  @NotNull
    private int pin;

//  @Size(min=6, max=6)
//  @NotNull
    private int sortCode;

//    public BankAccount(int accountNumber, int sortCode, double balance, int pin){
//        this.accountNumber = accountNumber;
//        this.sortCode = sortCode;
//        this.balance = balance;
//        this.pin = pin;
//    }


    //Getter and setters for name
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


    // Getter and Setters for balance
    public void deposit(int pin, double moneyIn){
        this.balance += moneyIn;
    }

    public void withdraw(int pin, double moneyOut){
        if (this.pin == pin) {
            if (this.balance >= moneyOut){
                this.balance -= moneyOut;
                System.out.println("New balance is: " + this.balance);
            }
        } else
            System.out.println("Incorrect Pin");
    }

    public double displayBalance(int pin){
        if (this.pin != pin) {
            System.out.println("Incorrect Pin");
        }
        return this.balance;
    }


    //Setters and getters for account number
    public void setAccountNumber(int num){
        this.accountNumber = num;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }


    // getters and setters for sort code
    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getSortCode(){
        return this.sortCode;
    }

    public void setPin(int num){
        this.pin = num;
    }

    public int getPin(){
        return this.pin;
    }

    // This method will create a string of key value pairs that can be used by session variables
    public String toString() {
        return "BankAccount(Name" + this.name + "AccountNumber:" + this.accountNumber + "SortCode: " + this.sortCode + "Balance: " + this.balance + "Pin: " + this.pin + ")";
    }


}
