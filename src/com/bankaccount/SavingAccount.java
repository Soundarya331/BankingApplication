package com.bankaccount;

public class SavingAccount extends Account {

    @Override
    public void deposit(String accountNumber, Customer customer, double amount) {

        if (!this.accountNumber.equals(accountNumber)) {
            System.out.println("Invalid account number");
            return;
        }

        if (!this.customer.getCustId().equals(customer.getCustId())) {
            System.out.println("Invalid customer");
            return;
        }

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero");
            return;
        }
        

        
        if(amount>0 && accountBalance==0) {
        	System.out.println("Account created");
        }
        accountBalance = accountBalance +  amount;
        System.out.println("Deposit successful");
        System.out.println("Customer: " + this.customer.getCustName());
        System.out.println("Updated Balance: " + accountBalance);
    }

    @Override
    public void withdraw(String accountNumber, Customer customer, double amount) {

        if (!this.accountNumber.equals(accountNumber)) {
            System.out.println("Invalid account number");
            return;
        }

        if (!this.customer.getCustId().equals(customer.getCustId())) {
            System.out.println("Invalid customer");
            return;
        }

        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than zero");
            return;
        }

        if (accountBalance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        accountBalance = accountBalance - amount ;

        System.out.println("Withdrawal successful");
        System.out.println("Customer: " + this.customer.getCustName());
        System.out.println("Remaining Balance: " + accountBalance);
    }
}
