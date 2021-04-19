package com.se2.bankingsystem.controllers.transaction;

import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.ChargeTransactionService;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.UpdateChargeTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class ChargeTransactionController {

    private final ChargeTransactionService chargeTransactionService;
    private final ModelMapper modelMapper;

    @Autowired
    public ChargeTransactionController(ChargeTransactionService chargeTransactionService, ModelMapper modelMapper) {
        this.chargeTransactionService = chargeTransactionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/chargeTransactions")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/chargeTransaction/chargeTransactionList");
        List<ChargeTransaction> chargeTransactions = chargeTransactionService.findAll();
        modelAndView.addObject(chargeTransactions);
        return modelAndView;
    }

    @GetMapping("/chargeTransactions/{id}")
    public ModelAndView showChargeDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/chargeTransaction/chargeTransactionDetails");
        ChargeTransaction chargeTransaction = chargeTransactionService.getById(id);
        modelAndView.addObject(chargeTransaction);
        return modelAndView;
    }

    @GetMapping("/chargeTransactions/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/chargeTransaction/createChargeTransaction");

        CreateChargeTransactionDTO createChargeTransactionDTO = CreateChargeTransactionDTO.builder().build();
        modelAndView.addObject(createChargeTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/chargeTransactions/create")
    public String create(@Valid @ModelAttribute CreateChargeTransactionDTO createChargeTransactionDTO) {
        log.info(createChargeTransactionDTO.toString());
        chargeTransactionService.create(createChargeTransactionDTO);
        return "redirect:/admin/chargeTransactions";
    }

    @GetMapping("/chargeTransactions/{chargeTransactionID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long chargeTransactionID) {
        ModelAndView modelAndView = new ModelAndView("shared/transaction/sub/chargeTransaction/editChargeTransaction");

        ChargeTransaction chargeTransaction = chargeTransactionService.getById(chargeTransactionID);
        modelAndView.addObject("chargeTransaction", chargeTransaction);

        UpdateChargeTransactionDTO updateChargeTransactionDTO = modelMapper.map(chargeTransaction, UpdateChargeTransactionDTO.class);
        modelAndView.addObject(updateChargeTransactionDTO);
        return modelAndView;
    }

    @PostMapping("/chargeTransactions/{chargeTransactionID}/edit")
    public String update(@PathVariable Long chargeTransactionID, @Valid @ModelAttribute UpdateChargeTransactionDTO updateChargeTransactionDTO) {
        chargeTransactionService.updateById(chargeTransactionID, updateChargeTransactionDTO);
        return "redirect:/admin/chargeTransactions";
    }

    @PostMapping("/chargeTransactions/{chargeTransactionID}/delete")
    public String delete(@PathVariable Long chargeTransactionID) {
        chargeTransactionService.deleteById(chargeTransactionID);
        return "redirect:/admin/chargeTransactions";
    }


}
