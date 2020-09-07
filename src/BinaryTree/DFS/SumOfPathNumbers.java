/**
 *
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number. Find the total sum of all
 * the numbers represented by all paths.
 *
 * @author anitgeorge
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    static int sum = 0;
    public static int findSumOfPathNumbers(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int num){

        if(root == null)
            return;
        num = num * 10 + root.val;
        if(root.left == null && root.right == null)
            sum += num;
        dfs(root.left, num);
        dfs(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
