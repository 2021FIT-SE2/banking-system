package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class NormalAccountServiceImpl implements NormalAccountService {

    private final NormalAccountRepository normalAccountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NormalAccountServiceImpl(NormalAccountRepository normalAccountRepository, ModelMapper modelMapper) {
        this.normalAccountRepository = normalAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NormalAccount create(CreateNormalAccountDTO createNormalAccountDTO) {
        NormalAccount normalAccount = modelMapper.map(createNormalAccountDTO, NormalAccount.class);
        return normalAccountRepository.save(normalAccount);
    }

    @Override
    public NormalAccount updateById(Long id, UpdateNormalAccountDTO updateNormalAccountDTO) {
        NormalAccount existing = normalAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateNormalAccountDTO, existing);
        return normalAccountRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        normalAccountRepository.deleteById(id);
    }

    @Override
    public List<NormalAccount> findAll() {
        return normalAccountRepository.findAll();
    }

    @Override
    public NormalAccount getById(Long id) {
        return normalAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<NormalAccount> findAll(Pageable pageable) {
        return normalAccountRepository.findAll(pageable);
    }
}
