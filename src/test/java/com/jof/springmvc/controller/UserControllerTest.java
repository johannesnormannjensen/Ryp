package com.jof.springmvc.controller;

import com.jof.springmvc.model.User;
import com.jof.springmvc.service.MockUserService;
import com.jof.springmvc.service.UserService;
import org.junit.Before;
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
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Ferenc_S on 12/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserControllerTest {
    @Spy
    UserService service = new MockUserService();

    @InjectMocks
    UserController userController;

    @Spy
    ModelMap model;

    User user;
    MockHttpSession session;
    MockHttpServletRequest request;

    @Mock
    Authentication authentication;

    @Before
    public void setUp() {
        authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("Name1");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);


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
        assertEquals(userController.listUsers(model, request), "userlist");
        assertEquals(model.get("users"), service.findAllUsers());
        verify(service, atLeastOnce()).findAllUsers();
        verify(service, atLeastOnce()).findAllUsers();
    }

    @Test
    public void testListUsersNoRemoteData() throws Exception {
        assertEquals(userController.listUsers(model, request), "userlist");
        assertEquals(model.get("users"), service.findAllUsers());
        verify(service, atLeastOnce()).findAllUsers();
        verify(service, atLeastOnce()).findAllUsers();
    }

    @Test
    public void newUser() throws Exception {
        assertEquals(userController.newUser(model, request), "registration");
        assertNotNull(model.get("user"));
        assertFalse((Boolean) model.get("edit"));
        assertEquals(((User) model.get("user")).getId(), null);
    }

    @Test
    public void registerUser() throws Exception {

        assertEquals(userController.registerNewUser(model, request), "registration");
    }
    @Test
    public void registerNewUser() throws Exception {

    }

    @Test
    public void saveUser() throws Exception {

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