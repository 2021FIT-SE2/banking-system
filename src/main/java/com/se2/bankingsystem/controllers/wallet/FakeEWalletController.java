package com.se2.bankingsystem.controllers.wallet;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletService;
import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
@AllArgsConstructor
@RequestMapping("/me")
@Slf4j
public class FakeEWalletController {

    private final FakeEWalletService walletService;
    private final AuthorityService authorityService;
    private final WithdrawTransactionService withdrawTransactionService;

    @GetMapping("/wallets")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("customer/wallet/walletsList");
        List<FakeEWallet> customers = walletService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @PreAuthorize("@authorityServiceImpl.hasWalletOwnerAccess(#id)")
    @GetMapping("/wallets/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/wallet/walletDetails");
        FakeEWallet customer = walletService.getById(id);
        modelAndView.addObject(customer);

        List<WithdrawTransaction> withdrawTransactions = withdrawTransactionService.findAllByWalletId(id);
        modelAndView.addObject("withdrawTransactionList", withdrawTransactions);

        return modelAndView;
    }

    @GetMapping("/wallets/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("customer/wallet/createWallet");
        CreateFakeEWalletDTO createFakeEWalletDTO = CreateFakeEWalletDTO.builder().build();
        modelAndView.addObject(createFakeEWalletDTO);
        return modelAndView;
    }

    @PostMapping("/wallets/create")
    public ModelAndView create(@Valid @ModelAttribute CreateFakeEWalletDTO createFakeEWalletDTO) throws BankingSystemException {
        ModelAndView modelAndView = new ModelAndView("redirect:/me/wallets");
        walletService.create(createFakeEWalletDTO);
        return modelAndView;
    }

//    @GetMapping("/wallets/{walletID}/edit")
//    public ModelAndView showUpdateView(@PathVariable Long walletID) {
//        ModelAndView modelAndView = new ModelAndView("customer/wallet/editWallet");
//
//        FakeEWallet customer = walletService.getById(walletID);
//        modelAndView.addObject(customer);
//
//        UpdateFakeEWalletDTO updateCustomerDTO = UpdateFakeEWalletDTO.builder().build();
//        modelAndView.addObject(updateCustomerDTO);
//        return modelAndView;
//    }
//
//    @PostMapping("/wallets/{walletID}/edit")
//    public String update(@PathVariable Long walletID, @Valid @ModelAttribute UpdateFakeEWalletDTO updateFakeEWalletDTO) {
//        walletService.updateById(walletID, updateFakeEWalletDTO);
//        return "redirect:/me/wallets";
//    }

    @PostMapping("/wallets/{walletID}/delete")
    public String delete(@PathVariable Long walletID) {
        walletService.deleteById(walletID);
        return "redirect:/me/wallets";
    }
}
