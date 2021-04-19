package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateLoanAccountDTO {

    private Long customerID;

    private Long balance;

    private Long principal;

    private Long interest;

    private Long rate;

    private int duration;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime startDate = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime endDate = LocalDateTime.now();

}
