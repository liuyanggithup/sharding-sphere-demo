package com.seventeen.shardingjdbc.wr.demo.service;

import com.seventeen.shardingjdbc.wr.demo.po.User;
import com.seventeen.shardingjdbc.wr.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author: xia_xun
 * @Date: 2019/4/8
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;

	@Override
	public List<User> list() {
		// 强制路由主库
		//HintManager.getInstance().setMasterRouteOnly();
		return userRepository.list();
	}

	@Override
	public Long add(User user) {
		return userRepository.addUser(user);
	}

}
