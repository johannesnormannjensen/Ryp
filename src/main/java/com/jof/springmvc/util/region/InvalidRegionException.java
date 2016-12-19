package com.jof.springmvc.util.region;

import org.springframework.security.core.AuthenticationException;

public class InvalidRegionException extends AuthenticationException {

    public InvalidRegionException(String msg) {
        super("Region :" + msg + " is not a valid region.");
    }

}
