package com.se2.bankingsystem.domains.Transaction;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
}
