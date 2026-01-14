package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Course_Schedule_2 {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i= 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
    
        for(int[] arr:prerequisites){
            adjList.get(arr[1]).add(arr[0]);
        }
        
        int[] ans = new int[numCourses];
        int[] vis = new int[numCourses];
        Stack<Integer> stack = new Stack();
        for(int i =0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(i,adjList,vis,stack)){
                    return new int[0];
                }
            }
            
        }
        
        int k =0;
        while(!stack.isEmpty()){
            ans[k++] = stack.pop();
        }
        return ans;
    }

    public boolean dfs(int node,List<List<Integer>> adjList,int[] vis,Stack<Integer> stack){
        vis[node] = 1;
        for(int var : adjList.get(node)){
            if(vis[var]==1){
                return false;
            }
            else if(vis[var]==0){
                if(!dfs(var,adjList,vis,stack)){
                    return false;
                }
            }
            
        }
        vis[node] = 2;
        stack.add(node);
        return true;
    }

}
