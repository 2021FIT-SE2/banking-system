package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.ChargeTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ChargeTransactionController {

    private final ChargeTransactionService chargeTransactionService;

    @Autowired
    public ChargeTransactionController(ChargeTransactionService chargeTransactionService) {
        this.chargeTransactionService = chargeTransactionService;
    }

    @GetMapping("/chargeTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<ChargeTransaction> customers = chargeTransactionService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/chargeTransactions/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        ChargeTransaction customer = chargeTransactionService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/chargeTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/chargeTransactions")
    public ModelAndView create(@Valid @ModelAttribute CreateChargeTransactionDTO createChargeTransactionDTO) {
        ModelAndView modelAndView = new ModelAndView("");
        chargeTransactionService.create(createChargeTransactionDTO);
        return modelAndView;
    }

    @GetMapping("/chargeTransactions/{chargeTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long chargeTransactionID) {
        ModelAndView modelAndView = new ModelAndView("");

        ChargeTransaction customer = chargeTransactionService.getById(chargeTransactionID);
        modelAndView.addObject("customer", customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/chargeTransactions/{chargeTransactionID}/edit")
    public String update(@PathVariable Long chargeTransactionID, @Valid @ModelAttribute UpdateChargeTransactionDTO updateChargeTransactionDTO) {
        chargeTransactionService.updateById(chargeTransactionID, updateChargeTransactionDTO);
        return "";
    }

    @PostMapping("/chargeTransactions/{chargeTransactionID}/delete")
    public String delete(@PathVariable Long chargeTransactionID) {
        chargeTransactionService.deleteById(chargeTransactionID);
        return "";
    }
}
