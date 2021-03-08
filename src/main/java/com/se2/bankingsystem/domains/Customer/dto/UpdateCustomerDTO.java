package com.se2.bankingsystem.domains.Customer.dto;

import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.User.dto.UpdateUserDTO;
import com.se2.bankingsystem.domains.User.entity.Gender;
import com.se2.bankingsystem.domains.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static com.se2.bankingsystem.domains.Customer.entity.Customer.MAX_LENGTH_FULL_ADDRESS;
import static com.se2.bankingsystem.domains.Customer.entity.Customer.MIN_LENGTH_FULL_ADDRESS;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateCustomerDTO extends UpdateUserDTO {

    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @Size(min = User.MIN_LENGTH_PHONE_NUMBER, max = User.MAX_LENGTH_PHONE_NUMBER)
    private String phoneNumber;

    @NotNull
    private Gender gender;

    @PastOrPresent
    private LocalDate dob;

    @NotNull
    private AuthorityName role;
}
