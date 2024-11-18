package binarySearchTree.kthSmallestElement;

import java.util.Stack;

public class IterativeApproach {
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        // Iterative in-order traversal
        while (!stack.isEmpty() || current != null) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the node from the stack
            current = stack.pop();
            count++;  // Increment count since we have visited a node

            // Check if this is the k-th smallest element
            if (count == k) {
                return current.val;
            }

            // Move to the right subtree
            current = current.right;
        }

        return -1;  // Edge case, in case k is out of bounds
    }
}
