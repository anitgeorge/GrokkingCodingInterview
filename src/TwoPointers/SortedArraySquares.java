/**
 *
 * Given a sorted array, create a new array containing squares of
 * all the number of the input array in the sorted order.
 *
 * @author anitgeorge
 */

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {

        if(arr == null || arr.length == 0)
            return new int[]{};
        int[] squares = new int[arr.length];
        int start = 0, end = arr.length - 1, high = squares.length - 1;
        while(start <= end){
            if(arr[start] * arr[start] >= arr[end] * arr[end]){
                squares[high--] = arr[start] * arr[start];
                start++;
            } else{
                squares[high--] = arr[end] * arr[end];
                end--;
            }
        }
        return squares;
    }
}
