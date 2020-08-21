/**
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates
 * in-place return the new length of the array.
 *
 * @author anitgeorge
 */

class RemoveDuplicates {

    public static int remove(int[] arr) {
        if(arr == null || arr.length == 0)
            return -1;
        int start = 0;
        arr[start] = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[start] != arr[i])
                arr[++start] = arr[i];
        return start + 1;
    }
}