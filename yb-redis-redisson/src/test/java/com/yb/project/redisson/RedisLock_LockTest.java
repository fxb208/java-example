/*
 * Copyright (c) 2018-2022, Syrius Robotics Co. Ltd.
 */
package com.yb.project.redisson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
public class RedisLock_LockTest {

  @Autowired
  RedissonClient redissonClient;

  @Value("${yb.redis.lock.name}")
  private String name;

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void lockName_happyPath() {
    RLock lock = redissonClient.getLock(name);
    try{
      lock.lock();
      Thread.sleep(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    assertEquals(lock.getName(), name);
  }

  @Test
  void keys_happyPath() {
    Iterable<String> keys = redissonClient.getKeys().getKeys();
    keys.forEach(key->{
      System.out.println(key);
    });
  }
}
