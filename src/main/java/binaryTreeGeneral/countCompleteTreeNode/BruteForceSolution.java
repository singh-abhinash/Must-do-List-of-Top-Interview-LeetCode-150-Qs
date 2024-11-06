package binaryTreeGeneral.countCompleteTreeNode;

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


//Brute force approach - O(n) time and O(logn) space
public class BruteForceSolution {
	public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Count the nodes in the left and right subtrees, then add 1 for the root
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
