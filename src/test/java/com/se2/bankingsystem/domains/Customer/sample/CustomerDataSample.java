package com.se2.bankingsystem.domains.Customer.sample;

import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.User.entity.Gender;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDataSample {

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder()
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

    private static final CreateCustomerDTO createCustomerDTO2 = CreateCustomerDTO.builder()
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

    private static final CreateCustomerDTO createCustomerDTO3 = CreateCustomerDTO.builder()
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

    private static final CreateCustomerDTO createCustomerDTO4 = CreateCustomerDTO.builder()
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

    private static final CreateCustomerDTO createCustomerDTO5 = CreateCustomerDTO.builder()
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

    public static List<CreateCustomerDTO> getCustomerDTOs() {
        return Arrays.asList(
            createCustomerDTO.toBuilder().build(),
            createCustomerDTO2.toBuilder().build(),
            createCustomerDTO3.toBuilder().build(),
            createCustomerDTO4.toBuilder().build(),
            createCustomerDTO5.toBuilder().build()
        );
    }

    public static List<Customer> getCustomers() {
        List<CreateCustomerDTO> createCustomerDTOS = getCustomerDTOs();

        ArrayList<Customer> customers = new ArrayList<>();

        for (CreateCustomerDTO createCustomerDTO: createCustomerDTOS) {
            Customer customer = modelMapper.map(createCustomerDTO, Customer.class);
            customers.add(customer);
        }

        return customers;
    }

    public static Customer getCustomer() {
        return modelMapper.map(createCustomerDTO, Customer.class);
    }

    public static CreateCustomerDTO getCreateCustomerDTO() {
        return createCustomerDTO;
    }
}
