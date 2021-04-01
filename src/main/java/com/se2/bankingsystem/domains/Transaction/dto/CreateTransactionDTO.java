package com.se2.bankingsystem.domains.Transaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.base.TimeStamps;
import com.se2.bankingsystem.domains.Transaction.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionDTO implements TimeStamps {

    private Long customerAccountID;

    private TransactionType transactionType;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
