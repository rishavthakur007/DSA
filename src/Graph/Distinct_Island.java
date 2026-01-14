package Graph;

import java.util.HashSet;
import java.util.Set;

public class Distinct_Island {
	
	int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Set<String> isLands = new HashSet<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    StringBuilder temp = new StringBuilder();
                    dfs(grid,i,j,temp,i,j,visited);
                    isLands.add(temp.toString());
                    
                }
            }
        }
        
        return isLands.size();
        
    }
    
    void dfs(int[][] grid,int i,int j,StringBuilder temp,int x,int y,boolean[][] vis){
        vis[i][j] = true;
        temp.append('#');
        temp.append(String.valueOf(i-x));
        temp.append(String.valueOf(j-y));
        for(int s=0;s<4;s++){
            int row = i+dir[s][0];
            int col = j+dir[s][1];
            if(row>=0 && row<grid.length && col<grid[0].length && col>=0 && !vis[row][col] && grid[row][col]==1){
                dfs(grid,row,col,temp,x,y,vis);
            }
        }
    }

}
