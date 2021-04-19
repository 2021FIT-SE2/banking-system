package com.se2.bankingsystem;

import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.User.UserService;
import com.se2.bankingsystem.domains.User.dto.CreateUserDTO;
import com.se2.bankingsystem.domains.User.entity.Gender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class InitData {
    private final AuthorityService authorityService;

    private final CustomerService customerService;

    private final UserService userService;

    @Autowired
    public InitData(
        AuthorityService authorityService,
        CustomerService customerService, UserService userService) {
        this.authorityService = authorityService;
        this.customerService = customerService;
        this.userService = userService;
    }

    public void init() {
        if (authorityService.findAll().isEmpty()) {

            String username = "admin";
            String password = "se2@2021";

            CreateAuthorityDTO adminAuthorityDTO = new CreateAuthorityDTO(AuthorityName.ADMIN);
            CreateAuthorityDTO customerAuthorityDTO = new CreateAuthorityDTO(AuthorityName.CUSTOMER);

            authorityService.create(adminAuthorityDTO);
            authorityService.create(customerAuthorityDTO);

            CreateUserDTO createUserDTO =
                CreateUserDTO.builder()
                    .username(username)
                    .password(password)
                    .firstName("Admin")
                    .lastName("SQA 2021")
                    .phoneNumber("0969696969")
                    .role(AuthorityName.ADMIN)
                    .build();

            CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder()
                .dob(LocalDate.of(2000, 12, 4))
                .firstName("Minh")
                .lastName("Tang Ba")
                .password("1801040147")
                .username("tangbamiinh")
                .email("tangbamiinh@gmail.com")
                .address("Thanh Xuan, Hanoi")
                .gender(Gender.MALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0904842084")
                .build();

            userService.create(createUserDTO);
            customerService.create(createCustomerDTO);

            testData();
        } else {
            log.info("Data has been previously initialized, ignoring InitData");
            log.info("If you want to re-initialize the data, reset the database ems (by drop & create database ems; again), and restart the application");
        }
    }

    public void testData() {

        log.info("Data Initialization on First Server Boot Completed Successfully!");
    }
}
