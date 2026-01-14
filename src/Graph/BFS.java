package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean []vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
           
            
            int node = queue.poll();
            if(!vis[node]){
                ans.add(node);
                for(int child:adj.get(node)){
                    queue.offer(child);
                }
                vis[node] = true;
            }
            
            
            
            
        }
        return ans;
    }

}
