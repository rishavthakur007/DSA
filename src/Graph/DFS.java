package Graph;

import java.util.ArrayList;

public class DFS {
	
	public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean []vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            dfs(i,adj,vis,ans);
        }
        return ans;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> ans){
        
        
        
        if(!vis[node]){
            ans.add(node);
            vis[node] = true;
            for(int var:adj.get(node)){
                dfs(var,adj,vis,ans);
            }
            
        }
    }

}
