public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        if(arr == null || arr.length == 0)
            return -1;
        int start = 0;
        for(int num : arr)
            start ^= num;
        return start;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}