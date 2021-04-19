package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "normal_accounts")
public class NormalAccount extends CustomerAccount {

    @NotNull
    @PositiveOrZero
    private Long balance;
}
