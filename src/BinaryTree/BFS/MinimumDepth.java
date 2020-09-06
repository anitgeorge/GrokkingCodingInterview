import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
       if(root == null)
           return 0;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       int minDepth = 0;
       while(!queue.isEmpty()){

           int N = queue.size();
           ++minDepth;
           for(int i = 0; i < N; i++){

               TreeNode node = queue.poll();
               if(node.left == null && node.right == null)
                   return minDepth;
               if(node.left != null)
                   queue.offer(node.left);
               if(node.right != null)
                   queue.offer(node.right);
           }
       }
       return 0;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
