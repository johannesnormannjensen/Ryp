package com.jof.springmvc.controller;

import com.jof.springmvc.model.Role;
import com.jof.springmvc.model.User;
import com.jof.springmvc.service.MockRoleService;
import com.jof.springmvc.service.MockUserService;

import static com.jof.springmvc.service.MockUserService.*;
import com.jof.springmvc.service.RoleService;
import com.jof.springmvc.service.UserService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by Ferenc_S on 12/13/2016.
 * Edited by Johannes.
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
    
    MockMvc mockMvc;

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
        when(authentication.getPrincipal()).thenReturn(ADMIN_NAME);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        bindingResult = mock(BindingResult.class);
        user = createAdmin();
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        request.setSession(session);
        MockitoAnnotations.initMocks(this);
        setExceptionHandlers();
    }
    
    private void setExceptionHandlers() {
    	final ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver = new ExceptionHandlerExceptionResolver();
        //here we need to setup a dummy application context that only registers the GlobalControllerExceptionHandler
        final StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerBeanDefinition("advice", new RootBeanDefinition(RypController.class, null, null));
        //set the application context of the resolver to the dummy application context we just created
        exceptionHandlerExceptionResolver.setApplicationContext(applicationContext);
        //needed in order to force the exception resolver to update it's internal caches
        exceptionHandlerExceptionResolver.afterPropertiesSet();

        mockMvc = MockMvcBuilders.standaloneSetup(userController).setHandlerExceptionResolvers(exceptionHandlerExceptionResolver).build();
	}

	private User createAdmin() {
    	Role adminRole = new Role();
    	adminRole.setId(1);
    	adminRole.setType("ADMIN");
    	
    	User adminUser = new User();
        adminUser.setId(ID);
        adminUser.setUsername(ADMIN_NAME);
        adminUser.setEmail(ADMIN_EMAIL);
        adminUser.setPassword(ADMIN_PASSWORD);
        adminUser.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
        adminUser.setRegion(REGION_EUW);
        return adminUser;
	}
    
    private void asUser() {
    	Role userRole = new Role();
        userRole.setId(1);
        userRole.setType("USER");
    	user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    }

	/*
     * Controller to XML Mapping and access security tests
     */
    
    // List Users
    @Test
    public void testListUsers() throws Exception {
        request.getSession().setAttribute("remoteUser", user);
        assertEquals("userlist", userController.listUsers(model, request));
        assertEquals(service.findAllUsers(), model.get("users"));
        verify(service, atLeastOnce()).findAllUsers();
        verify(service, atLeastOnce()).findAllUsers();
    }

    public void testListUsersNoRemoteData() throws Exception {
        assertEquals("accessDenied", userController.listUsers(model, request));
        assertEquals(null, model.get("users"));
    }

    // Register User 
    @Test
    public void testRegisterGet() throws Exception {
    	assertEquals("register", userController.registerUser(model, request));
    	assertNotNull(model.get("user"));
    	assertEquals(null, ((User) model.get("user")).getId());
    }
    
    @Test
    public void testRegisterPost() throws Exception {
    	user.setUsername(UUID.randomUUID().toString()); // something that's not taken
    	assertEquals("login", userController.registerUser(user, bindingResult, model));
    }
    
    @Test
    public void testRegisterPostNoRegion() throws Exception {
    	user.setUsername("ThisNameIsProbablyNotTaken");
    	user.setRegion(null);
    	assertEquals("register", userController.registerUser(user, bindingResult, model));
    }
    
    
    // Edit User
    @Test
    public void testEditUserGetAsAdmin() throws Exception {
    	request.getSession().setAttribute("remoteUser", user);
    	assertEquals("newUser", userController.editUser("LeagueGuy1", model, request));
    }
    
    public void testEditUserGetAsUser() throws Exception {
    	asUser();
    	request.getSession().setAttribute("remoteUser", user);
    	assertEquals("accessDenied", userController.editUser("LeagueGuy1", model, request));
    }

    // Update
    @Test
    public void testUpdateUserPostAsAdmin() throws Exception {
    	request.getSession().setAttribute("remoteUser", user);
    	User userUser = new User();
    	userUser.setId(1338L);
    	userUser.setUsername("LeagueGuy1");
    	assertEquals("redirect:/list?createdUser=LeagueGuy1", userController.updateUser(userUser, bindingResult, model, "LeagueGuy1", request));
    }
    
    public void testUpdateUserPostAsUser() throws Exception {
    	asUser();
    	request.getSession().setAttribute("remoteUser", user);
    	User userUser = new User();
    	userUser.setId(1338L);
    	userUser.setUsername("LeagueGuy1");
    	assertEquals("accessDenied", userController.updateUser(userUser, bindingResult, model, "LeagueGuy1", request));
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