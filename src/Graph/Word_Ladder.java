package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        
        for(String str:wordList){
            dict.add(str);
        }

        if(!dict.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i=0;i<n;i++){
                String str = queue.poll();
                if(str.equals(endWord)){
                    return level;
                }
                char[] arr = str.toCharArray();
                for(int j =0;j<str.length();j++){
                    char c = arr[j];
                    for(char ch='a';ch<='z';ch++){
                        if(c==ch){
                            continue;
                        }
                        arr[j] = ch;
                        String newStr = new String(arr);
                        if(dict.contains(newStr)){
                            queue.offer(newStr);
                            dict.remove(newStr);
                        }
                    }
                    arr[j] = c;
                }

            }
            level++;
        }
        return 0;

        
    }
}
