package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_2 {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        bfs(beginWord, endWord, dict, map);

        if (!map.containsKey(endWord))
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(map, ans, path, beginWord, endWord);

        return ans;

    }

    public void bfs(String beginWord, String endWord,
            Set<String> dict, Map<String, Integer> map) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        map.put(beginWord, 0);

        int level = 0;
        Set<String> usedOnLevel = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int s = 0; s < size; s++) {
                String curr = queue.poll();
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original)
                            continue;

                        arr[i] = ch;
                        String next = new String(arr);

                        if (dict.contains(next) && !map.containsKey(next)) {
                            map.put(next, level);
                            queue.offer(next);
                            usedOnLevel.add(next);
                        }
                    }
                    arr[i] = original;
                }
            }

            for (String word : usedOnLevel)
                dict.remove(word);

            usedOnLevel.clear();

            if (map.containsKey(endWord))
                break;

        }
    }

    public void dfs(Map<String, Integer> map,
            List<List<String>> ans,
            List<String> path,
            String beginWord,
            String word) {

        if (word.equals(beginWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int step = map.get(word);
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == original)
                    continue;

                arr[i] = ch;
                String prev = new String(arr);

                if (map.containsKey(prev) && map.get(prev) == step - 1) {
                    path.add(0, prev);
                    dfs(map, ans, path, beginWord, prev);
                    path.remove(0);
                }
            }
            arr[i] = original;
        }
    }

}
