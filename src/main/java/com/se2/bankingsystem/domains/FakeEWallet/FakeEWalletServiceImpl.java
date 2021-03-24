package com.se2.bankingsystem.domains.FakeEWallet;


import com.se2.bankingsystem.domains.Authority.AuthorityRepository;
import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeEWalletServiceImpl implements FakeEWalletService {

    private final FakeEWalletRepository fakeEWalletRepository;

//    private final DepartmentRepository departmentRepository;

    private final AuthorityRepository authorityRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public FakeEWalletServiceImpl(
        FakeEWalletRepository fakeEWalletRepository,
//        DepartmentRepository departmentRepository,
        AuthorityRepository authorityRepository,
        ModelMapper modelMapper
    ) {
        this.fakeEWalletRepository = fakeEWalletRepository;
//        this.departmentRepository = departmentRepository;
        this.authorityRepository = authorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FakeEWallet create(CreateFakeEWalletDTO createFakeEWalletDTO) {
        FakeEWallet fakeEWallet = convertToStudent(createFakeEWalletDTO);
        return fakeEWalletRepository.save(fakeEWallet);
    }

    private FakeEWallet convertToStudent(CreateFakeEWalletDTO createFakeEWalletDTO) {
        FakeEWallet fakeEWallet = modelMapper.map(createFakeEWalletDTO, FakeEWallet.class);

//        Authority authority = authorityRepository.findByName(AuthorityName.STUDENT);
//        customerAccount.setAuthorities(Collections.singletonList(authority));

//        Department department = departmentRepository.findById(createCustomerAccountDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customerAccount.setDepartment(department);

        return fakeEWallet;
    }

    @Override
    public FakeEWallet updateById(Long id, UpdateFakeEWalletDTO updateFakeEWalletDTO) {
        FakeEWallet fakeEWallet = fakeEWalletRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateFakeEWalletDTO, modelMapper);

//        Department department = departmentRepository.findById(updateCustomerAccountDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customerAccount.setDepartment(department);

        return fakeEWalletRepository.save(fakeEWallet);
    }

    @Override
    public void deleteById(Long id) {
        fakeEWalletRepository.deleteById(id);
    }

    @Override
    public List<FakeEWallet> getAll() {
        return fakeEWalletRepository.findAll();
    }

    @Override
    public Page<FakeEWallet> getMany(Pageable pageable) {
        return fakeEWalletRepository.findAll(pageable);
    }

    @Override
    public FakeEWallet getById(Long id) {
        return fakeEWalletRepository.findById(id).orElse(null);
    }

//    @Override
//    public Page<CustomerAccount> findByDepartmentId(Long departmentId, Pageable pageable) {
//        return customerAccountRepository.findByDepartmentId(departmentId, pageable);
//    }
//
//    @Override
//    public Page<CustomerAccount> findByCourseReleaseId(Long courseReleaseId, Pageable pageable) {
//        return customerAccountRepository.findByCourseReleaseId(courseReleaseId, pageable);
//    }
//
//    @Override
//    public Page<CustomerAccount> findByCourseId(Long courseId, Pageable pageable) {
//        return customerAccountRepository.findByCourseId(courseId, pageable);
//    }
//
//    @Override
//    public Page<CustomerAccount> findByKeyWord(String keyword, Pageable pageable) {
//        return customerAccountRepository.findByKeyword(keyword, pageable);
//    }

    public List<FakeEWallet> createManyStudents(List<CreateFakeEWalletDTO> createFakeEWalletDTOList) {
        List<FakeEWallet> fakeEWallets = new ArrayList<>();

        for (CreateFakeEWalletDTO createFakeEWalletDTO : createFakeEWalletDTOList) {
            FakeEWallet fakeEWallet = convertToStudent(createFakeEWalletDTO);
            fakeEWallets.add(fakeEWallet);
        }
        return fakeEWalletRepository.saveAll(fakeEWallets);
    }
}
