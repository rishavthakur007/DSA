package Binary_Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalTraversal {
    class Node{
        int val;
        int x;
        int y;
        Node(int val,int x,int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> listNode = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,listNode,0,0);
        Collections.sort(listNode,(a, b)->{
            if(a.x!=b.x)    return a.x-b.x;
            if(a.y!=b.y)    return a.y-b.y;
            return a.val-b.val;
        });
        int prevX = -10005;
        List<Integer> varr = new ArrayList<>();
        for(Node node : listNode){
            if(node.x!=prevX){
                if(!varr.isEmpty()) ans.add(varr);
                varr = new ArrayList<>();
                prevX=node.x;
            }
            varr.add(node.val);
        }
        ans.add(varr);
        return ans;


    }
    public void dfs(TreeNode root,List<Node> listNode,int x,int y){
        if(root==null){
            return ;
        }
        Node node = new Node(root.val,x,y);
        listNode.add(node);
        dfs(root.left,listNode,x-1,y+1);
        dfs(root.right,listNode,x+1,y+1);
    }
}
