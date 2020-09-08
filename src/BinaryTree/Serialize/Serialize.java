/**
 *
 * <p>
 *     https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * </p>
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * @author anitgeorge
 */
public class Serialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder stb = new StringBuilder();
        serialize(root, stb);
        return stb.toString();
    }

    private void serialize(TreeNode root, StringBuilder stb){

        if(root == null){
            stb.append("#").append(" ");
            return;
        }
        stb.append(root.val).append(" ");
        serialize(root.left, stb);
        serialize(root.right, stb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue){

        if(queue.isEmpty())
            return null;
        String str = queue.poll();
        if(str.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left     = deserialize(queue);
        root.right    = deserialize(queue);
        return root;
    }
}