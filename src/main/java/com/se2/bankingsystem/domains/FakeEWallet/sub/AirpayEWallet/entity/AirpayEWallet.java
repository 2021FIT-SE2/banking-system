package com.se2.bankingsystem.domains.FakeEWallet.sub.AirpayEWallet.entity;

import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AirpayEWallet extends FakeEWallet {

    private Long minBalance;

    private Long balance;
}
