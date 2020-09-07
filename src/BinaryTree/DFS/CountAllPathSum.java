/**
 *
 * Given a binary tree and a number ‘S’, find all paths in the
 * tree such that the sum of all the node values of each path
 * equals ‘S’. Please note that the paths can start or end at
 * any node but all paths must follow direction from parent to
 * child (top to bottom).
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

class CountAllPathSum {

    int count = 0;
    public static int countPaths(TreeNode root, int S) {
        if(root == null)
            return 0;
        countPathUtil(root, S, new ArrayList<>());
        return count;
    }

    private static void  countPathUtil(TreeNode root, int S, List<Integer> currentPath){
        if(root == null)
            return;
        currentPath.add(root.val);
        ListIterator<Integer> itr = currentPath.listIterator(currentPath.size());
        int sum = 0;
        while(itr.hasPrevious()){
            sum += itr.previous();
            if(sum == S)
                count++;
        }
        countPathUtil(root.left, S, currentPath);
        countPathUtil(root.right, S, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
