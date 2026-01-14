package Binary_Trees;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {
    ArrayList<Integer> boundaryTraversal(TreeNode root) {

        // code here

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // Root should be added only if it's not a leaf
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        // 1️⃣ Add Left Boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // 2️⃣ Add Leaf Nodes
        addLeaves(root, result);

        // 3️⃣ Add Right Boundary (reversed)
        addRightBoundary(root.right, result);

        return result;
    }


    // Helper to check if node is leaf
    boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }


    // 1️⃣ Left Boundary
    void addLeftBoundary(TreeNode node, ArrayList<Integer> result) {

        while (node != null) {
            if (!isLeaf(node)) result.add(node.val);

            // Prefer left path, fallback to right if left doesn't exist
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }


    // 2️⃣ Leaf Traversal
    void addLeaves(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }


    // 3️⃣ Right Boundary (reverse order)
    void addRightBoundary(TreeNode node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);

            // Prefer right path first
            if (node.right != null) node = node.right;
            else node = node.left;
        }

        // Right boundary must be added in reverse
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
