package me.hamtom.redis;

import me.hamtom.redis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
}
