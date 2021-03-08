package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService extends CRUDService<Customer, Long, CreateCustomerDTO, UpdateCustomerDTO> {

//    Page<Customer> findByDepartmentId(Long departmentId, Pageable pageable);
//
//    Page<Customer> findByCourseReleaseId(Long courseReleaseId, Pageable pageable);
//
//    Page<Customer> findByCourseId(Long courseId, Pageable pageable);
//
//    Page<Customer> findByKeyWord(String keyword, Pageable pageRequest);

    Page<Customer> getMany(Pageable pageRequest);

//    List<Customer> createManyStudents(List<CreateCustomerDTO> createCustomerDTOList);
}
