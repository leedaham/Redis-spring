package me.hamtom.redis;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchWordsService {
    private final StringRedisTemplate stringRedisTemplate;

    public SearchWordList addSearchWord(String userId, String searchWord) {
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        String orgWords = stringValueOperations.get(userId);

        List<String> words = new ArrayList<>();
        if (orgWords == null) {
            words.add(searchWord);
        } else {
            List<String> orgWordList =
                    Arrays.stream(
                            orgWords
                                    .replace("[", "")
                                    .replace("]", "")
                                    .replace(" ","")
                                    .split(","))
                            .toList();
            words.addAll(orgWordList);
            words.remove(searchWord);
            if (words.size() >= 5) {
                words = words.subList(0, 4);
            }
            words.add(0, searchWord);
        }
        stringValueOperations.set(userId, String.valueOf(words));

        return new SearchWordList(userId, stringValueOperations.get(userId));
    }

    public SearchWordList getSearchWordList(String userId) {
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        String orgWords = stringValueOperations.get(userId);
        if (orgWords == null) {
            orgWords = "no words history";
        }
        return new SearchWordList(userId, orgWords);
    }


    @Data
    static class SearchWordList {
        private String userId;
        private String searchWords;

        public SearchWordList(String userId, String searchWords) {
            this.userId = userId;
            this.searchWords = searchWords;
        }
    }
}
