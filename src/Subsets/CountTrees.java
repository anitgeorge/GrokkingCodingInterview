/**
 *
 * Given a number ‘n’, write a function to return the count of structurally unique
 * Binary Search Trees (BST) that can store values 1 to ‘n’.
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

class CountTrees {
    public static int countTrees(int n) {
        if(n <= 1)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = countTrees(i - 1);
            int right = countTrees(n - i);
            count += left * right;
        }
        return count;
    }

    public static void main(String[] args) {
        CountTrees ct = new CountTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
