package com.se2.bankingsystem.controllers.transaction.sub;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.controllers.transaction.AbstractTransactionController;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.TransferTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
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
    public ModelAndView createByAdmin(@Valid @ModelAttribute CreateTransferTransactionDTO createTransactionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByAdmin(createTransactionDTO, bindingResult, redirectAttributes);
    }

    @Override
    @PostMapping("/me/transferTransactions/create")
    public ModelAndView createByCustomer(@Valid @ModelAttribute CreateTransferTransactionDTO createTransactionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.createByCustomer(createTransactionDTO, bindingResult, redirectAttributes);
    }

    @Override
    @GetMapping("/admin/transferTransactions/{id}/edit")
    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        return super.showUpdateViewByAdmin(id);
    }

    @Override
    @PostMapping("/admin/transferTransactions/{id}/edit")
    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute UpdateTransferTransactionDTO updateTransactionDTO, RedirectAttributes redirectAttributes) throws BankingSystemException {
        return super.updateByAdmin(id, updateTransactionDTO, redirectAttributes);
    }

    @Override
    @PostMapping("/admin/transferTransactions/{id}/delete")
    public String deleteByAdmin(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        return super.deleteByAdmin(id, redirectAttributes);
    }

    @Override
    @PostMapping("/me/transferTransactions/{id}/delete")
    public String deleteByCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        return super.deleteByCustomer(id, redirectAttributes);
    }
}
