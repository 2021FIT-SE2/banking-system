package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.base.CRUDService;

import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerAccountService extends CRUDService<CustomerAccount, Long, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> {

//    Page<CustomerAccount> findByDepartmentId(Long departmentId, Pageable pageable);
//
//    Page<CustomerAccount> findByCourseReleaseId(Long courseReleaseId, Pageable pageable);
//
//    Page<CustomerAccount> findByCourseId(Long courseId, Pageable pageable);
//
//    Page<CustomerAccount> findByKeyWord(String keyword, Pageable pageRequest);

    Page<CustomerAccount> getMany(Pageable pageRequest);

//    List<CustomerAccount> createManyStudents(List<CreateCustomerAccountDTO> createCustomerAccountDTOList);
}
