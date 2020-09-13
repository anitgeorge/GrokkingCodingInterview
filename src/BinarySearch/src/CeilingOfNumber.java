class CeilingOfNumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if(arr == null || arr.length == 0)
            return -1;
        if(arr[0] > key )
            return 0;
        if(arr[arr.length -1] < key)
            return -1;
        int start = 0, end = arr.length - 1, mid = 0;
        while(start <= end){

            mid = start + (end - start) / 2;
            if(arr[mid] < key)
                start = mid + 1;
            else if(arr[mid] > key)
                end = mid - 1;
            else
                return mid;

        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}