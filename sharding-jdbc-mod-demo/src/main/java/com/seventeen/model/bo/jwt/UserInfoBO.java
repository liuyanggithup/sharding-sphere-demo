package com.seventeen.model.bo.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * jwtToken里面的用户信息
 *
 * @author seventeen
 * @date 2018/11/27
 */

@Data
public class UserInfoBO implements Serializable {

    private Long userId;

    private Integer userType;

    private String name;

    private String nickName;

    private String mobile;

}
