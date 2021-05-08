package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TransactionController extends AbstractTransactionController<Transaction, CreateTransactionDTO, UpdateTransactionDTO> {

    public TransactionController(TransactionService transactionService, AuthorityService authorityService, CustomerAccountService customerAccountService, ModelMapper modelMapper) {
        super(
            transactionService,
            authorityService,
            customerAccountService,
            modelMapper,
            "transaction",
            "shared/transaction/transactionsList",
            null,
            null,
            null,
            CreateTransactionDTO.class,
            UpdateTransactionDTO.class
        );
    }

    @Override
    @GetMapping("/admin/transactions")
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @Override
    @GetMapping("/me/transactions")
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @Override
    @GetMapping("/admin/transactions/{id}")
    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        return super.showDetailsByAdmin(id);
    }

    @Override
    @GetMapping("/me/transactions/{id}")
    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        return super.showDetailsByCustomer(id);
    }

    @Override
    @PostMapping("/admin/transactions/{id}/delete")
    public String deleteByAdmin(@PathVariable Long id) {
        return super.deleteByAdmin(id);
    }

    @Override
    @PostMapping("/me/transactions/{id}/delete")
    public String deleteByCustomer(@PathVariable Long id) {
        return super.deleteByCustomer(id);
    }

    private String getRedirectViewName(CustomerAccount customerAccount) throws ClassNotFoundException {

        String viewName;
        if (authorityService.getCurrentAuthority().equals(AuthorityName.ADMIN.name()))
            viewName = "redirect:/admin/";
        else
            viewName = "redirect:/me/";

        if (customerAccount instanceof LoanAccount) {
            viewName += "chargeTransactions/";
        } else if (customerAccount instanceof NormalAccount) {
            viewName += "transferTransactions/";
        } else if (customerAccount instanceof SavingAccount) {
            viewName += "withdrawTransactions/";
        } else {
            throw new ClassNotFoundException();
        }
        return viewName;
    }
}
