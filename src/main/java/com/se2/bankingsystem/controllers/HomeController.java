package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.User.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();

        // If not logged in, redirect to landing page
        String viewName = "index";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Else if logged in
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {

            User currentUser = (User) authentication.getPrincipal();
            modelAndView.addObject(currentUser);

            for (GrantedAuthority grantedAuthority: authentication.getAuthorities()) {
                // If logged in as admin, redirect to admin dashboard
                if (grantedAuthority.getAuthority().equals("ADMIN"))
                    viewName = "redirect:admin/dashboard";

                // If logged in as customer, redirect to customer dashboard
                else if (grantedAuthority.getAuthority().equals("CUSTOMER"))
                    viewName = "redirect:customer/dashboard";
            }
        }
        modelAndView.setViewName(viewName);

        return modelAndView;
    }
}
