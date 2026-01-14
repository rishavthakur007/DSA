package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class OX_region {
	int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(board[i][0]=='O'){
                queue.offer(new int[]{i,0});
            }
        }

        for(int i = 0;i<n;i++){
            if(board[i][m-1]=='O'){
                queue.offer(new int[]{i,m-1});
            }
        }

        for(int i = 0;i<m;i++){
            if(board[0][i]=='O'){
                queue.offer(new int[]{0,i});
            }
        }

        for(int i = 0;i<m;i++){
            if(board[n-1][i]=='O'){
                queue.offer(new int[]{n-1,i});
            }
        }

        boolean[][] vis = new boolean[n][m];

        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i =0;i<s;i++){
                int[] arr = queue.poll();
                vis[arr[0]][arr[1]]=true;
                for(int j=0;j<4;j++){
                    int row = arr[0] + dir[j][0];
                    int col = arr[1] + dir[j][1];
                    if(row>=0 && col>=0 && row<n && col<m && board[row][col]!='X' && !vis[row][col]){
                        queue.offer(new int[]{row,col});
                    }
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(vis[i][j]){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

    }

}
