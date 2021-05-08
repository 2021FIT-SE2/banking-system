package com.se2.bankingsystem.controllers.account.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.account.AbstractCustomerAccountController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.SavingAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

public class SavingAccountController extends AbstractCustomerAccountController<SavingAccount, CreateSavingAccountDTO, UpdateSavingAccountDTO> {

    public SavingAccountController(SavingAccountService customerAccountService, AuthorityService authorityService, TransactionService transactionService, ModelMapper modelMapper) {
        super(
            customerAccountService,
            authorityService,
            transactionService,
            modelMapper,
            "savingAccount",
            "shared/customerAccount/sub/savingAccount/savingAccountList",
            "shared/customerAccount/sub/savingAccount/createSavingAccount",
            "shared/customerAccount/sub/savingAccount/updateSavingAccount",
            "shared/customerAccount/sub/savingAccount/savingAccountDetails",
            CreateSavingAccountDTO.class,
            UpdateSavingAccountDTO.class
        );
    }

    @GetMapping("/admin/savingAccounts")
    @Override
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @GetMapping("/me/savingAccounts")
    @Override
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @GetMapping("/admin/savingAccounts/{id}")
    @Override
    public ModelAndView showDetailsByAdmin(@PathVariable String id) {
        return super.showDetailsByAdmin(id);
    }

    @GetMapping("/me/savingAccounts/{id}")
    @Override
    public ModelAndView showDetailsByCustomer(@PathVariable String id) {
        return super.showDetailsByCustomer(id);
    }

    @GetMapping("/admin/savingAccounts/{id}/delete")
    @Override
    public String deleteByAdmin(@PathVariable String id) {
        return super.deleteByAdmin(id);
    }

    @GetMapping("/me/savingAccounts/{id}/delete")
    @Override
    public String deleteByCustomer(@PathVariable String id) {
        return super.deleteByCustomer(id);
    }

    @GetMapping({ "/admin/savingAccounts/create", "/me/savingAccounts/create" })
    @Override
    public ModelAndView showCreateView() {
        return super.showCreateView();
    }

    @PostMapping("/admin/savingAccounts/create")
    @Override
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateSavingAccountDTO createCustomerAccountDTO, BindingResult bindingResult) throws BankingSystemException {
        return super.createByAdmin(createCustomerAccountDTO, bindingResult);
    }

    @PostMapping("/me/savingAccounts/create")
    @Override
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateSavingAccountDTO createCustomerAccountDTO, BindingResult bindingResult) throws BankingSystemException {
        return super.createByCustomer(createCustomerAccountDTO, bindingResult);
    }

    @GetMapping("/admin/savingAccounts/{id}/edit")
    @Override
    public ModelAndView showUpdateViewByAdmin(@PathVariable String id) {
        return super.showUpdateViewByAdmin(id);
    }

    @PostMapping("/admin/savingAccounts/{id}/edit")
    @Override
    public String updateByAdmin(@PathVariable String id, UpdateSavingAccountDTO updateCustomerAccountDTO) throws BankingSystemException {
        return super.updateByAdmin(id, updateCustomerAccountDTO);
    }
}
