package com.jof.springmvc.controller;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;
import com.jof.springmvc.service.FriendService;
import com.jof.springmvc.service.RiotApiService;
import com.jof.springmvc.service.RoleService;
import com.jof.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	UserService userService;

	@Autowired
	FriendService friendService;

    @Autowired
    RoleService roleService;
	@Autowired
	RiotApiService riotApiService;

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
	public String listUsers(ModelMap model, HttpServletRequest request) 
	{

		User remoteUser;

		if (request.getSession().getAttribute("remoteUser") == null) {
			remoteUser = (User) request.getSession().getAttribute("remoteUser");
		}

		// for testing
		remoteUser = userService.findById(BigInteger.valueOf(21232));

		List<Friend> friends = friendService.findAllFriends(remoteUser);
		List<User> users = userService.getFriendsAsUsers(friends);

		model.addAttribute("users", users);

		return "friendList";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * registering a new user in the database. It also validates the user input
	 */
	@RequestMapping(value = { "/delete{omegaId}" }, method = RequestMethod.GET)
	public String registerUser(@PathVariable String omegaId) {
		// DELETE FRIENDSHIP HERE

		return "redirect:/friend/list";
	}

}