package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/landing")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadForm() {
		
		ModelAndView modelAndView = new ModelAndView("landing");
		List<UserEntity> users = populate();
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}

	private List<UserEntity> populate() {
		UserEntity user1 = new UserEntity("Tim", new Date(), 100.00);
		UserEntity user2 = new UserEntity("Kim", new Date(), 50.00);
		UserEntity user3 = new UserEntity("Sim", new Date(), 25.00);
		UserEntity user4 = new UserEntity("Dim", new Date(), 12.50);
		
		List<UserEntity> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		return users;
	}

}
