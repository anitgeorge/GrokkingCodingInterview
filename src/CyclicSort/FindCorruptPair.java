class FindCorruptPair {

    public static int[] findNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int  i = 0;
        while(i < nums.length){

            int j = nums[i] - 1;
            if(nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        for(i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                return new int[]{nums[i], i + 1};

        return new int[]{-1, -1};
    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }
}
