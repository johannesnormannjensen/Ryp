package com.jof.springmvc.controller;

import com.jof.springmvc.model.User;
import com.jof.springmvc.model.UserProfile;
import com.jof.springmvc.service.RiotApiService;
import com.jof.springmvc.service.UserProfileService;
import com.jof.springmvc.service.UserService;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;


@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    UserService userService;

    @Autowired
    RiotApiService riotApiService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    /**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model, HttpServletRequest request) {
		User remoteUser;
		if (request.getSession().getAttribute("remoteUser") == null) {
			remoteUser = (User) request.getSession().getAttribute("remoteUser");
		}
		//TODO GET LIST OF FRIENDS RELATED TO REMOTE USER HERE INSTEAD
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		
		return "friendList";
	}

    /**
     * This method will be called on form submission, handling POST request for
     * registering a new user in the database. It also validates the user input
     */
    @RequestMapping(value = {"/delete{omegaId}"}, method = RequestMethod.GET)
    public String registerUser(@PathVariable String omegaId) {
    	//DELETE FRIENDSHIP HERE
    	
    	return "redirect:/friend/list";
    }
	

}