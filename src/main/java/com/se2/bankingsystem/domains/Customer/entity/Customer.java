package com.se2.bankingsystem.domains.Customer.entity;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.User.entity.Gender;
import com.se2.bankingsystem.domains.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends User {

    public static final int MIN_LENGTH_PHONE_NUMBER = 9;
    public static final int MAX_LENGTH_PHONE_NUMBER = 10;

    public static final int MIN_LENGTH_FULL_ADDRESS = 2;
    public static final int MAX_LENGTH_FULL_ADDRESS = 255;

    @NotNull
    private Gender gender;

    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    @Size(min = MIN_LENGTH_FULL_ADDRESS, max = MAX_LENGTH_FULL_ADDRESS)
    private String address;

    @NotNull
    @PastOrPresent
    private LocalDate dob;

    @Singular
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<CustomerAccount> accounts;

    @Singular
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<FakeEWallet> wallets;

    @PreRemove
    private void preRemove() {
        for (CustomerAccount customerAccount: this.accounts)
            customerAccount.setCustomer(null);

        for (FakeEWallet wallet: this.wallets)
            wallet.setCustomer(null);
    }
}
