package com.se2.bankingsystem.controllers.transaction.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.transaction.AbstractTransactionController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.TransferTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
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
public class TransferTransactionController extends AbstractTransactionController<TransferTransaction, CreateTransferTransactionDTO, UpdateTransferTransactionDTO> {

    public TransferTransactionController(TransferTransactionService transactionService, AuthorityService authorityService, CustomerAccountService customerAccountService, ModelMapper modelMapper) {
        super(
            transactionService,
            authorityService,
            customerAccountService,
            modelMapper,
            "transferTransaction",
            "shared/transaction/sub/transferTransaction/transferTransactionList",
            "shared/transaction/sub/transferTransaction/createTransferTransaction",
            "shared/transaction/sub/transferTransaction/editTransferTransaction",
            "shared/transaction/sub/transferTransaction/transferTransactionDetails",
            CreateTransferTransactionDTO.class,
            UpdateTransferTransactionDTO.class
        );
    }

    @Override
    @GetMapping("/admin/transferTransactions")
    public ModelAndView showTableViewByAdmin() {
        return super.showTableViewByAdmin();
    }

    @Override
    @GetMapping("/me/transferTransactions")
    public ModelAndView showTableViewByCustomer() {
        return super.showTableViewByCustomer();
    }

    @Override
    @GetMapping("/admin/transferTransactions/{id}")
    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        return super.showDetailsByAdmin(id);
    }

    @Override
    @GetMapping("/me/transferTransactions/{id}")
    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        return super.showDetailsByCustomer(id);
    }

    @Override
    @GetMapping("/admin/transferTransactions/create")
    public ModelAndView showCreateViewByAdmin() {
        return super.showCreateViewByAdmin();
    }

    @Override
    @GetMapping("/me/transferTransactions/create")
    public ModelAndView showCreateViewByCustomer() {
        return super.showCreateViewByCustomer();
    }

    @Override
    @PostMapping("/admin/transferTransactions/create")
    public String createByAdmin(@Valid @ModelAttribute CreateTransferTransactionDTO createTransactionDTO) throws BankingSystemException {
        return super.createByAdmin(createTransactionDTO);
    }

    @Override
    @PostMapping("/me/transferTransactions/create")
    public String createByCustomer(CreateTransferTransactionDTO createTransactionDTO) throws BankingSystemException {
        return super.createByCustomer(createTransactionDTO);
    }

    @Override
    @GetMapping("/admin/transferTransactions/{id}/edit")
    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        return super.showUpdateViewByAdmin(id);
    }

    @Override
    @PostMapping("/admin/transferTransactions/{id}/edit")
    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute UpdateTransferTransactionDTO updateTransactionDTO) {
        return super.updateByAdmin(id, updateTransactionDTO);
    }

    @Override
    @PostMapping("/admin/transferTransactions/{id}/delete")
    public String deleteByAdmin(@PathVariable Long id) {
        return super.deleteByAdmin(id);
    }

    @Override
    @PostMapping("/me/transferTransactions/{id}/delete")
    public String deleteByCustomer(@PathVariable Long id) {
        return super.deleteByCustomer(id);
    }
}
