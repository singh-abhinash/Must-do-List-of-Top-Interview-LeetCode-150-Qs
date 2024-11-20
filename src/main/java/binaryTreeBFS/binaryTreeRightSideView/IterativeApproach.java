package binaryTreeBFS.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

// Time Complexity: O(n) and Space Complexity: O(n)
public class IterativeApproach {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                lastNode = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // Add the last node of the current level to the result
            if (lastNode != null) {
                result.add(lastNode.val);
            }
        }

        return result;
    }
}
