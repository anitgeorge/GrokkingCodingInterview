/**
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
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
 *
 * @author anitgeorge
 */
class BuildBTFromPostAndIn {
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || inorder.length == 0
                || postorder == null || postorder.length == 0
                || inorder.length != postorder.length
        )
            return null;
        idx = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(postorder, 0, idx, map);
    }

    private TreeNode build(int[] postorder, int start, int end, Map<Integer, Integer> map){

        if(start > end)
            return null;
        TreeNode root = new TreeNode(postorder[idx--]);
        if(start == end)
            return root;
        root.right = build(postorder, map.get(root.val) + 1, end, map);
        root.left  = build(postorder, start, map.get(root.val) - 1, map);
        return root;
    }
}