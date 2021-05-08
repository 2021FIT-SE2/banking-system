package com.se2.bankingsystem.controllers.account.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.account.AbstractCustomerAccountController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
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

public class NormalAccountController extends AbstractCustomerAccountController<NormalAccount, CreateNormalAccountDTO, UpdateNormalAccountDTO> {

    public NormalAccountController(NormalAccountService customerAccountService, AuthorityService authorityService, TransactionService transactionService, ModelMapper modelMapper) {
        super(
            customerAccountService,
            authorityService,
            transactionService,
            modelMapper,
            "normalAccount",
            "shared/customerAccount/sub/normalAccount/normalAccountList",
            "shared/customerAccount/sub/normalAccount/createNormalAccount",
            "shared/customerAccount/sub/normalAccount/updateNormalAccount",
            "shared/customerAccount/sub/normalAccount/normalAccountDetails",
            CreateNormalAccountDTO.class,
            UpdateNormalAccountDTO.class
        );
    }

    @GetMapping("/admin/normalAccounts")
    @Override
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @GetMapping("/me/normalAccounts")
    @Override
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @GetMapping("/admin/normalAccounts/{id}")
    @Override
    public ModelAndView showDetailsByAdmin(@PathVariable String id) {
        return super.showDetailsByAdmin(id);
    }

    @GetMapping("/me/normalAccounts/{id}")
    @Override
    public ModelAndView showDetailsByCustomer(@PathVariable String id) {
        return super.showDetailsByCustomer(id);
    }

    @GetMapping("/admin/normalAccounts/{id}/delete")
    @Override
    public String deleteByAdmin(@PathVariable String id, RedirectAttributes redirectAttributes) {
        return super.deleteByAdmin(id, redirectAttributes);
    }

    @GetMapping("/me/normalAccounts/{id}/delete")
    @Override
    public String deleteByCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        return super.deleteByCustomer(id, redirectAttributes);
    }

    @GetMapping({ "/admin/normalAccounts/create", "/me/normalAccounts/create" })
    @Override
    public ModelAndView showCreateView() {
        return super.showCreateView();
    }

    @PostMapping("/admin/normalAccounts/create")
    @Override
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateNormalAccountDTO createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByAdmin(createCustomerAccountDTO, bindingResult, redirectAttributes);
    }

    @PostMapping("/me/normalAccounts/create")
    @Override
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateNormalAccountDTO createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByCustomer(createCustomerAccountDTO, bindingResult, redirectAttributes);
    }

    @GetMapping("/admin/normalAccounts/{id}/edit")
    @Override
    public ModelAndView showUpdateViewByAdmin(@PathVariable String id) {
        return super.showUpdateViewByAdmin(id);
    }

    @PostMapping("/admin/normalAccounts/{id}/edit")
    @Override
    public String updateByAdmin(@PathVariable String id, @Valid @ModelAttribute UpdateNormalAccountDTO updateCustomerAccountDTO, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.updateByAdmin(id, updateCustomerAccountDTO, redirectAttributes);
    }
}
