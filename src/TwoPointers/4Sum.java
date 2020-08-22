class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null || nums.length < 4)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= nums.length - 4; i++)
            for(int j = i + 1; j <= nums.length - 3; j++)
                search(nums, i, j, target, list);
        return list;
    }

    private void search(int[] nums, int first, int second, int target
            , List<List<Integer>> list){

        int left = second + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[first] + nums[second] + nums[left] + nums[right];
            if(sum == target)
                list.add(new ArrayList<>(Arrays.asList(nums[first], nums[second],
                        nums[left++], nums[right--])));
            else if(sum < target)
                left++;
            else
                right--;
        }
    }
}