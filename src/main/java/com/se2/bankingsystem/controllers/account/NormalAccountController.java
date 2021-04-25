package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
@AllArgsConstructor
public class NormalAccountController {

    private final NormalAccountService normalAccountService;
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

    @GetMapping("/normalAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/normalAccountList");
        List<NormalAccount> normalAccounts = normalAccountService.findAll();
        modelAndView.addObject(normalAccounts);
        return modelAndView;
    }

    @GetMapping("/normalAccounts/{id}")
    public ModelAndView showProfile(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/normalAccountDetails");
        NormalAccount normalAccount = normalAccountService.getById(id);
        modelAndView.addObject(normalAccount);

        List<Transaction> transactions = transactionService.findAllByCustomerAccountId(id);
        modelAndView.addObject("transactionList", transactions);
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
    public ModelAndView showUpdateView(@PathVariable String normalAccountID) {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/sub/normalAccount/editNormalAccount");

        NormalAccount normalAccount = normalAccountService.getById(normalAccountID);
        modelAndView.addObject("normalAccount", normalAccount);

        UpdateNormalAccountDTO updatenormalAccountDTO = modelMapper.map(normalAccount, UpdateNormalAccountDTO.class);
        modelAndView.addObject(updatenormalAccountDTO);
        return modelAndView;
    }

    @PostMapping("/normalAccounts/{normalAccountID}/edit")
    public String update(@PathVariable String normalAccountID, @Valid @ModelAttribute UpdateNormalAccountDTO updateNormalAccountDTO) {
        normalAccountService.updateById(normalAccountID, updateNormalAccountDTO);
        return "redirect:/admin/normalAccounts";
    }

    @GetMapping("/normalAccounts/{normalAccountID}/delete")
    public String delete(@PathVariable String normalAccountID) {
        normalAccountService.deleteById(normalAccountID);
        return "redirect:/admin/normalAccounts";
    }
}
