package me.hamtom.redis.entity;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class RecentlySearchWords {
    private String userId;
    private int wordNumLimit = 5;
    private List<String> recentlySearchWordList = new ArrayList<>();

    public RecentlySearchWords(String userId) {
        this.userId = userId;
    }

    public RecentlySearchWords(String userId, List<String> recentlySearchWordList) {
        this.userId = userId;
        this.recentlySearchWordList = recentlySearchWordList;
    }

    public void addSearchWord(String word) {
        recentlySearchWordList.add(word);
    }
    public void removeDuplicate(String word) {
        recentlySearchWordList.remove(word);
    }
    public void removeFirst() {
        recentlySearchWordList.remove(0);
    }
    public boolean isFullList() {
        return recentlySearchWordList.size() >= wordNumLimit;
    }
    public boolean isContain(String word) {
        return recentlySearchWordList.contains(word);
    }

}
