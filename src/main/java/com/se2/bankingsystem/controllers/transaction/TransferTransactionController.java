package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.TransferTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class TransferTransactionController {

    private final TransferTransactionService transferTransactionService;
    private final ModelMapper modelMapper;

    @Autowired
    public TransferTransactionController(TransferTransactionService transferTransactionService, ModelMapper modelMapper) {
        this.transferTransactionService = transferTransactionService;
        this.modelMapper = modelMapper;

    }

    @GetMapping("/transferTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/transferTransaction/transferTransactionList");
        List<TransferTransaction> transferTransactions = transferTransactionService.findAll();
        modelAndView.addObject(transferTransactions);
        return modelAndView;
    }

    @GetMapping("/transferTransactions/{id}")
    public ModelAndView showTransferDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/transferTransaction/transferTransactionDetails");
        TransferTransaction transferTransaction = transferTransactionService.getById(id);
        modelAndView.addObject(transferTransaction);
        return modelAndView;
    }

    @GetMapping("/transferTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/transferTransaction/createTransferTransaction");

        CreateTransferTransactionDTO createTransferTransactionDTO = CreateTransferTransactionDTO.builder().build();
        modelAndView.addObject(createTransferTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/transferTransactions/create")
    public String create(@Valid @ModelAttribute CreateTransferTransactionDTO createTransferTransactionDTO) {
        log.info(createTransferTransactionDTO.toString());
        transferTransactionService.create(createTransferTransactionDTO);
        return "redirect:/admin/transferTransactions";
    }

    @GetMapping("/transferTransactions/{transferTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long transferTransactionID) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/transferTransaction/editTransferTransaction");

        TransferTransaction transferTransaction = transferTransactionService.getById(transferTransactionID);
        modelAndView.addObject("transferTransaction", transferTransaction);

        UpdateTransferTransactionDTO updateTransferTransactionDTO = modelMapper.map(transferTransaction, UpdateTransferTransactionDTO.class);
        modelAndView.addObject(updateTransferTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/transferTransactions/{transferTransactionID}/edit")
    public String update(@PathVariable Long transferTransactionID, @Valid @ModelAttribute UpdateTransferTransactionDTO updateTransferTransactionDTO) {
        transferTransactionService.updateById(transferTransactionID, updateTransferTransactionDTO);
        return "redirect:/admin/transferTransactions";
    }

    @PostMapping("/transferTransactions/{transferTransactionID}/delete")
    public String delete(@PathVariable Long transferTransactionID) {
        transferTransactionService.deleteById(transferTransactionID);
        return "redirect:/admin/transferTransactions";
    }
}
