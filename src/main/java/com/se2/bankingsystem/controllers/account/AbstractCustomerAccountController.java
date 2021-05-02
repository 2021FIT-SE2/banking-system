package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import lombok.AllArgsConstructor;
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
public abstract class AbstractCustomerAccountController<E extends CustomerAccount, C extends CreateCustomerAccountDTO, U extends UpdateCustomerAccountDTO> {

    protected final AbstractCustomerAccountService<E, C, U> customerAccountService;
    protected final AuthorityService authorityService;
    protected final TransactionService transactionService;

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
        List<E> customerAccounts = customerAccountService.findAll();

        modelAndView.addObject(entityName + "List", customerAccounts);
        return modelAndView;
    }

    public ModelAndView showTableViewByCustomer() {
        ModelAndView modelAndView = new ModelAndView(tableViewName);

        List<E> customerAccounts = customerAccountService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject(entityName + "List", customerAccounts);
        return modelAndView;
    }

    public ModelAndView showDetailsByAdmin(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        E customerAccount = customerAccountService.getById(id);
        modelAndView.addObject(entityName, customerAccount);

        return modelAndView;
    }

    public ModelAndView showDetailsByCustomer(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        if (!authorityService.hasCustomerAccountOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CustomerAccount not found");

        E customerAccount = customerAccountService.getById(id);
        modelAndView.addObject(entityName, customerAccount);

        return modelAndView;
    }

    public String deleteByAdmin(@PathVariable String id) {
        customerAccountService.deleteById(id);
        return "redirect:/admin/customerAccounts";
    }

    public String deleteByCustomer(@PathVariable String id) {
        if (!authorityService.hasCustomerAccountOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Account not found");
        customerAccountService.deleteById(id);
        return "redirect:/me/" + entityName + "s";
    }

    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView(createViewName);

        C createCustomerAccountDTO = modelMapper.map(C.builder().build(), createDTOType);
        modelAndView.addObject(createCustomerAccountDTO);

        return modelAndView;
    }

    public String createByAdmin(@Valid @ModelAttribute C createCustomerAccountDTO) throws BankingSystemException {
        customerAccountService.create(createCustomerAccountDTO);
        return "redirect:/admin/" + entityName + "s";
    }

    public String createByCustomer(@Valid @ModelAttribute C createCustomerAccountDTO) throws BankingSystemException {

//        if (!authorityService.hasCustomerAccountOwnerAccess(createCustomerAccountDTO.getCustomerAccountID()))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such account");

        try {
            customerAccountService.create(createCustomerAccountDTO);
        } catch (EntityNotFoundException e) {

        }

        return "redirect:/me/" + entityName + "s";
    }

    public ModelAndView showUpdateViewByAdmin(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView(updateViewName);

        E customerAccount = customerAccountService.getById(id);
        modelAndView.addObject(entityName, customerAccount);

        U updateChargeCustomerAccountDTO = modelMapper.map(customerAccount, updateDTOType);
        modelAndView.addObject(updateChargeCustomerAccountDTO);

        return modelAndView;
    }

    public String updateByAdmin(@PathVariable String id, @Valid @ModelAttribute U updateCustomerAccountDTO) {
        customerAccountService.updateById(id, updateCustomerAccountDTO);
        return "redirect:/admin/" + entityName + "s";
    }
}
