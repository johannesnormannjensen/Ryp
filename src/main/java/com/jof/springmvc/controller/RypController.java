package com.jof.springmvc.controller;

import com.jof.springmvc.model.Role;
import com.jof.springmvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RypController {

    static final Logger logger = LoggerFactory.getLogger(RypController.class);

    protected static User getRemoteUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("remoteUser");
    }

    public static void validateRemoteAdmin(HttpServletRequest request) {
        boolean isAdmin = false;
        String message = null;
        if (getRemoteUser(request) != null) {
            for (Role role : getRemoteUser(request).getRoles()) {
                if (role.getType().equals("ADMIN"))
                    isAdmin = true;
            }
            message = new String(
                    "User: " + getRemoteUser(request).getUsername() + " is trying to access unautharised content");
        }
        if (!isAdmin) {
            if (message == null)
                message = new String("An anonymous user is trying to access unautharised content");
            logger.warn(message);
            throw new AccessDeniedException(message);
        }
    }

    @ExceptionHandler({AccessDeniedException.class})
    public String accessDeniedException() {
        return "accessDenied";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    protected String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
