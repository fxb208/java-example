package com.yb.project.redisson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
public class HyperLogLogTest {

    @Autowired
    private RedisTemplate redisTemplate;

    String hll = "hll";

    String hll1 = "hll1";

    String hll2 = "hll2";

    @BeforeEach
    void setUp() {
        redisTemplate.delete(hll);
        redisTemplate.delete("hll1");
        redisTemplate.delete("hll2");
    }

    @AfterEach
    void tearDown() {
        redisTemplate.delete(hll);
        redisTemplate.delete("hll1");
        redisTemplate.delete("hll2");
    }

    @Test
    void add_happyPath() {
        redisTemplate.opsForHyperLogLog().add(hll,"fxb");
        redisTemplate.opsForHyperLogLog().add(hll,"32");
        assertEquals(redisTemplate.opsForHyperLogLog().size(hll), 2);
    }

    @Test
    void union_happyPath() {
        redisTemplate.opsForHyperLogLog().add(hll1,"fxb");
        redisTemplate.opsForHyperLogLog().add(hll1,"32");
        redisTemplate.opsForHyperLogLog().add(hll2,"cy");
        redisTemplate.opsForHyperLogLog().union(hll,hll1,hll2);
        assertEquals(redisTemplate.opsForHyperLogLog().size(hll), 3);
    }
}
