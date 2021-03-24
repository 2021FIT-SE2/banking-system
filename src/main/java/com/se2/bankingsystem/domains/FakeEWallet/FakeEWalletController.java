package com.se2.bankingsystem.domains.FakeEWallet;


import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Wallet Manager", description = "The Wallet API")
public class FakeEWalletController {

    private final FakeEWalletService fakeEWalletService;

    @Autowired
    public FakeEWalletController(FakeEWalletService fakeEWalletService) {
        this.fakeEWalletService = fakeEWalletService;
    }
    
    @Operation(summary = "Create a new E-wallet")
    @PostMapping("/e_wallets")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing Request Parameter"),
        @ApiResponse(responseCode = "422", description = "Input validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Field value(s) already exists")
    })
    public FakeEWallet create(@Valid @RequestBody CreateFakeEWalletDTO createFakeEWalletDTO) {
        return fakeEWalletService.create(createFakeEWalletDTO);
    }

    @Operation(summary = "Get E-Wallets with paginating and sorting options")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @GetMapping(value = "/e_wallets/all")
    public List<FakeEWallet> getAll() {
        return fakeEWalletService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get E-Wallets with paginating options")
    @GetMapping("/e_wallets")
    @PageableAsQueryParam
    public Page<FakeEWallet> getMany(
        @Parameter(name = "Filter", hidden = true) Pageable pageable
    ) {
        return fakeEWalletService.getMany(pageable);
    }

    @Operation(summary = "Get a E-Wallet by ID")
    @PreAuthorize("hasAuthority('ADMIN') or @authorityServiceImpl.hasStudentAccess(principal.id, #id)")
    @GetMapping(value = "/e_wallets/{id}")
    public FakeEWallet getByID(@PathVariable Long id) {
        return fakeEWalletService.getById(id);
    }

    @Operation(summary = "Update an E-Wallet by ID")
    @PutMapping(value = "/e_wallets/{id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing request parameter(s)"),
        @ApiResponse(responseCode = "422", description = "Input constraints validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Unique field value(s) already exists")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    public FakeEWallet updateByID(@PathVariable Long id, @Valid @RequestBody UpdateFakeEWalletDTO updateFakeEWalletDTO) {
        return fakeEWalletService.updateById(id, updateFakeEWalletDTO);
    }

    @Operation(summary = "Delete an E-Wallet by ID")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/e_wallets/{id}")
    public void deleteByID(@PathVariable Long id) {
        fakeEWalletService.deleteById(id);
    }
}
