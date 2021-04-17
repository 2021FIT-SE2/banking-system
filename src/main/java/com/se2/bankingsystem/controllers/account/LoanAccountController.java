package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.LoanAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.CreateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto.UpdateLoanAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoanAccountController {

    private final LoanAccountService loanAccountService;

    @Autowired
    public LoanAccountController(LoanAccountService loanAccountService) {
        this.loanAccountService = loanAccountService;
    }

    @GetMapping("/loanAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<LoanAccount> customers = loanAccountService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #customerAccountID)")
    @GetMapping("/loanAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        LoanAccount customer = loanAccountService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/loanAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @PostMapping("/loanAccounts")
    public ModelAndView create(@Valid @ModelAttribute CreateLoanAccountDTO createLoanAccountDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        loanAccountService.create(createLoanAccountDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/loanAccounts/{loanAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long loanAccountID) {
        ModelAndView modelAndView = new ModelAndView("");

        LoanAccount customer = loanAccountService.getById(loanAccountID);
        modelAndView.addObject("customer", customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/loanAccounts/{loanAccountID}/edit")
    public String update(@PathVariable Long loanAccountID, @Valid @ModelAttribute UpdateLoanAccountDTO updateLoanAccountDTO) {
        loanAccountService.updateById(loanAccountID, updateLoanAccountDTO);
        return "";
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/loanAccounts/{loanAccountID}/delete")
    public String delete(@PathVariable Long loanAccountID) {
        loanAccountService.deleteById(loanAccountID);
        return "";
    }
}
