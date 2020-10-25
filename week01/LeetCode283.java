class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j = j + 1;
            }
        }
    }
}
