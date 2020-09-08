/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTFromPreorder {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder== null || preorder.length == 0)
            return null;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] arr, int low, int high){

        if(idx >= arr.length)
            return null;
        int val = arr[idx];
        if(val < low || val > high)
            return null;
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = bstFromPreorder(arr, low, val);
        root.right = bstFromPreorder(arr, val, high);
        return root;
    }
}