package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            // both null → continue
            if (left == null && right == null) continue;

            // one null or values mismatch → not symmetric
            if (left == null || right == null || left.val != right.val)
                return false;

            // add children in mirrored order
            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
    public boolean dfs(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        return dfs(root1.left,root2.right) && dfs(root1.right,root2.left);
    }
}
