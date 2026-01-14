package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth_Of_BT {
    class NodeInfo{
        int idx;
        TreeNode node;
        NodeInfo(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<NodeInfo> queue = new LinkedList<>();
        NodeInfo rootNode = new NodeInfo(root,0);
        queue.add(rootNode);
        while(!queue.isEmpty()){
            int n = queue.size();
            int left = 0;
            int right = 0;
            for(int i = 0;i<n;i++){
                NodeInfo node = queue.poll();
                if(i==0){
                    left = node.idx;
                }
                if(i==n-1){
                    right = node.idx;
                }
                TreeNode a = node.node;
                int index = node.idx;
                if(a.left!=null){
                    NodeInfo newNode = new NodeInfo(a.left,2*index+1);
                    queue.add(newNode);
                }
                if(a.right!=null){
                    NodeInfo newNode = new NodeInfo(a.right,2*index+2);
                    queue.add(newNode);
                }
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;

    }
}
