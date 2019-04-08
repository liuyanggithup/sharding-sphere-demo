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
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/add")
	public Object add() {
		User user = new User();
		user.setId(100L);
		user.setCity("深圳");
		user.setName("李四");
		return userService.add(user);
	}
	
}
