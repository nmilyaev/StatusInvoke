package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping(value = "/landing")
public class UserController {
	private final Log log = LogFactory.getLog(getClass());
	
	/** Works if I populate using this method */
//	@ModelAttribute("userForm") 
//    public UserForm setupForm() {
//		UserForm userForm = new UserForm();
//		userForm.setUsers(populate());
//      return userForm;
//    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("userForm") UserForm userForm) {		
		ModelAndView modelAndView = new ModelAndView("landing");
		modelAndView.addObject("users", populate());	
		userForm.setUsers(populate());
		
//		UserForm userForm = new UserForm();
//		userForm.setUsers(populate());
//		modelAndView.addObject("userForm", userForm);
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("userForm") UserForm userForm) {
		log.info("called post");
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
