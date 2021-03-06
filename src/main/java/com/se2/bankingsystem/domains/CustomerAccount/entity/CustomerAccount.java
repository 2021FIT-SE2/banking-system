package com.se2.bankingsystem.domains.CustomerAccount.entity;

import com.se2.bankingsystem.base.TimeStamps;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "customer_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "accountType", discriminatorType = DiscriminatorType.STRING)
public class CustomerAccount implements TimeStamps {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Singular
    @OneToMany(mappedBy = "customerAccount", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Transaction> transactions;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @PreRemove
    private void preRemove() {
        for (Transaction transaction: transactions)
            transaction.setCustomerAccount(null);
    }
}
