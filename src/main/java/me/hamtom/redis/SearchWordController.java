package me.hamtom.redis;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.hamtom.redis.SearchWordsService.SearchWordList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SearchWordController {

    private final SearchWordsService service;

    @GetMapping("/get/{userId}")
    public SearchWordList getWordList(@PathVariable(name = "userId") String userId) {
        return service.getSearchWordList(userId);
    }

    @PostMapping("/add")
    public SearchWordList addWordList(
            @RequestBody AddWordCommand addWordCommand) {
        return service.addSearchWord(addWordCommand.userId, addWordCommand.searchWord);
    }

    @Data
    static class AddWordCommand {
        private String userId;
        private String searchWord;
    }
}
