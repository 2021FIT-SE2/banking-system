package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.Customer.sample.CustomerDataSample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testCreate_Success() throws BankingSystemException {
        CreateCustomerDTO createCustomerDTO = CustomerDataSample.getCreateCustomerDTO();
        customerService.create(createCustomerDTO);
        assertEquals(1, customerRepository.count());
    }

    @Test
    public void testUpdate_success() throws BankingSystemException {

        // Given
        Customer before = CustomerDataSample.getCustomer();
        before = customerRepository.save(before);

        // When
        UpdateCustomerDTO updateCustomerDTO = modelMapper.map(before, UpdateCustomerDTO.class);
        updateCustomerDTO.setAddress("New Address");
        updateCustomerDTO.setEmail("newEmail@gmail.com");

        Customer after = customerService.updateById(before.getId(), updateCustomerDTO);

        // Then
        assertEquals("New Address", after.getAddress());
        assertEquals("newEmail@gmail.com", after.getEmail());
    }

    @Test
    public void testRetrieve_success() {
        // Given
        List<Customer> customers = CustomerDataSample.getCustomers();

        for (Customer customer: customers) {
            customerRepository.save(customer);
        }
        // When
        List<Customer> actualResults = customerService.findAll();

        // Then
        assertEquals(customers.size(), actualResults.size());
    }

    @Test
    public void testExistsById_success() {
        // Given
        Customer customer = CustomerDataSample.getCustomer();
        customer = customerRepository.save(customer);

        // When
        boolean actualResult = customerService.existsById(customer.getId());

        assertTrue(actualResult);
    }

    @Test
    public void testGetById_success() {
        Customer customer = CustomerDataSample.getCustomer();
        customer = customerRepository.save(customer);

        Customer result = customerService.getById(customer.getId());

        assertEquals(customer.getId(), result.getId());
    }

    @Test
    public void testCheckEmailUnique_success() {
        Customer customer = CustomerDataSample.getCustomer();
        customer = customerRepository.save(customer);

        boolean result = customerService.isEmailUnique(customer.getEmail());

        assertFalse(result);
    }

    @Test
    public void testDeleteById_success() {
        Customer customer = CustomerDataSample.getCustomer();
        customer = customerRepository.save(customer);

        customerService.deleteById(customer.getId());

        assertEquals(0, customerRepository.count());
    }
}
