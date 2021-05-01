package com.se2.bankingsystem.domains.FakeEWallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.FakeEWallet.entity.EWalletProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFakeEWalletDTO {

    @NotNull
    private Long customerID;

    @PositiveOrZero
    private Long balance;

    @NotNull
    private EWalletProvider provider;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
