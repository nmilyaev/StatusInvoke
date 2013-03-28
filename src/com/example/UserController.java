package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping(value = "/landing")
public class UserController {
	private final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("userForm") UserForm userForm) {		
		ModelAndView modelAndView = new ModelAndView("landing");
		modelAndView.addObject("users", populate());	
		userForm.setUsers(populate());		
		return modelAndView;
	}
	
	@RequestMapping(value = "/find_user", method = RequestMethod.GET)
	public @ResponseBody List<String> findUser(@RequestParam("term") String name) {
		log.info("Search string for user name: " + name);	
		List<String> users = new ArrayList<String>();
		users.add("Sam");
		users.add("Dan");
		return users;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("userForm") UserForm userForm) {
		log.info("called post... view will not show anything");
		for(UserEntity user : userForm.getUsers()) {
			log.info(user);
		}
		return new ModelAndView("view");
	}

	private List<UserEntity> populate() {
		UserEntity user1 = new UserEntity("Tim", DateTime.now().plusDays(10), 100.00, UserType.NEW);
		UserEntity user2 = new UserEntity("Kim", DateTime.now().minusDays(10), 50.00, UserType.NEW);
		UserEntity user3 = new UserEntity("Sim", DateTime.now(), 25.00, UserType.NEW);
		UserEntity user4 = new UserEntity("Dim", DateTime.now(), 12.50, UserType.NEW);
		
		List<UserEntity> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		return users;
	}

}
