package me.hamtom.redis.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@Getter
@RedisHash(value = "people", timeToLive = 30)
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
    private LocalDateTime created;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.created = LocalDateTime.now();
    }
}
