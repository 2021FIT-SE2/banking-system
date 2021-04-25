package com.se2.bankingsystem.domains.CustomerAccount;


import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;

    private final ModelMapper modelMapper;

    @Override
    public CustomerAccount create(CreateCustomerAccountDTO createCustomerAccountDTO) {
        CustomerAccount customerAccount = convertToStudent(createCustomerAccountDTO);
        return customerAccountRepository.save(customerAccount);
    }

    private CustomerAccount convertToStudent(CreateCustomerAccountDTO createCustomerAccountDTO) {
        CustomerAccount customerAccount = modelMapper.map(createCustomerAccountDTO, CustomerAccount.class);

//        Authority authority = authorityRepository.findByName(AuthorityName.STUDENT);
//        customerAccount.setAuthorities(Collections.singletonList(authority));

//        Department department = departmentRepository.findById(createCustomerAccountDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customerAccount.setDepartment(department);

        return customerAccount;
    }

    @Override
    public CustomerAccount updateById(String id, UpdateCustomerAccountDTO updateCustomerAccountDTO) {
        CustomerAccount customerAccount = customerAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateCustomerAccountDTO, modelMapper);

//        Department department = departmentRepository.findById(updateCustomerAccountDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customerAccount.setDepartment(department);

        return customerAccountRepository.save(customerAccount);
    }

    @Override
    public void deleteById(String id) {
        customerAccountRepository.deleteById(id);
    }

    @Override
    public List<CustomerAccount> findAll() {
        return customerAccountRepository.findAll();
    }

    @Override
    public Page<CustomerAccount> findAll(Pageable pageable) {
        return customerAccountRepository.findAll(pageable);
    }

    @Override
    public CustomerAccount getById(String id) {
        return customerAccountRepository.findById(id).orElse(null);
    }

    public List<CustomerAccount> createManyCustomerAccounts(List<CreateCustomerAccountDTO> createCustomerAccountDTOList) {
        List<CustomerAccount> customerAccounts = new ArrayList<>();

        for (CreateCustomerAccountDTO createCustomerAccountDTO : createCustomerAccountDTOList) {
            CustomerAccount customerAccount = convertToStudent(createCustomerAccountDTO);
            customerAccounts.add(customerAccount);
        }
        return customerAccountRepository.saveAll(customerAccounts);
    }

    @Override
    public List<CustomerAccount> findAllByCustomerId(Long customerID) {
        return customerAccountRepository.findByCustomerId(customerID);
    }
}
