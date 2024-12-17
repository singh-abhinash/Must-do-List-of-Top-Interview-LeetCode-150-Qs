package binaryTreeGeneral.pathSum;

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
	public boolean hasPathSum(TreeNode root, int targetSum) {
        return preorder(root, targetSum, 0);
    }

    public boolean preorder(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return false;
        
        currentSum += root.val;

        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }

        return preorder(root.left, targetSum, currentSum) || preorder(root.right, targetSum, currentSum);
    }
}
