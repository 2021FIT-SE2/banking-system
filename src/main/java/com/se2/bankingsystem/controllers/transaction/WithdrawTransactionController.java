package com.se2.bankingsystem.controllers.transaction;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
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
public class WithdrawTransactionController {

    private final WithdrawTransactionService withdrawTransactionService;
    private final ModelMapper modelMapper;

    @Autowired
    public WithdrawTransactionController(WithdrawTransactionService withdrawTransactionService, ModelMapper modelMapper) {
        this.withdrawTransactionService = withdrawTransactionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/withdrawTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/withdrawTransaction/withdrawTransactionList");
        List<WithdrawTransaction> withdrawTransactions = withdrawTransactionService.findAll();
        modelAndView.addObject(withdrawTransactions);
        return modelAndView;
    }

    @GetMapping("/withdrawTransactions/{id}")
    public ModelAndView showWithdrawDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/withdrawTransaction/withdrawTransactionDetails");
        WithdrawTransaction withdrawTransaction = withdrawTransactionService.getById(id);
        modelAndView.addObject(withdrawTransaction);
        return modelAndView;
    }

    @GetMapping("/withdrawTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/withdrawTransaction/createWithdrawTransaction");

        CreateWithdrawTransactionDTO createWithdrawTransactionDTO = CreateWithdrawTransactionDTO.builder().build();
        modelAndView.addObject(createWithdrawTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/withdrawTransactions/create")
    public String create(@Valid @ModelAttribute CreateWithdrawTransactionDTO createWithdrawTransactionDTO) {
        log.info(createWithdrawTransactionDTO.toString());
        withdrawTransactionService.create(createWithdrawTransactionDTO);
        return "redirect:/admin/withdrawTransactions";
    }

    @GetMapping("/withdrawTransactions/{withdrawTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long withdrawTransactionID) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/withdrawTransaction/editWithdrawTransaction");

        WithdrawTransaction withdrawTransaction = withdrawTransactionService.getById(withdrawTransactionID);
        modelAndView.addObject("withdrawTransaction", withdrawTransaction);

        UpdateWithdrawTransactionDTO updateWithdrawTransactionDTO = modelMapper.map(withdrawTransaction, UpdateWithdrawTransactionDTO.class);
        modelAndView.addObject(updateWithdrawTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/withdrawTransactions/{withdrawTransactionID}/edit")
    public String update(@PathVariable Long withdrawTransactionID, @Valid @ModelAttribute UpdateWithdrawTransactionDTO updateWithdrawTransactionDTO) {
        withdrawTransactionService.updateById(withdrawTransactionID, updateWithdrawTransactionDTO);
        return "redirect:/admin/withdrawTransactions";
    }

    @PostMapping("/withdrawTransactions/{withdrawTransactionID}/delete")
    public String delete(@PathVariable Long withdrawTransactionID) {
        withdrawTransactionService.deleteById(withdrawTransactionID);
        return "redirect:/admin/withdrawTransactions";
    }
}
