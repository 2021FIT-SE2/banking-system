package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.SavingAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
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
public class SavingAccountController {

    private final SavingAccountService savingAccountService;
    private final ModelMapper modelMapper;

    @Autowired
    public SavingAccountController(SavingAccountService savingAccountService, ModelMapper modelMapper) {
        this.savingAccountService = savingAccountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/savingAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/savingAccount/savingAccountList");
        List<SavingAccount> savingAccounts = savingAccountService.findAll();
        modelAndView.addObject(savingAccounts);
        return modelAndView;
    }

    @GetMapping("/savingAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/savingAccount/savingAccountDetails");
        SavingAccount savingAccount = savingAccountService.getById(id);
        modelAndView.addObject(savingAccount);
        return modelAndView;
    }

    @GetMapping("/savingAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/savingAccount/createSavingAccount");

        CreateSavingAccountDTO createSavingAccountDTO = CreateSavingAccountDTO.builder().build();
        modelAndView.addObject(createSavingAccountDTO);
        return modelAndView;
    }

    @PostMapping("/savingAccounts/create")
    public String create(@Valid @ModelAttribute CreateSavingAccountDTO createsavingAccountDTO) {
        savingAccountService.create(createsavingAccountDTO);
        return "redirect:/admin/savingAccounts";
    }

    @GetMapping("/savingAccounts/{savingAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long savingAccountID) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/savingAccount/editSavingAccount");

        SavingAccount savingAccount = savingAccountService.getById(savingAccountID);
        modelAndView.addObject("savingAccount", savingAccount);

        UpdateSavingAccountDTO updateSavingAccountDTO = modelMapper.map(savingAccount, UpdateSavingAccountDTO.class);
        modelAndView.addObject(updateSavingAccountDTO);
        return modelAndView;
    }

    @PostMapping("/savingAccounts/{savingAccountID}/edit")
    public String update(@PathVariable Long savingAccountID, @Valid @ModelAttribute UpdateSavingAccountDTO updateSavingAccountDTO) {
        savingAccountService.updateById(savingAccountID, updateSavingAccountDTO);
        return "redirect:/admin/savingAccounts";
    }

    @PostMapping("/savingAccounts/{savingAccountID}/delete")
    public String delete(@PathVariable Long savingAccountID) {
        savingAccountService.deleteById(savingAccountID);
        return "redirect:/admin/savingAccounts";
    }
}
