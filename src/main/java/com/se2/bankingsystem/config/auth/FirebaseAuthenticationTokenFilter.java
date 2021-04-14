package com.se2.bankingsystem.config.auth;

import com.google.api.client.util.Strings;
import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.se2.bankingsystem.domains.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class FirebaseAuthenticationTokenFilter extends OncePerRequestFilter {

    private final static String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_COOKIE_NAME = "token";

    private final UserService userService;

    @Autowired
    public FirebaseAuthenticationTokenFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
        throws ServletException, IOException {

        String authToken = request.getHeader(TOKEN_HEADER);

        if (Strings.isNullOrEmpty(authToken)) {
            // Try to get from the cookie if the bearer header is not present
            authToken = getTokenFromCookie(request);
            // If both places are empty, forward the request immediately
            if (Strings.isNullOrEmpty(authToken)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        try {
            UsernamePasswordAuthenticationToken authentication = getAndValidateAuthentication(authToken);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        filterChain.doFilter(request, response);
    }

    /**
     * @param authToken Firebase access token string
     * @return the computed result
     */
    private UsernamePasswordAuthenticationToken getAndValidateAuthentication(String authToken) throws Exception {

        FirebaseToken firebaseToken = authenticateFirebaseToken(authToken);

        log.info("userService");
        log.info(userService.toString());

        UserDetails userDetails = userService.loadUserByUsername(firebaseToken.getEmail());

        log.info("userDetails");
        log.info(userDetails.toString());

        return new UsernamePasswordAuthenticationToken(userDetails, authToken, userDetails.getAuthorities());
    }

    /**
     * @param authToken Firebase access token string
     * @return the computed result
     */
    private FirebaseToken authenticateFirebaseToken(String authToken) throws Exception {
        ApiFuture<FirebaseToken> app = FirebaseAuth.getInstance().verifyIdTokenAsync(authToken);

        return app.get();
    }

    @Override
    public void destroy() {
        log.debug("destroy():: invoke");
    }

    private String getTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) return null;

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals(TOKEN_COOKIE_NAME)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
