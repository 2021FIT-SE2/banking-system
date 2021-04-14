package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WithdrawTransactionController {

    private final WithdrawTransactionService withdrawTransactionService;

    @Autowired
    public WithdrawTransactionController(WithdrawTransactionService withdrawTransactionService) {
        this.withdrawTransactionService = withdrawTransactionService;
    }

    @GetMapping("/withdrawTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<WithdrawTransaction> customers = withdrawTransactionService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/withdrawTransactions/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        WithdrawTransaction customer = withdrawTransactionService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/withdrawTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/withdrawTransactions")
    public ModelAndView create(@Valid @ModelAttribute CreateWithdrawTransactionDTO createWithdrawTransactionDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        withdrawTransactionService.create(createWithdrawTransactionDTO);
        return modelAndView;
    }

    @GetMapping("/withdrawTransactions/{withdrawTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long withdrawTransactionID) {
        ModelAndView modelAndView = new ModelAndView("");

        WithdrawTransaction customer = withdrawTransactionService.getById(withdrawTransactionID);
        modelAndView.addObject(customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/withdrawTransactions/{withdrawTransactionID}/edit")
    public String update(@PathVariable Long withdrawTransactionID, @Valid @ModelAttribute UpdateWithdrawTransactionDTO updateWithdrawTransactionDTO) {
        withdrawTransactionService.updateById(withdrawTransactionID, updateWithdrawTransactionDTO);
        return "";
    }

    @PostMapping("/withdrawTransactions/{withdrawTransactionID}/delete")
    public String delete(@PathVariable Long withdrawTransactionID) {
        withdrawTransactionService.deleteById(withdrawTransactionID);
        return "";
    }
}
