package deveideAndConquer.convertSortedArrayToBST;

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

public class InorderApproach {
	public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length -1);
    }

    public TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int p = left + (right - left)/2;

        // Preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = createBST(nums, left, p-1);
        root.right = createBST(nums, p+1, right);
        return root;
    }
}
