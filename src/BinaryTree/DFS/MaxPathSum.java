/**
 *
 * <p>
 *     https://www.educative.io/courses/grokking-the-coding-interview/B89q6NpX0Vx
 * </p>
 * Find the path with the maximum sum in a given binary tree.
 * Write a function that returns the maximum sum. A path can
 * be defined as a sequence of nodes between any two nodes and
 * doesn’t necessarily pass through the root.
 *
 * @author anitgeorge
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class MaxPathSum {

    public static int maxSum;
    public static int findMaximumPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        maxSumUtil(root);
        return maxSum;
    }

    private static int maxSumUtil(TreeNode root){

        if(root == null)
            return 0;
        int lSum = Math.max(maxSumUtil(root.left), 0);
        int rSum = Math.max(maxSumUtil(root.right), 0);
        maxSum   = Math.max(maxSum, (root.val + lSum + rSum));
        return root.val + Math.max(lSum, rSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));
    }
}
