package com.se2.bankingsystem;

import com.se2.bankingsystem.config.exception.BankingSystemException;
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

    public void init() throws BankingSystemException {
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
                .username("tangbaminh")
                .email("tangbaminh@gmail.com")
                .address("Thanh Xuan, Hanoi")
                .gender(Gender.MALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0900000001")
                .build();

            CreateCustomerDTO createCustomerDTO2 = CreateCustomerDTO.builder()
                .dob(LocalDate.of(2000, 8, 8))
                .firstName("Duong")
                .lastName("Nguyen Thi Thuy")
                .password("1801040052")
                .username("nguyenthuyduong")
                .email("nguyenthuyduong@gmail.com")
                .address("Thai Thinh, Hanoi")
                .gender(Gender.FEMALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0900000002")
                .build();

            CreateCustomerDTO createCustomerDTO3 = CreateCustomerDTO.builder()
                .dob(LocalDate.of(2000, 4, 12))
                .firstName("Nam")
                .lastName("Duong Hoang")
                .password("1801040153")
                .username("duonghoangnam")
                .email("duonghoangnam@gmail.com")
                .address("Thanh Xuan, Hanoi")
                .gender(Gender.MALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0900000003")
                .build();

            CreateCustomerDTO createCustomerDTO4 = CreateCustomerDTO.builder()
                .dob(LocalDate.of(2000, 8, 8))
                .firstName("Phuong")
                .lastName("An Thi")
                .password("1801040169")
                .username("anthiphuong")
                .email("anthiphuong@gmail.com")
                .address("Thanh Xuan, Hanoi")
                .gender(Gender.FEMALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0900000004")
                .build();

            CreateCustomerDTO createCustomerDTO5 = CreateCustomerDTO.builder()
                .dob(LocalDate.of(2000, 8, 8))
                .firstName("Anh")
                .lastName("Tran Thi Ngoc")
                .password("1801040017")
                .username("tranthingocanh")
                .email("tranthingocanh@gmail.com")
                .address("Thanh Xuan, Hanoi")
                .gender(Gender.FEMALE)
                .role(AuthorityName.CUSTOMER)
                .phoneNumber("0900000005")
                .build();

            userService.create(createUserDTO);
            customerService.create(createCustomerDTO);
            customerService.create(createCustomerDTO2);
            customerService.create(createCustomerDTO3);
            customerService.create(createCustomerDTO4);
            customerService.create(createCustomerDTO5);

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
