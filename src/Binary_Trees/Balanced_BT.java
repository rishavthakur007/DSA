package Binary_Trees;

public class Balanced_BT {
    public boolean isBalanced(TreeNode root) {
        int[] arr = dfs(root);
        return arr[0]==1;
    }
    public int[] dfs(TreeNode root){

        if(root==null){
            return new int[]{1,0};
        }

        int []left = dfs(root.left);
        int []right = dfs(root.right);

        boolean isBalanced = left[0]==1 && right[0]==1 && Math.abs(left[1]-right[1])<=1;

        return new int[]{isBalanced?1:0,1+Math.max(left[1],right[1])};

    }
}
