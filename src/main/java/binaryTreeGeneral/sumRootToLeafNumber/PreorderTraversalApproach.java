package binaryTreeGeneral.sumRootToLeafNumber;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreorderTraversalApproach {
	public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }

    public int preorder(TreeNode root, int sumTillCurrNode) {
        if (root == null) 
            return 0;

        // Calculate the sum for the current node
        sumTillCurrNode = sumTillCurrNode * 10 + root.val;

        // If it's a leaf node, add the path sum to the total sum
        if (root.left == null && root.right == null) 
            return sumTillCurrNode;

        // Recur for left and right subtrees
        return preorder(root.left, sumTillCurrNode) + preorder(root.right, sumTillCurrNode);
    }
}
