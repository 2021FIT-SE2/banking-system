package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateLoanAccountDTO {

    @PositiveOrZero
    @NotNull
    private Double rate;

    @PositiveOrZero
    @NotNull
    private Integer duration;

    @FutureOrPresent
    private LocalDateTime startAt;

    @FutureOrPresent
    private LocalDateTime endAt;

    @PositiveOrZero
    @NotNull
    private Long principal;

    @PositiveOrZero
    @NotNull
    private Long interest;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime startDate = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime endDate = LocalDateTime.now();
}
