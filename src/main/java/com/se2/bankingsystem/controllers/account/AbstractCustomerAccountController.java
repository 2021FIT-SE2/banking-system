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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

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

    public String deleteByAdmin(@PathVariable String id, RedirectAttributes redirectAttributes) {
        customerAccountService.deleteById(id);
        redirectAttributes.addFlashAttribute("dialogMessage", "Customer Account with ID " + id + " was deleted successfully!");
        return getRedirectTableViewName();
    }

    public String deleteByCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        if (!authorityService.hasCustomerAccountOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Account not found");
        customerAccountService.deleteById(id);
        redirectAttributes.addFlashAttribute("dialogMessage", "Customer Account with ID " + id + " was deleted successfully!");
        return getRedirectTableViewName();
    }

    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView(createViewName);

        C createCustomerAccountDTO = modelMapper.map(C.builder().build(), createDTOType);
        modelAndView.addObject(createCustomerAccountDTO);

        return modelAndView;
    }

    public ModelAndView createByAdmin(@Valid @ModelAttribute C createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {

        ModelAndView modelAndView = new ModelAndView();

        createIfNoErrorsOrElseRedirectToForm(createCustomerAccountDTO, bindingResult, modelAndView, redirectAttributes);

        return modelAndView;
    }

    public ModelAndView createByCustomer(@Valid @ModelAttribute C createCustomerAccountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {

        ModelAndView modelAndView = new ModelAndView();

        createCustomerAccountDTO.setCustomerID(authorityService.getPrincipal().getId());

        createIfNoErrorsOrElseRedirectToForm(createCustomerAccountDTO, bindingResult, modelAndView, redirectAttributes);

        return modelAndView;
    }

    public ModelAndView showUpdateViewByAdmin(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView(updateViewName);

        E customerAccount = customerAccountService.getById(id);
        modelAndView.addObject(entityName, customerAccount);

        U updateChargeCustomerAccountDTO = modelMapper.map(customerAccount, updateDTOType);
        modelAndView.addObject(updateChargeCustomerAccountDTO);

        return modelAndView;
    }

    public String updateByAdmin(@PathVariable String id, @Valid @ModelAttribute U updateCustomerAccountDTO, RedirectAttributes redirectAttributes) throws BankingSystemException {
        E customerAccount = customerAccountService.updateById(id, updateCustomerAccountDTO);
        redirectAttributes.addFlashAttribute("dialogMessage", "Customer Account with ID " + customerAccount.getId() + " was updated successfully!");
        return "redirect:/admin/" + entityName + "s";
    }

    private String getRedirectTableViewName() {
        String currentAuthorityName = authorityService.getCurrentAuthority();
        return "redirect:/" + currentAuthorityName.toLowerCase(Locale.ROOT) + "/" + entityName + "s";
    }

    private void createIfNoErrorsOrElseRedirectToForm(C createCustomerAccountDTO, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws BankingSystemException {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(createViewName);
        } else {
            E customerAccount = customerAccountService.create(createCustomerAccountDTO);
            redirectAttributes.addFlashAttribute("dialogMessage", "Customer Account with ID " + customerAccount.getId() + " was added successfully!");
            modelAndView.setViewName(getRedirectTableViewName());
        }
    }
}
