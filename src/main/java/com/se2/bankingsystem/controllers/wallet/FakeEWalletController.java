package com.se2.bankingsystem.controllers.wallet;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletService;
import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class FakeEWalletController {

    private final FakeEWalletService walletService;

    @GetMapping("/wallets")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<FakeEWallet> customers = walletService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/wallets/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        FakeEWallet customer = walletService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/wallets/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/wallets")
    public ModelAndView create(@Valid @ModelAttribute CreateFakeEWalletDTO createFakeEWalletDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        walletService.create(createFakeEWalletDTO);
        return modelAndView;
    }

    @GetMapping("/wallets/{walletID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long walletID) {
        ModelAndView modelAndView = new ModelAndView("");

        FakeEWallet customer = walletService.getById(walletID);
        modelAndView.addObject(customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/wallets/{walletID}/edit")
    public String update(@PathVariable Long walletID, @Valid @ModelAttribute UpdateFakeEWalletDTO updateFakeEWalletDTO) {
        walletService.updateById(walletID, updateFakeEWalletDTO);
        return "";
    }

    @PostMapping("/wallets/{walletID}/delete")
    public String delete(@PathVariable Long walletID) {
        walletService.deleteById(walletID);
        return "";
    }
}
