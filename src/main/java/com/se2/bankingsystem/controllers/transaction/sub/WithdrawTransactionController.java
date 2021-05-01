package com.se2.bankingsystem.controllers.transaction.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.transaction.AbstractTransactionController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.WithdrawTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.CreateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.dto.UpdateWithdrawTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class WithdrawTransactionController extends AbstractTransactionController<WithdrawTransaction, CreateWithdrawTransactionDTO, UpdateWithdrawTransactionDTO> {

    public WithdrawTransactionController(WithdrawTransactionService transactionService, AuthorityService authorityService, ModelMapper modelMapper) {
        super(
            transactionService,
            authorityService,
            modelMapper,
            "withdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/withdrawTransactionList",
            "shared/transaction/sub/withdrawTransaction/createWithdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/editWithdrawTransaction",
            "shared/transaction/sub/withdrawTransaction/withdrawTransactionDetails",
            CreateWithdrawTransactionDTO.class,
            UpdateWithdrawTransactionDTO.class
            );
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
    @GetMapping({"/admin/withdrawTransactions/create", "/me/withdrawTransactions/create"})
    public ModelAndView showCreateView() {
        return super.showCreateView();
    }

    @Override
    @PostMapping("/admin/withdrawTransactions/create")
    public String createByAdmin(@Valid @ModelAttribute CreateWithdrawTransactionDTO createTransactionDTO) throws BankingSystemException {
        return super.createByAdmin(createTransactionDTO);
    }

    @Override
    @GetMapping("/admin/withdrawTransactions/{id}/edit")
    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        return super.showUpdateViewByAdmin(id);
    }

    @Override
    @PostMapping("/admin/withdrawTransactions/{id}/edit")
    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute UpdateWithdrawTransactionDTO updateTransactionDTO) {
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
