package com.yb.project.redisson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext
public class RedisBitmapCommandTest {

    @Autowired
    private RedisTemplate redisTemplate;

    private String register = "register";

    @BeforeEach
    void setUp() {
        redisTemplate.delete(register);
    }

    @AfterEach
    void tearDown() {
        // redisTemplate.delete(register);
    }

    @Test
    void setBit_outOfRange() {
        // ERR bit offset is not an integer or out of range
        assertThrows(InvalidDataAccessApiUsageException.class,
                () -> {
                    redisTemplate.opsForValue().setBit(register,(long)512*1024*1024*8,true);
                });
    }

    @Test
    void setBit_happyPath() {
        // 512M
        redisTemplate.opsForValue().setBit(register,(long)512*1024*1024*8-(long)1,true);
    }

    @Test
    void bitCount_happyPath() {
        redisTemplate.opsForValue().setBit(register,(long)512*1024*1024*8-(long)1,true);
        Long bitCount = (Long)redisTemplate.execute((RedisCallback<Long>) connection -> {
            return connection.stringCommands().bitCount(redisTemplate.getKeySerializer().serialize(register));
        });
        assertEquals(bitCount,1);
    }

    @Test
    void keySerializer_happyPath() {
        redisTemplate.execute((RedisCallback<Boolean>) connection->{
            return connection.stringCommands().setBit(register.getBytes(),Integer.MAX_VALUE,true);
        });
        Long bitCount = (Long)redisTemplate.execute((RedisCallback<Long>) connection -> {
            return connection.stringCommands().bitCount(register.getBytes());
        });
        assertEquals(bitCount,1);
    }

    @Test
    void bitmapMax_happyPath() {
        // 4294967296
        System.out.println((long)512*1024*1024*8);
        // 4294967296
        System.out.println((long)512*(long)1024*(long)1024*(long)8);
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
        // 4294967294
        System.out.println((long)Integer.MAX_VALUE+(long)Integer.MAX_VALUE);
    }
}
