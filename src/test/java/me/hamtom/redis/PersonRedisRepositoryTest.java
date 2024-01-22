package me.hamtom.redis;

import me.hamtom.redis.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRedisRepositoryTest {

    @Autowired
    private PersonRedisRepository repo;

    @Test
    void test() {
        Person person = new Person("Park", 20);

        // 저장
        repo.save(person);

        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
        repo.count();

        // `keyspace:id` 값을 가져옴
        Person person1 = repo.findById(person.getId()).get();
        System.out.println("person1 = " + person1.toString());


        // 삭제
//        repo.delete(person);
    }

}