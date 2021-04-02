package com.se2.bankingsystem.config.auth;

import com.se2.bankingsystem.domains.User.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true
)
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Value("${security.enabled:true}")
    private boolean securityEnabled;

    private static final String[] AUTH_WHITELIST = {
        "/",
        "/favicon.ico",
        "/webjars/**",
        "/resources/**",
        "/login",
        "/register",
        // other public endpoints of your API may be appended to this array
    };

    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    /**
     * Use to create instance of {@link FirebaseAuthenticationTokenFilter}.
     *
     * @return instance of {@link FirebaseAuthenticationTokenFilter}
     */
    public FirebaseAuthenticationTokenFilter firebaseAuthenticationFilterBean() {
        logger.debug(
            "firebaseAuthenticationFilterBean():: creating instance of FirebaseAuthenticationFilter.");

        return new FirebaseAuthenticationTokenFilter(userService);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (securityEnabled) {
            http.csrf().disable()
                .cors().and()
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.addFilterBefore(firebaseAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
