package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims_Algo {
	
	public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i =0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int []arr: edges){
            adjList.get(arr[0]).add(new int[]{arr[1],arr[2]});
            adjList.get(arr[1]).add(new int[]{arr[0],arr[2]});
        }
        
        boolean[] vis = new boolean[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        pq.offer(new int[]{0,0});
        
        int ans = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int node = temp[1];
            int wt = temp[0];
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            ans += wt;
            for(int[] v: adjList.get(node)){
                int newNode = v[0];
                int newWt = v[1];
                if(!vis[newNode]){
                    pq.offer(new int[]{v[1],v[0]});
                }
            }
        }
        return ans;
    }

}
