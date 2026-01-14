package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Detect_Cycle_DG {
	
	public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i =0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int []arr:edges){
            adjList.get(arr[0]).add(arr[1]);
        }
        
        int[] state = new int[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0;i<V;i++){
            if(state[i]==0){
                if(!dfs(i,adjList,stack,state)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean dfs(int node,List<List<Integer>> adjList,Deque<Integer> stack,int[] state){
        state[node] = 1;
        
        for(int v:adjList.get(node)){
            if(state[v]==1){
                return false;
            }else if(state[v]==0){
                if(!dfs(v,adjList,stack,state)){
                    return false;
                }
            }
        }
        stack.push(node);
        state[node] = 2;
        return true;
    }

}
