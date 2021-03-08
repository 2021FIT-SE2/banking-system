package com.se2.bankingsystem.domains.Authority.dto;

import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorityDTO {
    @NotNull
    private AuthorityName name;
}
