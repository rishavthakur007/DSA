package Binary_Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Bottom_View {
    class Pair{
        TreeNode node;
        int x;
        Pair(TreeNode node,int x){
            this.node = node;
            this.x = x;
        }
    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            map.put(p.x,p.node.val);
            if(p.node.left != null){
                queue.offer(new Pair(p.node.left,p.x-1));
            }
            if(p.node.right!=null){
                queue.offer(new Pair(p.node.right,p.x+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
