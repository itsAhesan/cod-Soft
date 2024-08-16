package com.codSoft.atm;

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else if (bankAccount.getBalance() < amount) {
            System.out.println("Insufficient funds. Your current balance is: $" + bankAccount.getBalance());
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            System.out.println("Withdrawal successful. Your new balance is: $" + bankAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            System.out.println("Deposit successful. Your new balance is: $" + bankAccount.getBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + bankAccount.getBalance());
    }
}
