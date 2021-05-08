package com.se2.bankingsystem.controllers.account.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.account.AbstractCustomerAccountController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.LoanAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

public class LoanAccountController extends AbstractCustomerAccountController<LoanAccount, CreateLoanAccountDTO, UpdateLoanAccountDTO> {

    public LoanAccountController(LoanAccountService customerAccountService, AuthorityService authorityService, TransactionService transactionService, ModelMapper modelMapper) {
        super(
            customerAccountService,
            authorityService,
            transactionService,
            modelMapper,
            "loanAccount",
            "shared/customerAccount/sub/loanAccount/loanAccountList",
            "shared/customerAccount/sub/loanAccount/createLoanAccount",
            "shared/customerAccount/sub/loanAccount/updateLoanAccount",
            "shared/customerAccount/sub/loanAccount/loanAccountDetails",
            CreateLoanAccountDTO.class,
            UpdateLoanAccountDTO.class
        );
    }

    @GetMapping("/admin/loanAccounts")
    @Override
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @GetMapping("/me/loanAccounts")
    @Override
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @GetMapping("/admin/loanAccounts/{id}")
    @Override
    public ModelAndView showDetailsByAdmin(@PathVariable String id) {
        return super.showDetailsByAdmin(id);
    }

    @GetMapping("/me/loanAccounts/{id}")
    @Override
    public ModelAndView showDetailsByCustomer(@PathVariable String id) {
        return super.showDetailsByCustomer(id);
    }

    @GetMapping("/admin/loanAccounts/{id}/delete")
    @Override
    public String deleteByAdmin(@PathVariable String id, RedirectAttributes redirectAttributes) {
        return super.deleteByAdmin(id, redirectAttributes);
    }

    @GetMapping("/me/loanAccounts/{id}/delete")
    @Override
    public String deleteByCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        return super.deleteByCustomer(id, redirectAttributes);
    }

    @GetMapping({ "/admin/loanAccounts/create", "/me/loanAccounts/create" })
    @Override
    public ModelAndView showCreateView() {
        return super.showCreateView();
    }

    @PostMapping("/admin/loanAccounts/create")
    @Override
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateLoanAccountDTO createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByAdmin(createCustomerAccountDTO, bindingResult, redirectAttributes);
    }

    @PostMapping("/me/loanAccounts/create")
    @Override
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateLoanAccountDTO createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByCustomer(createCustomerAccountDTO, bindingResult, redirectAttributes);
    }

    @GetMapping("/admin/loanAccounts/{id}/edit")
    @Override
    public ModelAndView showUpdateViewByAdmin(@PathVariable String id) {
        return super.showUpdateViewByAdmin(id);
    }

    @PostMapping("/admin/loanAccounts/{id}/edit")
    @Override
    public String updateByAdmin(@PathVariable String id, @Valid @ModelAttribute UpdateLoanAccountDTO updateCustomerAccountDTO, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.updateByAdmin(id, updateCustomerAccountDTO, redirectAttributes);
    }
}
