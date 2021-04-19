package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.id == #id")
    @GetMapping({"/transactions"})
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/transactionsList");
        List<Transaction> transactions = transactionService.findAll();
        modelAndView.addObject(transactions);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.id == #id")
    @GetMapping({"/transactions/{id}"})
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Transaction customer = transactionService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PostMapping("/transactions/{transactionID}/delete")
    public String delete(@PathVariable Long transactionID) {
        transactionService.deleteById(transactionID);
        return "customersList";
    }
}
