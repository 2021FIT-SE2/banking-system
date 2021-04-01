//package com.se2.bankingsystem.domains.Authentication;
//
//import com.se2.bankingsystem.config.auth.JwtUtil;
//import com.se2.bankingsystem.domains.Authentication.dto.ChangePasswordDTO;
//import com.se2.bankingsystem.domains.Authentication.dto.LoginRequestDTO;
//import com.se2.bankingsystem.domains.User.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthenticationController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final UserService userService;
//
//    private final JwtUtil jwtUtil;
//
//    @Autowired
//    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping(value = "/login")
//    public String authenticate(@Valid @RequestBody LoginRequestDTO loginRequestDTO) throws BadCredentialsException {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
//        final UserDetails userDetails = userService.loadUserByUsername(loginRequestDTO.getUsername());
//        return jwtUtil.generateToken(userDetails);
//    }
//
//    @PostMapping(value = "/changePassword")
//    public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
//        String oldPassword = changePasswordDTO.getOldPassword();
//        String newPassword = changePasswordDTO.getNewPassword();
//        userService.changePassword(oldPassword, newPassword);
//        return ResponseEntity.accepted().body(true);
//    }
//
//    @GetMapping("/whoami")
//    public ResponseEntity<Object> currentUser() {
//        Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return new ResponseEntity<>(currentUser, HttpStatus.OK);
//    }
//}
