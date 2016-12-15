package com.jof.springmvc.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jof.springmvc.util.region.RegionUtil;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String regionParam = request.getParameter("region");
        RegionUtil.validate(regionParam, request);
        request.getSession().setAttribute("region", regionParam);
        return super.attemptAuthentication(request, response); 
    } 
	
	
	
}
