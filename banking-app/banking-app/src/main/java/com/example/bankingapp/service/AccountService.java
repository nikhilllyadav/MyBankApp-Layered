package com.example.bankingapp.service;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String name, BigDecimal initialBalance) {
        Account account = new Account(name, initialBalance);
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public Account deposit(Long id, BigDecimal amount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                account.setBalance(account.getBalance().add(amount));
                return accountRepository.save(account);
            }
        }
        return null; // or throw an exception
    }

    @Transactional
    public Account withdraw(Long id, BigDecimal amount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (amount.compareTo(BigDecimal.ZERO) > 0 && account.getBalance().compareTo(amount) >= 0) {
                account.setBalance(account.getBalance().subtract(amount));
                return accountRepository.save(account);
            }
        }
        return null; // or throw an exception
    }
}