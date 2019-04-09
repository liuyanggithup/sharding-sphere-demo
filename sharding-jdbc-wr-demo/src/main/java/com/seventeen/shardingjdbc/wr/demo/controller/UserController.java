package com.seventeen.shardingjdbc.wr.demo.controller;

import com.seventeen.shardingjdbc.wr.demo.po.User;
import com.seventeen.shardingjdbc.wr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Object users() {
		return userService.users();
	}


	@GetMapping("/user")
	public Object users(Long id) {
		return userService.getById(id);
	}

	@GetMapping("/list")
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/add")
	public Object add(String city,String name) {


		User user = new User();
		user.setCity(city);
		user.setName(name);
		return userService.add(user);
	}
	
}
