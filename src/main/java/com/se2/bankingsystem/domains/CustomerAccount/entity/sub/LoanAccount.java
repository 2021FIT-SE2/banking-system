package com.se2.bankingsystem.domains.CustomerAccount.entity.sub;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanAccount extends CustomerAccount {
    private Double rate;

    private Integer duration;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private Long principalAmount;

    private Long interest;
}
