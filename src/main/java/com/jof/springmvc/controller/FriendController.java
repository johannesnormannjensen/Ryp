package com.jof.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;
import com.jof.springmvc.service.FriendService;
import com.jof.springmvc.service.RiotApiService;
import com.jof.springmvc.service.RoleService;
import com.jof.springmvc.service.UserService;

@Controller
@RequestMapping("/user/friend")
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
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model, HttpServletRequest request) {

        User remoteUser = new User();

        if (request.getSession().getAttribute("remoteUser") != null) {
            remoteUser = (User) request.getSession().getAttribute("remoteUser");
        }
        
        List<User> users = userService.getFriendsAsUsers(friendService.findAllFriends(remoteUser),remoteUser);
        
        model.addAttribute("users", users);

        return "friendList";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * registering a new user in the database. It also validates the user input
     */
    @RequestMapping(value = {"/deleteFriendship{omegaId}"}, method = RequestMethod.GET)
    public String deleteFriendship(@PathVariable String omegaId, HttpServletRequest request) {
        // DELETE FRIENDSHIP HERE
    	
    	 User remoteUser = new User();

         if (request.getSession().getAttribute("remoteUser") != null) {
             remoteUser = (User) request.getSession().getAttribute("remoteUser");
         }
    	
    	friendService.deleteByIds(remoteUser, userService.findById(Long.valueOf(omegaId)));
    	
        return "redirect:/user/friend/list";
    }
    
    
    @RequestMapping(value = {"/acceptFriendshipRequest{alphaId}"}, method = RequestMethod.GET)
    public String acceptFriendRequest(@PathVariable String alphaId, HttpServletRequest request) {
        // DELETE FRIENDSHIP HERE
    	
    	 User remoteUser = new User();

         if (request.getSession().getAttribute("remoteUser") != null) {
             remoteUser = (User) request.getSession().getAttribute("remoteUser");
         }
    	
         User alpha = userService.findById(Long.valueOf(alphaId));
         
         Friend friend = friendService.findFriendshipByIds(alpha, remoteUser);
         
         friend.setAccepted(true);
         
         friendService.updateFriend(friend);
        
        return "redirect:/user/friend/list";
    }
    
    @RequestMapping(value = {"/sendFriendshipRequest{omegaId}"}, method = RequestMethod.GET)
    public String sendFriendRequest(@PathVariable String omegaId, HttpServletRequest request) {
    	
    	 User remoteUser = new User();

         if (request.getSession().getAttribute("remoteUser") != null) {
             remoteUser = (User) request.getSession().getAttribute("remoteUser");
         }
         
         Friend friend = friendService.findFriendshipByIds(remoteUser, userService.findById(Long.valueOf(omegaId)));         
         
         if(friend != null)
         {        	 
        	 if(friend.getActive() && friend.getAccepted())// || friend.getActive() && !friend.getAccepted())
        	 {
        		 return "redirect:/user/friend/list";
        	 }
        	 
        	 if(friend.getActive() && !friend.getAccepted())
        	 {
        		 if(friend.getAlpha_user().getId().equals(remoteUser.getId()))
        		 {
        			 return "redirect:/user/friend/listSent";
        		 }
        		 else
        		 {
        			 return "redirect:/user/friend/listIncoming";
        		 }        		
        	 }
        	 
        	 if(!friend.getActive())
        	 {
        		 friend.setActive(true);
            	 friend.setAccepted(false);
            	 friend.setAlpha_user(remoteUser);
            	 friend.setOmega_user(userService.findById(Long.valueOf(omegaId)));
            	 
            	 friendService.updateFriend(friend);
        	 }
        	 
         }
         else
         {
        	 friend = new Friend();
        	 friend.setAlpha_user(remoteUser);
             friend.setOmega_user(userService.findById(Long.valueOf(omegaId)));
             friend.setAccepted(false);
             friend.setActive(true);
             
             friendService.saveFriend(friend);
         }              
    	
        return "redirect:/user/friend/listSent";
    }
    
    @RequestMapping(value = {"/listIncoming"}, method = RequestMethod.GET)
    public String listIncomingFriendRequests(ModelMap model, HttpServletRequest request) {

        User remoteUser = new User();

        if (request.getSession().getAttribute("remoteUser") != null) {
            remoteUser = (User) request.getSession().getAttribute("remoteUser");
        }
        
        List<User> users = userService.getFriendsAsUsers(friendService.findAllIncomingFriendRequests(remoteUser),remoteUser);
        
        model.addAttribute("users", users);

        return "listIncoming";
    }
    
    @RequestMapping(value = {"/listSent"}, method = RequestMethod.GET)
    public String listOutgoingFriendRequests(ModelMap model, HttpServletRequest request) {

        User remoteUser = new User();

        if (request.getSession().getAttribute("remoteUser") != null) {
            remoteUser = (User) request.getSession().getAttribute("remoteUser");
        }
        
        
        List<Friend> friends = friendService.findAllOutgoingFriendRequests(remoteUser);
        List<User> users = userService.getFriendsAsUsers(friends,remoteUser);
        
        model.addAttribute("users", users);

        return "listSent";
    }
    

}