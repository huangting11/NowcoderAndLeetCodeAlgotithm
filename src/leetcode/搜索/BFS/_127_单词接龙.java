package leetcode.搜索.BFS;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author Huangting
 * @Time 2020/1/26
 */
public class _127_单词接龙 {

    public static void main(String[] args) {
        _127_单词接龙 _127_ = new _127_单词接龙();
        _127_.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
             }
        }
        return 0;
    }
}
