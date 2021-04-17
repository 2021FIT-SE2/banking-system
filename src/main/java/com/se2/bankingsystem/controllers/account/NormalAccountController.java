package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
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
public class NormalAccountController {

    private final NormalAccountService normalAccountService;

    @Autowired
    public NormalAccountController(NormalAccountService normalAccountService) {
        this.normalAccountService = normalAccountService;
    }

    @GetMapping("/normalAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<NormalAccount> customers = normalAccountService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/normalAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        NormalAccount customer = normalAccountService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/normalAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/normalAccounts")
    public ModelAndView create(@Valid @ModelAttribute CreateNormalAccountDTO createNormalAccountDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        normalAccountService.create(createNormalAccountDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @GetMapping("/normalAccounts/{normalAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long normalAccountID) {
        ModelAndView modelAndView = new ModelAndView("");

        NormalAccount customer = normalAccountService.getById(normalAccountID);
        modelAndView.addObject(customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/normalAccounts/{normalAccountID}/edit")
    public String update(@PathVariable Long normalAccountID, @Valid @ModelAttribute UpdateNormalAccountDTO updateNormalAccountDTO) {
        normalAccountService.updateById(normalAccountID, updateNormalAccountDTO);
        return "";
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #loanAccountID)")
    @PostMapping("/normalAccounts/{normalAccountID}/delete")
    public String delete(@PathVariable Long normalAccountID) {
        normalAccountService.deleteById(normalAccountID);
        return "";
    }
}
