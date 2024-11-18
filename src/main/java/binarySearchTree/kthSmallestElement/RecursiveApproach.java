package binarySearchTree.kthSmallestElement;

class TreeNode {
    int val;
    int nodeCount;  // Number of nodes in the subtree rooted at this node
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.nodeCount = 1;  // Initialize the node count to 1 (itself)
    }
}

public class RecursiveApproach {
	private int count = 0; // Tracks how many nodes have been visited
    private int result = 0; // Stores the result once we reach the k-th smallest
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;

        // Traverse left subtree
        inOrder(node.left, k);

        // Increment count and check if this is the k-th smallest element
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse right subtree
        inOrder(node.right, k);
    }
}
