package binaryTreeGeneral.countCompleteTreeNode;


//Optimized approach - O(logn*logn) time and O(logn*logn) spaceS
public class OptimizedSolution {
	public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the leftmost path
        int leftHeight = getLeftHeight(root);
        // Calculate the height of the rightmost path
        int rightHeight = getRightHeight(root);

        // If left and right heights are the same, the tree is full and balanced
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // 2^height - 1
        } else {
            // Otherwise, count nodes in left and right subtree
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
