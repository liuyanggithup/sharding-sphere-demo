package com.seventeen.component.redis.impl;

import com.seventeen.component.redis.RedisFacade;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis调用实现
 * @author seventeen
 * @date 2018/11/15
 */

@Component(value = "redisFacade")
public class RedisFacadeImpl implements RedisFacade {

    private final static String DEFAULT_LOCK_VALUE = "1";
    private final static long DEFAULT_LOCK_TIME = 3L;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean lock(String key) {
        Boolean b = stringRedisTemplate.opsForValue()
                .setIfAbsent(key, DEFAULT_LOCK_VALUE, DEFAULT_LOCK_TIME, TimeUnit.SECONDS);
        return b != null && b;
    }

    @Override
    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        Object o = stringRedisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        }
        return o.toString();
    }
}
