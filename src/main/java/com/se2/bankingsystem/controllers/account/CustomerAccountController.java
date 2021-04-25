package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping({"/customerAccounts"})
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/customerAccountsList");
        List<CustomerAccount> customerAccounts = customerAccountService.findAll();
        modelAndView.addObject("customerAccountList", customerAccounts);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping({"/customerAccounts/{id}"})
    public ModelAndView showDetailsView(@PathVariable String id) throws ClassNotFoundException {
        CustomerAccount customerAccount = customerAccountService.getById(id);

        String viewName = getRedirectViewName(customerAccount);
        viewName += id;

        return new ModelAndView(viewName);
    }

    @GetMapping({"/customerAccounts/{id}/edit"})
    public ModelAndView showEditView(@PathVariable String id) throws ClassNotFoundException {
        CustomerAccount customerAccount = customerAccountService.getById(id);

        String viewName = getRedirectViewName(customerAccount);
        viewName += id + "/edit";

        return new ModelAndView(viewName);
    }

    private String getRedirectViewName(CustomerAccount customerAccount) throws ClassNotFoundException {

        String viewName = "redirect:/admin/";

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

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #customerAccountID)")
    @PostMapping("/customerAccounts/{customerAccountID}/delete")
    public String delete(@PathVariable String customerAccountID) {
        customerAccountService.deleteById(customerAccountID);
        return "shared/customerAccount/customerAccountsList";
    }
}
