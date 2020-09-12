/**
 *
 * Given a number ‘n’, write a function to return the count of structurally unique
 * Binary Search Trees (BST) that can store values 1 to ‘n’.
 *
 * @author anitgeorge
 */

import java.util.HashMap;
import java.util.Map;

public class CountTreesMemo {

    Map<Integer, Integer> map = new HashMap<>();

    public int countTrees(int n){
        if(map.containsKey(n))
            return map.get(n);
        if(n <= 1)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = countTrees(i - 1);
            int right = countTrees(n - i);
            count += left * right;
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        CountTrees ct = new CountTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
