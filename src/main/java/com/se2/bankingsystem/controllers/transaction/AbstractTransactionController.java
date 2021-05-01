package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Slf4j
public abstract class AbstractTransactionController<E extends Transaction, C extends CreateTransactionDTO, U extends UpdateTransactionDTO> {

    protected final AbstractTransactionService<E, C, U> transactionService;
    protected final AuthorityService authorityService;

    protected final ModelMapper modelMapper;

    private final String entityName;

    private final String tableViewName;
    private final String createViewName;
    private final String updateViewName;
    private final String detailsViewName;

    private final Class<C> createDTOType;
    private final Class<U> updateDTOType;

    public ModelAndView showTableViewByAdmin() {
        ModelAndView modelAndView = new ModelAndView(tableViewName);
        List<E> transactions = transactionService.findAll();

        modelAndView.addObject("transactionList", transactions);
        return modelAndView;
    }

    public ModelAndView showTableViewByCustomer() {
        ModelAndView modelAndView = new ModelAndView(tableViewName);

        List<E> transactions = transactionService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject("transactionList", transactions);
        return modelAndView;
    }

    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        E transaction = transactionService.getById(id);
        modelAndView.addObject("transaction", transaction);

        return modelAndView;
    }

    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        if (!authorityService.hasTransactionOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");

        E transaction = transactionService.getById(id);
        modelAndView.addObject("transaction", transaction);

        return modelAndView;
    }

    public String deleteByAdmin(@PathVariable Long id) {
        transactionService.deleteById(id);
        return "redirect:/admin/transactions";
    }

    public String deleteByCustomer(@PathVariable Long id) {
        if (!authorityService.hasTransactionOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        transactionService.deleteById(id);
        return "redirect:/me/transactions";
    }

    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView(createViewName);

        C createTransactionDTO = modelMapper.map(C.builder().build(), createDTOType);
        modelAndView.addObject(createTransactionDTO);

        return modelAndView;
    }

    public String createByAdmin(@Valid @ModelAttribute C createTransactionDTO) throws BankingSystemException {
        transactionService.create(createTransactionDTO);
        return "redirect:/admin/" + entityName + "s";
    }

    public String createByCustomer(@Valid @ModelAttribute C createTransactionDTO) throws BankingSystemException {

        if (!authorityService.hasCustomerAccountOwnerAccess(createTransactionDTO.getCustomerAccountID()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such account");

        try {
            transactionService.create(createTransactionDTO);
        } catch (EntityNotFoundException e) {
            log.info("HELLO, ERROR");
            log.info(e.toString());
        }

        return "redirect:/me/" + entityName + "s";
    }

    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(updateViewName);

        E transaction = transactionService.getById(id);
        modelAndView.addObject(entityName, transaction);

        U updateChargeTransactionDTO = modelMapper.map(transaction, updateDTOType);
        modelAndView.addObject(updateChargeTransactionDTO);

        return modelAndView;
    }

    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute U updateTransactionDTO) {
        transactionService.updateById(id, updateTransactionDTO);
        return "redirect:/admin/" + entityName + "s";
    }
}
