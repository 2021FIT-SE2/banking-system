package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.TransferTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
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
public class TransferTransactionController {

    private final TransferTransactionService transferTransactionService;

    @Autowired
    public TransferTransactionController(TransferTransactionService transferTransactionService) {
        this.transferTransactionService = transferTransactionService;
    }

    @GetMapping("/transferTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<TransferTransaction> customers = transferTransactionService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/transferTransactions/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        TransferTransaction customer = transferTransactionService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/transferTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/transferTransactions")
    public ModelAndView create(@Valid @ModelAttribute CreateTransferTransactionDTO createTransferTransactionDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        transferTransactionService.create(createTransferTransactionDTO);
        return modelAndView;
    }

    @GetMapping("/transferTransactions/{transferTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long transferTransactionID) {
        ModelAndView modelAndView = new ModelAndView("");

        TransferTransaction customer = transferTransactionService.getById(transferTransactionID);
        modelAndView.addObject(customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/transferTransactions/{transferTransactionID}/edit")
    public String update(@PathVariable Long transferTransactionID, @Valid @ModelAttribute UpdateTransferTransactionDTO updateTransferTransactionDTO) {
        transferTransactionService.updateById(transferTransactionID, updateTransferTransactionDTO);
        return "";
    }

    @PostMapping("/transferTransactions/{transferTransactionID}/delete")
    public String delete(@PathVariable Long transferTransactionID) {
        transferTransactionService.deleteById(transferTransactionID);
        return "";
    }
}
