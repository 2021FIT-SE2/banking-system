package com.se2.bankingsystem.domains.Customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.User.dto.CreateUserDTO;
import com.se2.bankingsystem.domains.User.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
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
public class CreateCustomerDTO extends CreateUserDTO {

    @Email
    private String email;

    @NotNull
    @Size(min = MIN_LENGTH_FULL_ADDRESS, max = MAX_LENGTH_FULL_ADDRESS)
    private String address;

    @NotNull
    private Gender gender;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @JsonIgnore
    @Builder.Default
    private AuthorityName role = AuthorityName.CUSTOMER;
}
