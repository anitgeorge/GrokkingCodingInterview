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
class BuildBTFromPreAndIn {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0
                || inorder.length != preorder.length
        )
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        idx = 0;
        return build(preorder, idx, preorder.length - 1, map);
    }

    private TreeNode build(int[] pre, int start, int end, Map<Integer, Integer> map){

        if(start > end)
            return null;
        TreeNode root = new TreeNode(pre[idx++]);
        if(start == end)
            return root;
        root.left  = build(pre, start, map.get(root.val) - 1, map);
        root.right = build(pre, map.get(root.val) + 1, end, map);
        return root;
    }
}