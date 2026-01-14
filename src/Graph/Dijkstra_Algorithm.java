package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
	
	public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            
        pq.offer(new int[]{0, src});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if(d > dist[node]) continue;

            for(int[] edge : adj.get(node)){
                int next = edge[0];
                int wt = edge[1];

                if(dist[node] + wt < dist[next]){
                    dist[next] = dist[node] + wt;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;

    }
}
