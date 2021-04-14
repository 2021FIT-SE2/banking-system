package com.se2.bankingsystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(path = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/dashboard");
        return modelAndView;
    }

    @GetMapping(path="/create-customer")
    public ModelAndView createCustomer(){
        ModelAndView modelAndView = new ModelAndView("admin/customer/createCustomer");
        return modelAndView;
    }

    @GetMapping(path="/customer-list")
    public ModelAndView showCustomerList(){
        ModelAndView modelAndView = new ModelAndView("admin/customer/customerList");
        return modelAndView;
    }

    @GetMapping(path="/edit-customer")
    public ModelAndView editCustomer(){
        ModelAndView modelAndView = new ModelAndView("admin/customer/editCustomer");
        return modelAndView;
    }

    @GetMapping(path="/saving-account-add")
    public ModelAndView addSavingAccount(){
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/savingAccount/savingAccountAdd");
        return modelAndView;
    }
    @GetMapping(path="/loan-account-add")
    public ModelAndView addLoanAccount(){
        ModelAndView modelAndView = new ModelAndView("admin/customer/account/loanAccount/loanAccountAdd");
        return modelAndView;
    }

//    @GetMapping(path="/create-transaction")
//    public ModelAndView createTransaction(){
//        ModelAndView modelAndView = new ModelAndView("admin/transaction/createTransaction");
//        return modelAndView;
//    }

    @GetMapping(path="/create-transfer")
    public ModelAndView addTransferTransaction(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/transfer/transferTransactionAdd");
        return modelAndView;
    }

    @GetMapping(path="/transfer-list")
    public ModelAndView showTransferTransactionList(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/transfer/transferTransactionList");
        return modelAndView;
    }

    @GetMapping(path="/create-withdraw")
    public ModelAndView addWithdrawTransaction(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/withdraw/withdrawTransactionAdd");
        return modelAndView;
    }
    @GetMapping(path="/withdraw-list")
    public ModelAndView showWithdrawTransactionList(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/withdraw/withdrawTransactionList");
        return modelAndView;
    }

    @GetMapping(path="/create-charge")
    public ModelAndView addChargeTransaction(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/charge/chargeTransactionAdd");
        return modelAndView;
    }
    @GetMapping(path="/charge-list")
    public ModelAndView showChargeTransactionList(){
        ModelAndView modelAndView = new ModelAndView("admin/transaction/charge/chargeTransactionList");
        return modelAndView;
    }

}
