package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CustomerAccountController extends AbstractCustomerAccountController<CustomerAccount, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> {

    public CustomerAccountController(AbstractCustomerAccountService<CustomerAccount, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> customerAccountService, AuthorityService authorityService, TransactionService transactionService, ModelMapper modelMapper) {
        super(
            customerAccountService,
            authorityService,
            transactionService,
            modelMapper,
            "customerAccount",
            "shared/customerAccount/customerAccountsList",
            null,
            null,
            null,
            CreateCustomerAccountDTO.class,
            UpdateCustomerAccountDTO.class
        );
    }

    @GetMapping({ "/admin/customerAccounts" })
    @Override
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @GetMapping({ "/me/accounts" })
    @Override
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @PostMapping("/admin/customerAccounts/{id}/delete")
    @Override
    public String deleteByAdmin(@PathVariable String id) {
        return super.deleteByAdmin(id);
    }

    @PostMapping("/me/accounts/{id}/delete")
    @PreAuthorize("authorityServiceImpl.hasCustomerAccountOwnerAccess(#id)")
    @Override
    public String deleteByCustomer(@PathVariable String id) {
        return super.deleteByCustomer(id);
    }

    @GetMapping({ "/admin/customerAccounts/{id}", "/me/accounts/{id}" })
    public ModelAndView showDetailsView(@PathVariable String id) throws ClassNotFoundException {
        CustomerAccount customerAccount = customerAccountService.getById(id);

        String viewName = getRedirectViewName(customerAccount);
        viewName += id;

        return new ModelAndView(viewName);
    }

    @GetMapping({ "/admin/customerAccounts/{id}/edit", "/me/accounts/{id}/edit" })
    public ModelAndView showEditView(@PathVariable String id) throws ClassNotFoundException {
        CustomerAccount customerAccount = customerAccountService.getById(id);

        String viewName = getRedirectViewName(customerAccount);
        viewName += id + "/edit";

        return new ModelAndView(viewName);
    }

    private String getRedirectViewName(CustomerAccount customerAccount) throws ClassNotFoundException {

        String viewName;
        if (authorityService.getCurrentAuthority().equals(AuthorityName.ADMIN.name()))
            viewName = "redirect:/admin/";
        else
            viewName = "redirect:/me/";

        if (customerAccount instanceof LoanAccount) {
            viewName += "loanAccounts/";
        } else if (customerAccount instanceof NormalAccount) {
            viewName += "normalAccounts/";
        } else if (customerAccount instanceof SavingAccount) {
            viewName += "savingAccounts/";
        } else {
            throw new ClassNotFoundException();
        }
        return viewName;
    }
}
