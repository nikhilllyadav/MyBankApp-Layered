package com.example.bankingapp.controller;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class AccountController {

    private final AccountService accountService;
    private final Scanner scanner;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewAccount();
                    break;
                case 5:
                    listAllAccounts();
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- Banking System Menu ---");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Account");
        System.out.println("5. List All Accounts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        BigDecimal balance = scanner.nextBigDecimal();
        scanner.nextLine();

        Account newAccount = accountService.createAccount(name, balance);
        System.out.println("Account created successfully: " + newAccount);
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        Long id = scanner.nextLong();
        System.out.print("Enter amount to deposit: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        Account updatedAccount = accountService.deposit(id, amount);
        if (updatedAccount != null) {
            System.out.println("Deposit successful. New balance: " + updatedAccount.getBalance());
        } else {
            System.out.println("Deposit failed. Check account ID and amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter account ID: ");
        Long id = scanner.nextLong();
        System.out.print("Enter amount to withdraw: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        Account updatedAccount = accountService.withdraw(id, amount);
        if (updatedAccount != null) {
            System.out.println("Withdrawal successful. New balance: " + updatedAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Check account ID and sufficient balance.");
        }
    }

    private void viewAccount() {
        System.out.print("Enter account ID to view: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Account> account = accountService.getAccountById(id);
        if (account.isPresent()) {
            System.out.println("Account details: " + account.get());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void listAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("--- All Accounts ---");
            accounts.forEach(System.out::println);
        }
    }
}