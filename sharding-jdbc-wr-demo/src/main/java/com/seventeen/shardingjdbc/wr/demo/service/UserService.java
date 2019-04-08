package com.seventeen.shardingjdbc.wr.demo.service;

import com.seventeen.shardingjdbc.wr.demo.po.User;

import java.util.List;
/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */
public interface UserService {

	List<User> list();
	
	Long add(User user);
	
}
