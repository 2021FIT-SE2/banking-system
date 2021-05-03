package com.se2.bankingsystem.controllers.transaction.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.transaction.AbstractTransactionController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletService;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.ChargeTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class ChargeTransactionController extends AbstractTransactionController<ChargeTransaction, CreateChargeTransactionDTO, UpdateChargeTransactionDTO> {

    private final FakeEWalletService fakeEWalletService;

    public ChargeTransactionController(ChargeTransactionService transactionService, AuthorityService authorityService, CustomerAccountService customerAccountService, ModelMapper modelMapper, FakeEWalletService fakeEWalletService) {
        super(
            transactionService,
            authorityService,
            customerAccountService,
            modelMapper,
            "chargeTransaction",
            "shared/transaction/sub/chargeTransaction/chargeTransactionList",
            "shared/transaction/sub/chargeTransaction/createChargeTransaction",
            "shared/transaction/sub/chargeTransaction/editChargeTransaction",
            "shared/transaction/sub/chargeTransaction/chargeTransactionDetails",
            CreateChargeTransactionDTO.class,
            UpdateChargeTransactionDTO.class
        );
        this.fakeEWalletService = fakeEWalletService;
    }

    @Override
    @GetMapping("/admin/chargeTransactions")
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @Override
    @GetMapping("/me/chargeTransactions")
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @Override
    @GetMapping("/admin/chargeTransactions/{id}")
    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        return super.showDetailsByAdmin(id);
    }

    @Override
    @GetMapping("/me/chargeTransactions/{id}")
    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        return super.showDetailsByCustomer(id);
    }

    @Override
    @GetMapping("/admin/chargeTransactions/create")
    public ModelAndView showCreateViewByAdmin() {
        return super.showCreateViewByAdmin();
    }

    @Override
    @GetMapping("/me/chargeTransactions/create")
    public ModelAndView showCreateViewByCustomer() {
        ModelAndView modelAndView = super.showCreateViewByCustomer();

        List<FakeEWallet> fakeEWallets = fakeEWalletService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject("walletList", fakeEWallets);

        return modelAndView;
    }

    @Override
    @PostMapping("/admin/chargeTransactions/create")
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateChargeTransactionDTO createTransactionDTO, BindingResult bindingResult) throws BankingSystemException {
        return super.createByAdmin(createTransactionDTO, bindingResult);
    }

    @Override
    @PostMapping("/me/chargeTransactions/create")
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateChargeTransactionDTO createTransactionDTO, BindingResult bindingResult) throws BankingSystemException {
        return super.createByCustomer(createTransactionDTO, bindingResult);
    }

    @Override
    @GetMapping("/admin/chargeTransactions/{id}/edit")
    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        return super.showUpdateViewByAdmin(id);
    }

    @Override
    @PostMapping("/admin/chargeTransactions/{id}/edit")
    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute UpdateChargeTransactionDTO updateTransactionDTO) throws BankingSystemException {
        return super.updateByAdmin(id, updateTransactionDTO);
    }

    @Override
    @PostMapping("/admin/chargeTransactions/{id}/delete")
    public String deleteByAdmin(@PathVariable Long id) {
        return super.deleteByAdmin(id);
    }

    @Override
    @PostMapping("/me/chargeTransactions/{id}/delete")
    public String deleteByCustomer(@PathVariable Long id) {
        return super.deleteByCustomer(id);
    }
}
