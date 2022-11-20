/*
 * Copyright (c) 2018-2022, Syrius Robotics Co. Ltd.
 */
package com.yb.project.redisson;


import io.lettuce.core.ReadFrom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
public class RedisCluster_invokeTest {

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private LettuceConnectionFactory lettuceConnectionFactory;

  @Value("${yb.redis.lock.name}")
  private String name;

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void string_happyPath() {
    for(int i=0;i<10;i++){
      redisTemplate.opsForValue().set(name+"::"+i,"key");
    }
    for(int i=0;i<10;i++){
      System.out.println(redisTemplate.opsForValue().get(name+"::"+i));
    }
  }

}
