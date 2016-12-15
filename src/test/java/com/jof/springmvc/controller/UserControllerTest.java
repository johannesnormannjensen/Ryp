package com.jof.springmvc.controller;

import com.jof.springmvc.configuration.AppConfig;
import com.jof.springmvc.model.User;
import com.jof.springmvc.service.MockRoleService;
import com.jof.springmvc.service.MockUserService;
import com.jof.springmvc.service.RoleService;
import com.jof.springmvc.service.UserService;

import net.rithms.riot.constant.Region;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Ferenc_S on 12/13/2016.
 */ 
@ContextConfiguration
public class UserControllerTest {
    @Spy
    UserService service = new MockUserService();
    
    @Spy
    RoleService roleService = new MockRoleService();

    @InjectMocks
    UserController userController;

    @Spy
    ModelMap model;

    @Mock
    Authentication authentication;
    @Mock
    BindingResult bindingResult;

    User user;
    
    MockHttpSession session;
    MockHttpServletRequest request;

    @Before
    public void setUp() {
        authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("Name1");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        
        bindingResult = mock(BindingResult.class);
        user = new User();
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        request.setSession(session);
        MockitoAnnotations.initMocks(this);
    }

    /*
     * Tests if the wiring is correct in the constructor
     */
    @Test
    public void testListUsers() throws Exception {
        request.getSession().setAttribute("remoteUser", user);
        assertEquals("userlist", userController.listUsers(model, request));
        assertEquals(service.findAllUsers(), model.get("users"));
        verify(service, atLeastOnce()).findAllUsers();
        verify(service, atLeastOnce()).findAllUsers();
    }

    @Test
    public void testListUsersNoRemoteData() throws Exception {
        assertEquals("userlist", userController.listUsers(model, request));
        assertEquals(service.findAllUsers(), model.get("users"));
        verify(service, atLeastOnce()).findAllUsers();
        verify(service, atLeastOnce()).findAllUsers();
    }

    @Test
    public void testRegisterGet() throws Exception {
    	assertEquals("register", userController.registerUser(model, request));
    	assertNotNull(model.get("user"));
    	assertEquals(null, ((User) model.get("user")).getId());
    }
    
    @Test
    public void testregisterPost() throws Exception {
    	user.setRegion(Region.EUW.toString());
    	assertEquals("login", userController.registerUser(user, bindingResult, model));
    }
    
    @Test
    public void testregisterPostNoRegion() throws Exception {
    	assertEquals("register", userController.registerUser(user, bindingResult, model));
    }
    
    @Test
    public void editUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void initializeProfiles() throws Exception {

    }

    @Test
    public void accessDeniedPage() throws Exception {

    }

    @Test
    public void loginPage() throws Exception {

    }

    @Test
    public void logoutPage() throws Exception {

    }

}