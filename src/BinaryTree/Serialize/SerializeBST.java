/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder stb = new StringBuilder();
        serialize(root, stb);
        return stb.toString();
    }

    private void serialize(TreeNode root, StringBuilder stb){

        if(root == null)
            return;
        stb.append(root.val).append(" ");
        serialize(root.left,stb);
        serialize(root.right,stb);
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] arr = data.split(" ");
        return deserialize(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int idx = 0;
    private TreeNode deserialize(String[] arr, int low, int high){

        if(idx >= arr.length)
            return null;
        int val = Integer.parseInt(arr[idx]);
        if(val < low || val > high)
            return null;
        idx++;
        TreeNode root = new TreeNode(val);
        root.left     = deserialize(arr, low, val);
        root.right    = deserialize(arr, val, high);
        return root;
    }
}
