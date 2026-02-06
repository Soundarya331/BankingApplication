package com.bankingapplication;

public class Application {

    public static boolean isValidPin(String pin) {
        if (pin == null || pin.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(pin);
        } catch (NumberFormatException e) {
            return false;
        }
        return pin.length() == 4;
    }

   
    public static boolean hasSufficientBalance(InputClass input) {
        return input.getAmount() <= input.getBalanceAmount();
    }

    public static void processTransaction(InputClass input) {
        if (!hasSufficientBalance(input)) {
            System.out.println("Transaction Rejected : Insufficient Balance");
        } else {
            System.out.println("Transaction Approved");
        }
    }
}
