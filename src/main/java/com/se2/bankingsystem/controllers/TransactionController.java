package com.se2.bankingsystem.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.ChargeTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.TransferTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    private final TransferTransactionService transferTransactionService;

    private final ChargeTransactionService chargeTransactionService;

    private final WithdrawTransactionService withdrawTransactionService;

    @Autowired
    public TransactionController(@Qualifier("transactionServiceImpl") TransactionService transactionService, TransferTransactionService transferTransactionService, ChargeTransactionService chargeTransactionService, WithdrawTransactionService withdrawTransactionService) {
        this.transactionService = transactionService;

        this.transferTransactionService = transferTransactionService;
        this.chargeTransactionService = chargeTransactionService;
        this.withdrawTransactionService = withdrawTransactionService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

//    @RequestMapping(value = "/list-transactions", method = RequestMethod.GET)
//    public String showTransactions(ModelMap model) {
//        String name = getLoggedInUserName(model);
//        model.put("transactions", transactionService.getTransactionsByUser(name));
//        // model.put("transactions", service.retrieveTransactions(name));
//        return "list-transactions";
//    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/add-transaction", method = RequestMethod.GET)
    public String showAddTransactionPage(ModelMap model) {
        model.addAttribute("transaction", new Transaction());
        return "shared/transactionDetails";
    }

    @RequestMapping(value = "/delete-transaction", method = RequestMethod.GET)
    public String deleteTransaction(@RequestParam long id) {
        transactionService.deleteById(id);
        return "redirect:/list-transactions";
    }

    @RequestMapping(value = "/update-transaction", method = RequestMethod.GET)
    public String showUpdateTransactionPage(@RequestParam long id, ModelMap model) {
        Object transaction = transactionService.getById(id);
        model.put("transaction", transaction);
        return "shared/transactionDetails";
    }

//    @RequestMapping(value = "/update-transaction", method = RequestMethod.POST)
//    public String updateTransaction(ModelMap model, @Valid Transaction transaction, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "transaction";
//        }
//
//        transaction.setUserName(getLoggedInUserName(model));
//        transactionService.updateById(transaction.getId(), transaction.);
//        return "redirect:/list-transactions";
//    }
//
//    @RequestMapping(value = "/add-transaction", method = RequestMethod.POST)
//    public String addTransaction(ModelMap model, @Valid Transaction transaction, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "transaction";
//        }
//
//        transaction.setUserName(getLoggedInUserName(model));
//        transactionService.saveTransaction(transaction);
//        return "redirect:/list-transactions";
//    }
}