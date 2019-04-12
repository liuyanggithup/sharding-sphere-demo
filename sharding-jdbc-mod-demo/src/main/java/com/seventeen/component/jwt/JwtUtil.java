package com.seventeen.component.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.seventeen.model.bo.jwt.LoginTokenBO;
import com.seventeen.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * JWT工具类
 * @author seventeen
 * @date 2018/11/27
 */

public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 生成 登录令牌
     */
    public static String signToken(LoginTokenBO token) {
        return sign(JSON.toJSONString(token));
    }

    /**
     * 解密 登录令牌
     */
    public static LoginTokenBO unsignToken(String jwtToken) {
        String json = unsign(jwtToken);

        try {
            return JSON.parseObject(json, LoginTokenBO.class);
        } catch (JSONException e) {
            log.error("解密登录令牌失败，json不合法");
            return null;
        }
    }

    /**
     * 生成一个JWT令牌, 默认的过期时间
     *
     * @return the jwt token
     */
    public static String sign(String token) {
        return sign(token, JwtConfig.MAX_AGE);
    }

    /**
     * 生成一个JWT令牌，可设置过期时间
     *
     * @param token 令牌信息
     * @param timeout 过期时间，单位秒
     * @return the jwt token
     */
    public static String sign(String token, int timeout) {
        // 使用HS256算法
        Algorithm algorithm = Algorithm.HMAC256(JwtConfig.SECRET);

        return JWT.create()
                .withClaim(JwtConfig.TOKEN, token)
                .withExpiresAt(DateUtils.getAddSecondDate(new Date(), timeout))
                .sign(algorithm);
    }

    /**
     * 对JWT令牌进行解密
     *
     * @param jwtToken JWT令牌
     * @return POJO object
     */
    public static String unsign(String jwtToken) {
        DecodedJWT jwt = null;
        try {
            jwt = JWT.decode(jwtToken);
        } catch (JWTDecodeException e){
           log.error("jwtToken异常，exception: ", e);
           return null;
        }

        if (jwt == null) {
            return null;
        }
        // 验证是否有效
        Date exp = jwt.getExpiresAt();
        if (exp == null) {
            log.error("不合法token，过期时间为空");
            return null;
        }
        if (exp.before(new Date())) {
            log.error("过期时间已到，token失效");
            return null;
        }
        Claim token1 = jwt.getClaim(JwtConfig.TOKEN);
        if (token1 == null) {
            return null;
        }

        return token1.asString();
    }

    public static void main(String[] args) {
        LoginTokenBO token = new LoginTokenBO();
        token.setCreateTime(System.currentTimeMillis());
        token.setDomainCode(1);
        token.setHashCode("222231xaa");

        String s2 = signToken(token);
        System.out.println(s2);
        System.out.println(unsignToken(s2));
    }
}
