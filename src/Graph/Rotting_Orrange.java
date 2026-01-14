package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Orrange {
	
public int orangesRotting(int[][] grid) {
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && fresh>0){
            int z = queue.size();
            time++;
            for(int s=0;s<z;s++){
                int[] var = queue.poll();
                for(int i = 0;i<4;i++){
                    int ci = var[0]+dir[i][0];
                    int cj = var[1]+dir[i][1];
                    if(ci>=0 && cj>=0 && ci<n && cj<m && grid[ci][cj]==1){
                        grid[ci][cj] = 2;
                        queue.offer(new int[]{ci,cj});
                        fresh--;
                    }
                }
            }
        }

        return fresh>0?-1:time;
    }

}
