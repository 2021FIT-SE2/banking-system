package com.se2.bankingsystem.domains.FakeEWallet;


import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class FakeEWalletServiceImpl implements FakeEWalletService {

    private final FakeEWalletRepository fakeEWalletRepository;
    private final ModelMapper modelMapper;

    @Override
    public FakeEWallet create(CreateFakeEWalletDTO createFakeEWalletDTO) {
        FakeEWallet fakeEWallet = convertToEWallet(createFakeEWalletDTO);
        return fakeEWalletRepository.save(fakeEWallet);
    }

    private FakeEWallet convertToEWallet(CreateFakeEWalletDTO createFakeEWalletDTO) {
        return modelMapper.map(createFakeEWalletDTO, FakeEWallet.class);
    }

    @Override
    public FakeEWallet updateById(Long id, UpdateFakeEWalletDTO updateFakeEWalletDTO) {
        FakeEWallet fakeEWallet = fakeEWalletRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateFakeEWalletDTO, fakeEWallet);
        return fakeEWalletRepository.save(fakeEWallet);
    }

    @Override
    public void deleteById(Long id) {
        fakeEWalletRepository.deleteById(id);
    }

    @Override
    public List<FakeEWallet> findAll() {
        return fakeEWalletRepository.findAll();
    }

    @Override
    public Page<FakeEWallet> findAll(Pageable pageable) {
        return fakeEWalletRepository.findAll(pageable);
    }

    @Override
    public FakeEWallet getById(Long id) {
        return fakeEWalletRepository.findById(id).orElse(null);
    }

    @Override
    public List<FakeEWallet> findAllByCustomerId(Long customerId) {
        return fakeEWalletRepository.findAllByCustomerId(customerId);
    }

    @Override
    public boolean existsById(Long id) {
        return fakeEWalletRepository.existsById(id);
    }
}
