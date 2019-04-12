package com.seventeen.component.jwt;

/**
 * JWT相关配置
 *
 * @author seventeen
 * @date 2018/11/27
 */

public class JwtConfig {

    /**
     * 秘钥
     */
    public static final String SECRET = "__@@seventeen_seventeen_auth_rand_24uawGRjiq1015tfD_v2.0@@__";

    public static final String TOKEN = "token";

    /**
     * 有效时长
     */
    public static final int MAX_AGE = 30 * 24 * 60 * 60;
}
