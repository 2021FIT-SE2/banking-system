package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class NormalAccountServiceImpl implements NormalAccountService {

    private final NormalAccountRepository normalAccountRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public NormalAccount create(CreateNormalAccountDTO createNormalAccountDTO) {
        NormalAccount normalAccount = modelMapper.map(createNormalAccountDTO, NormalAccount.class);

        Customer customer = customerRepository.findById(createNormalAccountDTO.getCustomerID()).orElseThrow(EntityNotFoundException::new);
        normalAccount.setCustomer(customer);

        return normalAccountRepository.save(normalAccount);
    }

    @Override
    public NormalAccount updateById(String id, UpdateNormalAccountDTO updateNormalAccountDTO) {
        NormalAccount existing = normalAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateNormalAccountDTO, existing);
        return normalAccountRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        normalAccountRepository.deleteById(id);
    }

    @Override
    public List<NormalAccount> findAll() {
        return normalAccountRepository.findAll();
    }

    @Override
    public NormalAccount getById(String id) {
        return normalAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<NormalAccount> findAll(Pageable pageable) {
        return normalAccountRepository.findAll(pageable);
    }
}
