package com.seventeen.model.bo.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * jwtToken里面的登录信息
 *
 * @author seventeen
 * @date 2018/11/27
 */

@Data
public class LoginTokenBO implements Serializable {

    private UserInfoBO userInfo;
    /** 单点登录 */
    private String hashCode;
    /** 作用域 */
    private Integer domainCode;

    private Long createTime;

}
