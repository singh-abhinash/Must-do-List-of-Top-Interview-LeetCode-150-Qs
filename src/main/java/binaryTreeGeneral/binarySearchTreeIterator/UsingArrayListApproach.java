package binaryTreeGeneral.binarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
	     this.left = left;
	     this.right = right;
	 }
}

public class UsingArrayListApproach {
	private List<Integer> inorderList; // List to store the in-order traversal
    private int index; // Pointer to keep track of the current position in the list

    public UsingArrayListApproach(TreeNode root) {
        inorderList = new ArrayList<>();
        index = -1; // Start the pointer before the first element
        inorderTraversal(root); // Fill the list with in-order values
    }

    // Returns the next in-order value
    public int next() {
        index++; // Move the pointer to the next element
        return inorderList.get(index); // Return the value at the pointer
    }

    // Returns true if there are more nodes to process
    public boolean hasNext() {
        return index + 1 < inorderList.size(); // Check if there are more elements in the list
    }

    // Helper method to perform in-order traversal and store the values in a list
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left); // Visit the left subtree
        inorderList.add(node.val); // Store the current node value
        inorderTraversal(node.right); // Visit the right subtree
    }
}
