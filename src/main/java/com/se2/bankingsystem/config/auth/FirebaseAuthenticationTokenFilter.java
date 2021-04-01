package com.se2.bankingsystem.config.auth;

import com.google.api.client.util.Strings;
import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class FirebaseAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseAuthenticationTokenFilter.class);
    private final static String TOKEN_HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
        throws ServletException, IOException {

        String authToken = request.getHeader(TOKEN_HEADER);

        if (Strings.isNullOrEmpty(authToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            Authentication authentication = getAndValidateAuthentication(authToken);
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
    private Authentication getAndValidateAuthentication(String authToken) throws Exception {
        Authentication authentication;

        FirebaseToken firebaseToken = authenticateFirebaseToken(authToken);
        authentication = new UsernamePasswordAuthenticationToken(firebaseToken, authToken, new ArrayList<>());
        return authentication;
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
        logger.debug("destroy():: invoke");
    }

}
