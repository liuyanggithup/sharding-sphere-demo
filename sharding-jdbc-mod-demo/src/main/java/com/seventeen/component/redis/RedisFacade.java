package com.seventeen.component.redis;

/**
 * Redis调用封装
 * @author seventeen
 * @date 2018/11/15
 */

public interface RedisFacade {

    boolean lock(String key);

    void set(String key, String value, long timeout);

    String get(String key);
}
