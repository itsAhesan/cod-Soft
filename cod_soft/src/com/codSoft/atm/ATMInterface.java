package com.codSoft.atm;

import java.util.Scanner;

public class ATMInterface {

	
		
		 public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        BankAccount bankAccount = new BankAccount(1000.00);  // Initial balance
		        ATM atm = new ATM(bankAccount);

		        while (true) {
		            System.out.println("\nATM Menu:");
		            System.out.println("1. Withdraw");
		            System.out.println("2. Deposit");
		            System.out.println("3. Check Balance");
		            System.out.println("4. Exit");
		            System.out.print("Choose an option: ");
		            int option = scanner.nextInt();

		            switch (option) {
		                case 1:
		                    System.out.print("Enter amount to withdraw: ");
		                    double withdrawAmount = scanner.nextDouble();
		                    atm.withdraw(withdrawAmount);
		                    break;
		                case 2:
		                    System.out.print("Enter amount to deposit: ");
		                    double depositAmount = scanner.nextDouble();
		                    atm.deposit(depositAmount);
		                    break;
		                case 3:
		                    atm.checkBalance();
		                    break;
		                case 4:
		                    System.out.println("Thank you for using the ATM. Goodbye!");
		                    scanner.close();
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Invalid option. Please try again.");
		            }
		        }
		    }
		

	

}
