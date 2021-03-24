package com.se2.bankingsystem.domains.FakeEWallet.entity;

import com.se2.bankingsystem.domains.Customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "fake_e_wallets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class FakeEWallet {
    @Id
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;
//
//    @JsonIgnore
//    @Singular
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<Enrollment> enrollments;
}
