package com.se2.bankingsystem.domains.User;

import com.se2.bankingsystem.domains.User.dto.UpdateUserDTO;
import com.se2.bankingsystem.domains.User.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The {@link UserController} contains all rest api function that need to
 * manage the application users.
 *
 * @see UserService
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Manager", description = "The User API")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get all Users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Something went wrong"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "404", description = "The users don't exists"),
        @ApiResponse(responseCode = "500", description = "Invalid JWT token")})
    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN') " +
        "or @authorityServiceImpl.hasStudentAccess(principal.id, #id)")
    @Operation(summary = "Get User by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Something went wrong"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "404", description = "The user doesn't found"),
        @ApiResponse(responseCode = "500", description = "Expired or invalid JWT token")})
    @GetMapping(value = "/{id}")
    public User getByID(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Check the username is unique.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Something went wrong"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "404", description = "The username is not valid"),
        @ApiResponse(responseCode = "500", description = "Expired or invalid JWT token")})
    @GetMapping(value = "/checkUniqueness/{username}")
    public boolean isUsernameUnique(@PathVariable String username) {
        return userService.isUsernameUnique(username);
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.id == #id")
    @Operation(summary = "Update user by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Something went wrong"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "404", description = "The user doesn't found"),
        @ApiResponse(responseCode = "500", description = "Expired or invalid JWT token")})
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody UpdateUserDTO updateUserDTO) {
        userService.updateById(id, updateUserDTO);
    }
}
