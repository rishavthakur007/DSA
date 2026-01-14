package Graph;

import java.util.Arrays;

public class Bipertite_Graph {

	public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i =0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(graph,0,i,color)){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean dfs(int[][] graph,int col,int val,int[] color){
        color[val] = col;
        for(int var:graph[val]){
            if(color[var]==-1){
                if(!dfs(graph,1-col,var,color)){
                    return false;
                }
            }else if(color[var]==col){
                return false;
            }
        } 
        return true;
    }
}
