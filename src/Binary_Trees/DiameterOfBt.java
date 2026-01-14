package Binary_Trees;

public class DiameterOfBt {
    public int diameterOfBinaryTree(TreeNode root) {
        int []arr = dfs(root);
        return arr[1]-1;
    }
    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{Math.max(left[0],right[0])+1,Math.max(left[1],Math.max(right[1],left[0]+right[0]+1))};
    }
}
