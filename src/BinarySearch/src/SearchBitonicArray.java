public class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        if(arr == null || arr.length == 0)
            return -1;
        int pivot = findPivot(arr);
        int index = binarySearch(arr, 0, pivot, key, false);
        if(index != -1)
            return index;
        return binarySearch(arr, pivot, arr.length - 1, key, true);
    }

    private static int findPivot(int arr[]){
        int start = 0, end = arr.length - 1, mid = 0;
        while(start < end){
            mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private static int binarySearch(int arr[], int left, int right, int key, boolean flag){

        int start = left, end = right, mid = 0;
        while(start <= end){
            mid  = start + (end - start) / 2;
            if(arr[mid] == key)
                return mid;
            if(arr[mid] > key){
                if(flag)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else{

                if(flag)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}