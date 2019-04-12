package com.seventeen.webapps.controller.app;

import com.seventeen.biz.service.UserService;
import com.seventeen.model.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试读写分离接口
 *
 * @author: seventeen
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


    @GetMapping("/getById")
    public Object getById(Long id) {
        return userService.getById(id);
    }

    @GetMapping("/findById")
    public Object findById(Long id) {
        return userService.findById(id);
    }


    @GetMapping("/list")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    public Object add(Long id,String city, String name) {

        UserBO userBO = new UserBO();
        userBO.setId(id);
        userBO.setCity(city);
        userBO.setName(name);
        return userService.add(userBO);
    }

}
