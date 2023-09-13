package example.micronaut;

import io.lettuce.core.api.StatefulRedisConnection;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

@MicronautTest
class RedisTest {

    private final StatefulRedisConnection<String, String> redisConnection;

    public RedisTest(StatefulRedisConnection<String, String> redisConnection) {
        this.redisConnection = redisConnection;
    }

    @Test
    void testRedis() {
        var key = UUID.randomUUID();
        redisConnection.sync().set(key.toString(), "argle");
        var value = redisConnection.sync().get(key.toString());

        Assertions.assertEquals("argle", value);
    }
}