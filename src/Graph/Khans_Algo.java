package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Khans_Algo {
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        
        int[] indeg=new int[V];
        int []ans=new int[V];
        for(int i=0;i<V;i++){
            for(int v:adj.get(i)){
                indeg[v]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int k=0;
        while(!q.isEmpty()){
            int v=q.poll();
            ans[k++]=v;
            for(int var:adj.get(v)){
                indeg[var]--;
                if(indeg[var]==0){
                    q.add(var);
                }
            }
        }
        return ans;
    }
    
    
    


}
