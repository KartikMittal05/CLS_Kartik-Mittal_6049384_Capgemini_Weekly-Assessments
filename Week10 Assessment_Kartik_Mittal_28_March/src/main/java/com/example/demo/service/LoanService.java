package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Loan;

public interface LoanService {

    Loan createLoan(Loan loan);

    List<Loan> getAllLoans();

    Loan getLoanById(Long id);

    Loan updateLoanStatus(Long id, String status);
}