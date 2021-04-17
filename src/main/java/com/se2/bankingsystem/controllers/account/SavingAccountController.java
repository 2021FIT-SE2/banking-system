package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.SavingAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
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
public class SavingAccountController {

    private final SavingAccountService savingAccountService;

    @Autowired
    public SavingAccountController(SavingAccountService savingAccountService) {
        this.savingAccountService = savingAccountService;
    }

    @GetMapping("/savingAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("");
        List<SavingAccount> customers = savingAccountService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/savingAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        SavingAccount customer = savingAccountService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/savingAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/savingAccounts")
    public ModelAndView create(@Valid @ModelAttribute CreateSavingAccountDTO createSavingAccountDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        savingAccountService.create(createSavingAccountDTO);
        return modelAndView;
    }

    @GetMapping("/savingAccounts/{savingAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long savingAccountID) {
        ModelAndView modelAndView = new ModelAndView("");

        SavingAccount customer = savingAccountService.getById(savingAccountID);
        modelAndView.addObject(customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/savingAccounts/{savingAccountID}/edit")
    public String update(@PathVariable Long savingAccountID, @Valid @ModelAttribute UpdateSavingAccountDTO updateSavingAccountDTO) {
        savingAccountService.updateById(savingAccountID, updateSavingAccountDTO);
        return "";
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/savingAccounts/{savingAccountID}/delete")
    public String delete(@PathVariable Long savingAccountID) {
        savingAccountService.deleteById(savingAccountID);
        return "";
    }
}
