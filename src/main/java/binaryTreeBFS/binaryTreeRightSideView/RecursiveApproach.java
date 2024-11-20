package binaryTreeBFS.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

// Time complexity = O(n) and Space Complexity = O(n)
public class RecursiveApproach {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null) return;

        // If the current depth is equal to the size of the result list, it means
        // this is the first node we are encountering at this depth.
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Prioritize the right child first for the right side view.
        dfs(node.right, result, depth + 1);
        dfs(node.left, result, depth + 1);
    }
}
