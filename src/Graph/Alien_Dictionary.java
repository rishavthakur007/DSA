package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alien_Dictionary {
	
	public String findOrder(String[] words) {
        // code here
        Map<Character, List<Character>> map = new HashMap<>();
        boolean[] present = new boolean[26];

        // mark all characters
        for (String w : words) {
            for (char c : w.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // build graph
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int j = 0;

            while (j < prev.length() && j < curr.length()
                    && prev.charAt(j) == curr.charAt(j)) {
                j++;
            }

        // prefix invalid
            if (j == curr.length() && prev.length() > curr.length()) {
                return "";
            }

            if (j < prev.length() && j < curr.length()) {
                map.computeIfAbsent(prev.charAt(j),
                        k -> new ArrayList<>())
                .add(curr.charAt(j));
            }
        }

        int[] visited = new int[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && visited[i] == 0) {
                if (!dfs((char)(i + 'a'), map, visited, stack)) {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    public boolean dfs(char node,
                   Map<Character, List<Character>> map,
                   int[] visited,
                   Deque<Character> stack) {

        visited[node - 'a'] = 1;

        for (char ch : map.getOrDefault(node, new ArrayList<>())) {
            if (visited[ch - 'a'] == 1) return false;
            if (visited[ch - 'a'] == 0) {
                if (!dfs(ch, map, visited, stack)) return false;
            }
        }

        visited[node - 'a'] = 2;
        stack.push(node);
        return true;
    }

}
