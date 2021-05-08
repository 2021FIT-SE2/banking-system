package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

import static com.se2.bankingsystem.utils.StringUtils.lowerFirstLetter;

@AllArgsConstructor

public abstract class AbstractTransactionController<E extends Transaction, C extends CreateTransactionDTO, U extends UpdateTransactionDTO> {

    protected final AbstractTransactionService<E, C, U> transactionService;
    protected final AuthorityService authorityService;
    protected final CustomerAccountService customerAccountService;

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

        modelAndView.addObject(entityName + "List", transactions);
        return modelAndView;
    }

    public ModelAndView showTableViewByCustomer() {
        ModelAndView modelAndView = new ModelAndView(tableViewName);

        List<E> transactions = transactionService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject(entityName + "List", transactions);
        return modelAndView;
    }

    public ModelAndView showDetailsByAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        E transaction = transactionService.getById(id);
        modelAndView.addObject(entityName, transaction);

        return modelAndView;
    }

    public ModelAndView showDetailsByCustomer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(detailsViewName);

        if (!authorityService.hasTransactionOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");

        E transaction = transactionService.getById(id);
        modelAndView.addObject(entityName, transaction);

        return modelAndView;
    }

    public String deleteByAdmin(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        transactionService.deleteById(id);
        redirectAttributes.addFlashAttribute("dialogMessage", "Transaction with ID " + id + " was deleted successfully!");
        return getRedirectTableViewName();
    }

    public String deleteByCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (!authorityService.hasTransactionOwnerAccess(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        transactionService.deleteById(id);

        redirectAttributes.addFlashAttribute("dialogMessage", "Transaction with ID " + id + " was deleted successfully!");
        return getRedirectTableViewName();
    }

    public ModelAndView showCreateViewByAdmin() {
        ModelAndView modelAndView = new ModelAndView(createViewName);

        C createTransactionDTO = modelMapper.map(C.builder().build(), createDTOType);
        modelAndView.addObject(createTransactionDTO);

        return modelAndView;
    }

    public ModelAndView showCreateViewByCustomer() {
        ModelAndView modelAndView = showCreateViewByAdmin();

        List<CustomerAccount> customerAccounts = customerAccountService.findAllByCustomerId(authorityService.getPrincipal().getId());
        modelAndView.addObject("customerAccountList", customerAccounts);

        return modelAndView;
    }

    public ModelAndView createByAdmin(@Valid @ModelAttribute C createTransactionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        ModelAndView modelAndView = new ModelAndView();

        createIfNoErrorsOrElseRedirectToForm(createTransactionDTO, bindingResult, modelAndView, redirectAttributes);

        return modelAndView;
    }

    public ModelAndView createByCustomer(@Valid @ModelAttribute C createTransactionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BankingSystemException {
        ModelAndView modelAndView = new ModelAndView();

        String customerAccountID = createTransactionDTO.getCustomerAccountID();

        checkCustomerAccountOwnershipOrElseAddError(customerAccountID, bindingResult);

        createIfNoErrorsOrElseRedirectToForm(createTransactionDTO, bindingResult, modelAndView, redirectAttributes);

        return modelAndView;
    }

    private void createIfNoErrorsOrElseRedirectToForm(C createTransactionDTO, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) throws BankingSystemException {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(createViewName);
        } else {
            E transaction = transactionService.create(createTransactionDTO);
            redirectAttributes.addFlashAttribute("dialogMessage", "Transaction with ID " + transaction.getId() + " was created successfully!");
            modelAndView.setViewName(getRedirectTableViewName());
        }
    }

    public ModelAndView showUpdateViewByAdmin(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView(updateViewName);

        E transaction = transactionService.getById(id);
        modelAndView.addObject(entityName, transaction);

        U updateChargeTransactionDTO = modelMapper.map(transaction, updateDTOType);
        modelAndView.addObject(updateChargeTransactionDTO);

        return modelAndView;
    }

    public String updateByAdmin(@PathVariable Long id, @Valid @ModelAttribute U updateTransactionDTO, RedirectAttributes redirectAttributes) throws BankingSystemException {
        transactionService.updateById(id, updateTransactionDTO);
        redirectAttributes.addFlashAttribute("dialogMessage", "Transaction with ID " + id + " was updated successfully!");
        return getRedirectTableViewName();
    }

    protected void checkCustomerAccountOwnershipOrElseAddError(String customerAccountID, BindingResult bindingResult) {

        boolean currentUserIsOwnerOfAccount = authorityService.hasCustomerAccountOwnerAccess(customerAccountID);

        String objectName = lowerFirstLetter(createDTOType.getSimpleName());

        if (!currentUserIsOwnerOfAccount)
            bindingResult.addError(new FieldError(objectName, "customerAccountID", "Customer Account ID Not Found"));
    }

    private String getRedirectTableViewName() {
        String currentAuthorityName = authorityService.getCurrentAuthority();
        return "redirect:/" + currentAuthorityName.toLowerCase(Locale.ROOT) + "/" + entityName + "s";
    }
}
