/**
 *
 * Given a number ‘n’, write a function to return all structurally unique
 * Binary Search Trees (BST) that can store values 1 to ‘n’?
 *
 * @author anitgeorge
 */

import java.util.*;

class UniqueBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
    public static List<TreeNode> findUniqueTrees(int n) {
        if(n == 0)
            return new ArrayList<>();
        return findUniqueTrees(1, n);
    }
    private static List<TreeNode> findUniqueTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++){

            List<TreeNode> left  = findUniqueTrees(start, i - 1);
            List<TreeNode> right = findUniqueTrees(i + 1, end);
            for(TreeNode lNode : left)
                for(TreeNode rNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left  = lNode;
                    root.right = rNode;
                    list.add(root);
                }
        }
        return list;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueBST.findUniqueTrees(3);
        System.out.print("Total trees: " + result.size());
    }
}
