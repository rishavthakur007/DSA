package Graph;

import java.util.Arrays;

public class BelmanFord {
	
	public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist,100000000);
        dist[src] = 0;
        
        for(int i =0;i<V-1;i++){
            for(int []arr:edges){
                int u = arr[0];
                int v = arr[1];
                int wt = arr[2];
                if(dist[u]!=100000000 && dist[u]+wt<dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        for(int []arr:edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            if(dist[u]!=100000000 && dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
        
    }

}
