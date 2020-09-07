/**
 *
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the
 * longest path between any two leaf nodes. The diameter
 * of a tree may or may not pass through the root.
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

class TreeDiameter {
    static int diameter;
    public static int findDiameter(TreeNode root) {
        if(root == null)
            return 0;
        diameter = Integer.MIN_VALUE;
        height(root);
        return diameter;
    }

    private static int height(TreeNode root){

        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, (1 + lh + rh));
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
