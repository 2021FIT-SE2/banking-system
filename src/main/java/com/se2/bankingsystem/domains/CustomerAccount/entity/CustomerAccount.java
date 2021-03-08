package com.se2.bankingsystem.domains.CustomerAccount.entity;

import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.User.entity.User;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "customer_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomerAccount {
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
