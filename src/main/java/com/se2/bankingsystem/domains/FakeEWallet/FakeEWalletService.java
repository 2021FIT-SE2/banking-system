package com.se2.bankingsystem.domains.FakeEWallet;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FakeEWalletService extends CRUDService<FakeEWallet, Long, CreateFakeEWalletDTO, UpdateFakeEWalletDTO> {

//    Page<CustomerAccount> findByDepartmentId(Long departmentId, Pageable pageable);
//
//    Page<CustomerAccount> findByCourseReleaseId(Long courseReleaseId, Pageable pageable);
//
//    Page<CustomerAccount> findByCourseId(Long courseId, Pageable pageable);
//
//    Page<CustomerAccount> findByKeyWord(String keyword, Pageable pageRequest);

    Page<FakeEWallet> getMany(Pageable pageRequest);

//    List<CustomerAccount> createManyStudents(List<CreateCustomerAccountDTO> createCustomerAccountDTOList);
}
