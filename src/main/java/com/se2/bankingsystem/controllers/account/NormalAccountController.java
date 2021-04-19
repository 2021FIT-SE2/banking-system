package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
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
public class NormalAccountController {

    private final NormalAccountService normalAccountService;
    private final ModelMapper modelMapper;

    @Autowired
    public NormalAccountController(NormalAccountService normalAccountService, ModelMapper modelMapper) {
        this.normalAccountService = normalAccountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/normalAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/normalAccountList");
        List<NormalAccount> normalAccounts = normalAccountService.findAll();
        modelAndView.addObject(normalAccounts);
        return modelAndView;
    }

    @GetMapping("/normalAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/normalAccountDetails");
        NormalAccount normalAccount = normalAccountService.getById(id);
        modelAndView.addObject(normalAccount);
        return modelAndView;
    }

    @GetMapping("/normalAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/createNormalAccount");

        CreateNormalAccountDTO createNormalAccountDTO = CreateNormalAccountDTO.builder().build();
        modelAndView.addObject(createNormalAccountDTO);
        return modelAndView;
    }

    @PostMapping("/normalAccounts/create")
    public String create(@Valid @ModelAttribute CreateNormalAccountDTO createNormalAccountDTO) {
        normalAccountService.create(createNormalAccountDTO);
        return "redirect:/admin/normalAccounts";
    }

    @GetMapping("/normalAccounts/{normalAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long normalAccountID) {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/editNormalAccount");

        NormalAccount normalAccount = normalAccountService.getById(normalAccountID);
        modelAndView.addObject("normalAccount", normalAccount);

        UpdateNormalAccountDTO updatenormalAccountDTO = modelMapper.map(normalAccount, UpdateNormalAccountDTO.class);
        modelAndView.addObject(updatenormalAccountDTO);
        return modelAndView;
    }

    @PostMapping("/normalAccounts/{normalAccountID}/edit")
    public String update(@PathVariable Long normalAccountID, @Valid @ModelAttribute UpdateNormalAccountDTO updateNormalAccountDTO) {
        normalAccountService.updateById(normalAccountID, updateNormalAccountDTO);
        return "redirect:/admin/normalAccounts";
    }

    @PostMapping("/normalAccounts/{normalAccountID}/delete")
    public String delete(@PathVariable Long normalAccountID) {
        normalAccountService.deleteById(normalAccountID);
        return "redirect:/admin/normalAccounts";
    }
}
