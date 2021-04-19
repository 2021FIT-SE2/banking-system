package com.se2.bankingsystem.domains.Transaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Transaction.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateTransactionDTO {

    @NotNull
    private Long transactionID;

    private TransactionType transactionType;

    @NotNull
    private Long customerAccountID;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
