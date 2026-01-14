package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Min_Effort {
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int wt = arr[0];
            int x = arr[1];
            int y = arr[2];
            if(wt>dist[x][y]){
                continue;
            }
            if(x==n-1 && y==m-1){
                return wt;
            }
            for(int j=0;j<4;j++){
                int xi = x+dir[j][0];
                int yj = y+dir[j][1];
                if(xi>=0 && yj>=0 && xi<n && yj<m){
                    int newWt = Math.max(Math.abs(heights[x][y]-heights[xi][yj]),wt);
                    if(dist[xi][yj]>newWt){
                        dist[xi][yj] = newWt;
                        pq.offer(new int[]{dist[xi][yj],xi,yj});
                    }
                }
            }
        }
        return 0;
        
    }


}
