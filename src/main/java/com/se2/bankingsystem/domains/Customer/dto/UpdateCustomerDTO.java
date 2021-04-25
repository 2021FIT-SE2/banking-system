package com.se2.bankingsystem.domains.Customer.dto;

import com.se2.bankingsystem.domains.User.dto.UpdateUserDTO;
import com.se2.bankingsystem.domains.User.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
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

    @Email
    private String email;

    @Size(min = MIN_LENGTH_FULL_ADDRESS, max = MAX_LENGTH_FULL_ADDRESS)
    private String address;

    private Gender gender;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
}
