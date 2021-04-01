package com.se2.bankingsystem.domains.User.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.se2.bankingsystem.base.TimeStamps;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO implements TimeStamps {

    @Size(min = User.MIN_LENGTH_USERNAME, max = User.MAX_LENGTH_USERNAME)
    private String username;

    @NotNull
    @Size(min = User.MIN_LENGTH_PASSWORD, max = User.MAX_LENGTH_PASSWORD)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Size(min = User.MIN_LENGTH_PHONE_NUMBER, max = User.MAX_LENGTH_PHONE_NUMBER)
    private String phoneNumber;

    @Size(min = User.MIN_LENGTH_FIRST_NAME, max = User.MAX_LENGTH_FIRST_NAME)
    private String firstName;

    @Size(min = User.MIN_LENGTH_LAST_NAME, max = User.MAX_LENGTH_LAST_NAME)
    private String lastName;

    @NotNull
    private AuthorityName role;

    @JsonIgnore
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
