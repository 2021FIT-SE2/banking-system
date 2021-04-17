package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.LoanAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
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
public class LoanAccountController {

    private final LoanAccountService loanAccountService;
    private final ModelMapper modelMapper;

    @Autowired
    public LoanAccountController(LoanAccountService loanAccountService, ModelMapper modelMapper) {
        this.loanAccountService = loanAccountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/loanAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/loanAccount/loanAccountList");
        List<LoanAccount> loanAccounts = loanAccountService.findAll();
        modelAndView.addObject(loanAccounts);
        return modelAndView;
    }

    @GetMapping("/loanAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/loanAccount/loanAccountDetails");
        LoanAccount loanAccount = loanAccountService.getById(id);
        modelAndView.addObject(loanAccount);
        return modelAndView;
    }

    @GetMapping("/loanAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/loanAccount/createLoanAccount");

        CreateLoanAccountDTO createLoanAccountDTO = CreateLoanAccountDTO.builder().build();
        modelAndView.addObject(createLoanAccountDTO);
        return modelAndView;
    }

    @PostMapping("/loanAccounts/create")
    public String create(@Valid @ModelAttribute CreateLoanAccountDTO createLoanAccountDTO) {
        loanAccountService.create(createLoanAccountDTO);
        return "redirect:/admin/loanAccounts";
    }

    @GetMapping("/loanAccounts/{loanAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long loanAccountID) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/loanAccount/editLoanAccount");

        LoanAccount loanAccount = loanAccountService.getById(loanAccountID);
        modelAndView.addObject("loanAccount", loanAccount);

        UpdateLoanAccountDTO updateLoanAccountDTO = modelMapper.map(loanAccount, UpdateLoanAccountDTO.class);
        modelAndView.addObject(updateLoanAccountDTO);
        return modelAndView;
    }

    @PostMapping("/loanAccounts/{loanAccountID}/edit")
    public String update(@PathVariable Long loanAccountID, @Valid @ModelAttribute UpdateLoanAccountDTO updateLoanAccountDTO) {
        loanAccountService.updateById(loanAccountID, updateLoanAccountDTO);
        return "redirect:/admin/loanAccounts";
    }

    @PostMapping("/loanAccounts/{loanAccountID}/delete")
    public String delete(@PathVariable Long loanAccountID) {
        loanAccountService.deleteById(loanAccountID);
        return "redirect:/admin/loanAccounts";
    }
}
