package Binary_Trees;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null)
            return ans;

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            ans.addFirst(node.val); // ADD AT FRONT
            if (node.left != null)
                st.push(node.left);
            if (node.right != null)
                st.push(node.right);
        }
        return ans;
    }
}
