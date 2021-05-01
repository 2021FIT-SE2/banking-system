package com.se2.bankingsystem.domains.FakeEWallet.entity;

import com.se2.bankingsystem.base.TimeStamps;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;


@Entity
@Table(name = "fake_e_wallets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class FakeEWallet implements TimeStamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @PositiveOrZero
    private Long balance;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EWalletProvider provider;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;
}
