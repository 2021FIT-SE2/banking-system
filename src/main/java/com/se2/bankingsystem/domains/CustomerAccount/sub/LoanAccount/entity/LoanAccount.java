package com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loanAccounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanAccount extends CustomerAccount {
    private Double rate;

    private Integer duration;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private Long principal;

    private Long interest;

}
