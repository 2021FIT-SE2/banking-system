package com.se2.bankingsystem.domains.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se2.bankingsystem.domains.Auth.entity.Authority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * User object to store user data.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails, Serializable {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User username.
     */
    @Column(name = "username", nullable = false, length = 16)
    private String username;

    /**
     * User password.
     */
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * User full name.
     */
    @Column(name = "full_name", nullable = false, length = 32)
    private String fullName;

    /**
     * Empty constructor.
     */
    public User() {
    }

    /**
     * Constructor to make a new instance.
     *
     * @param username User username.
     * @param password User password.
     * @param fullName User full name.
     */
    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}