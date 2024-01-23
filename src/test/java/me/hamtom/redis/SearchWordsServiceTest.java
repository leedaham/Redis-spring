package me.hamtom.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchWordsServiceTest {

    @Autowired
    SearchWordsService service;
    @Test
    void test(){
        //given
        service.addSearchWord("test2", "검머");
        //when

        //then
    }
}