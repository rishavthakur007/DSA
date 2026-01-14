package Binary_Trees;

public class Max_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, Integer.MIN_VALUE };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Upward contribution (can ignore negative branches)
        int maxUpward = Math.max(0, Math.max(left[0], right[0])) + root.val;

        // Best path *through* this node
        int maxThroughNode = Math.max(root.val,
                Math.max(root.val + left[0], root.val + right[0]));

        // Best full split path (left + node + right)
        int fullPath = left[0] + root.val + right[0];

        // Global max among:
        int maxGlobal = Math.max(left[1], Math.max(right[1], Math.max(maxThroughNode, fullPath)));

        return new int[] { maxUpward, maxGlobal };
    }
}
