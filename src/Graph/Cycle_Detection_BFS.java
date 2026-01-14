package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Cycle_Detection_BFS {
	
	public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int []var : edges){
            adjList.get(var[0]).add(var[1]);
            adjList.get(var[1]).add(var[0]);
            
        }
        
        boolean[] vis = new boolean[V];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i =0;i<V;i++){
            if(!vis[i]){
                queue.offer(new int[]{i,-1});
               
                while(!queue.isEmpty()){
                    int[] arr = queue.poll();
                    
                    vis[arr[0]] = true;
                    for(int var:adjList.get(arr[0])){
                        if(!vis[var]){
                            queue.offer(new int[]{var,arr[0]});
                        }else if(var!=arr[1]){
                            return true;
                        }
                    }
                    
                }
            }
        }
        
        return false;
        
    }

}
