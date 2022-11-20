package com.yb.project.luttece.lock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisLock {

  @Resource
  RedisTemplate redisTemplate;

  @Value("${yb.redis.lock.name}")
  private String name;

  public String lockName() {
    redisTemplate.opsForValue().setIfAbsent(name,1);
    return name;
  }
}
