package com.se2.bankingsystem.controllers.transaction.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.transaction.AbstractTransactionController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletService;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WithdrawTransactionController extends AbstractTransactionController<WithdrawTransaction, CreateWithdrawTransactionDTO, UpdateWithdrawTransactionDTO> {

    private final FakeEWalletService fakeEWalletService;

    public WithdrawTransactionController(WithdrawTransactionService transactionService, AuthorityService authorityService, CustomerAccountService customerAccountService, ModelMapper modelMapper, FakeEWalletService fakeEWalletService) {
        super(
            transactionService,
            authorityService,
            customerAccountService,
            modelMapper,
            "withdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/withdrawTransactionList",
            "shared/transaction/sub/withdrawTransaction/createWithdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/editWithdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/withdrawTransactionDetails",
            CreateWithdrawTransactionDTO.class,
            UpdateWithdrawTransactionDTO.class
        );
        this.fakeEWalletService = fakeEWalletService;
    }

    @Override
    @GetMapping("/admin/withdrawTransactions")
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @Override
    @GetMapping("/me/withdrawTransactions")
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @Override
    @GetMapping("/admin/withdrawTransactions/{id}")
    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        return super.showDetailsByAdmin(id);
    }

    @Override
    @GetMapping("/me/withdrawTransactions/{id}")
    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        return super.showDetailsByCustomer(id);
    }

    @Override
    @GetMapping("/admin/withdrawTransactions/create")
    public ModelAndView showCreateViewByAdmin() {
        return super.showCreateViewByAdmin();
    }

    @Override
    @GetMapping("/me/withdrawTransactions/create")
    public ModelAndView showCreateViewByCustomer() {
        ModelAndView modelAndView = super.showCreateViewByCustomer();

        List<FakeEWallet> fakeEWallets = fakeEWalletService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject("walletList", fakeEWallets);

        return modelAndView;
    }

    @PostMapping("/admin/withdrawTransactions/create")
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateWithdrawTransactionDTO createTransactionDTO, BindingResult bindingResult) throws BankingSystemException {
        return super.createByAdmin(createTransactionDTO, bindingResult);
    }

    @Override
    @PostMapping("/me/withdrawTransactions/create")
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateWithdrawTransactionDTO createTransactionDTO, BindingResult bindingResult) throws BankingSystemException {
        if (createTransactionDTO.getWalletID() == null) {
            bindingResult.addError(new FieldError("createWithdrawTransactionDTO", "walletID", "must not be null"));
        }
        return super.createByCustomer(createTransactionDTO, bindingResult);
    }

    @Override
    @GetMapping("/admin/withdrawTransactions/{id}/edit")
    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        return super.showUpdateViewByAdmin(id);
    }

    @Override
    @PostMapping("/admin/withdrawTransactions/{id}/edit")
    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute UpdateWithdrawTransactionDTO updateTransactionDTO) throws BankingSystemException {
        return super.updateByAdmin(id, updateTransactionDTO);
    }

    @Override
    @PostMapping("/admin/withdrawTransactions/{id}/delete")
    public String deleteByAdmin(@PathVariable Long id) {
        return super.deleteByAdmin(id);
    }

    @Override
    @PostMapping("/me/withdrawTransactions/{id}/delete")
    public String deleteByCustomer(@PathVariable Long id) {
        return super.deleteByCustomer(id);
    }
}
