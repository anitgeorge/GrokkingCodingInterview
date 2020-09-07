import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if(root == null)
            return allPaths;
        findPaths(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void findPaths(TreeNode root, int sum,
                                  List<Integer> currentPath, List<List<Integer>> result){

        if(root == null)
            return;
        currentPath.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else{
            findPaths(root.left, sum - root.val, currentPath, result);
            findPaths(root.right, sum - root.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
