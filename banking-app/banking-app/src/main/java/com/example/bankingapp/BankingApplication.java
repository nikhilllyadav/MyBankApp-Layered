package com.example.bankingapp;

import com.example.bankingapp.controller.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankingApplication implements CommandLineRunner {

    private final AccountController accountController;

    @Autowired
    public BankingApplication(AccountController accountController) {
        this.accountController = accountController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountController.run();
    }
}